(ns clojure-clipper.ingredient-parser
  (:require [inflections.core :as infl]))

(defn parse-number
  "Returns the passed string if a number. Otherwise nil"
  [s]
  (if (re-find #"^-?\d+\.?\d*$" s)
    s))

(defn unicode-fraction?
  "Returns string if it's a unicode fraction (with fancy / replaced). E.g. ½ → 1/2.
  Returns nil if not fractional"
  [num]
  (if-let [parsed (java.text.Normalizer/normalize num java.text.Normalizer$Form/NFKC)]
    (if (.contains parsed "⁄")
      (clojure.string/replace parsed "⁄" "/"))))

(defn fraction?
  "Returns a string if it is a fraction. E.g. 1/2"
  [num]
  (let [comps (clojure.string/split num #"/")]
    (when (> (count comps) 1)
      (if (every? #(some? (parse-number %)) comps)
        num))))

(defn amount?
  [amount-string]
  (or
   (parse-number amount-string)
   (fraction? amount-string)
   (unicode-fraction? amount-string)))

(defn parse-amount-from-components
  "Returns an amount if found"
  [comps]
  (let [fst (first comps)
        snd (second comps)]
    (if (and (amount? fst) (amount? snd))
      [(str fst " " snd) (drop 2 comps)] ; "For two numbers together, e.g. 3 1/2 or 2 4"
      (if (amount? fst)
        [(amount? fst) (rest comps)]
        [nil comps]))))

(def unit-names
  ["tablespoon" "tbsp" "teaspoon" "tsp"
   "oz" "ounce"
   "lb" "pound"
   "cup" "glass" "spoon" "pinch"
   ])

(defn parse-unit-from-components
  [comps]
  (let [maybe-unit (first comps)
        ]
    (if
        (or
         (.contains unit-names maybe-unit)
         (some #{maybe-unit} (map infl/plural unit-names)))
      [maybe-unit (rest comps)]
      [nil comps])))

(defn parse-ingredient [in]
  (let [comps (clojure.string/split in #" ")
        [amount rest-after-amount] (parse-amount-from-components comps)
        [unit rest-after-unit] (parse-unit-from-components rest-after-amount)
        ingredient (clojure.string/join " " rest-after-unit)
        ]
    {:amount amount :unit unit :ingredient ingredient}))

(parse-ingredient "teaspoon ground cumin")
(parse-ingredient "1 2/3 cups ground cumin")
(parse-ingredient "1 2/3 teaspoons ground cumin")
(parse-ingredient "12/2 tablespoons olive oil")
(parse-ingredient "½ teaspoon ground cumin")

