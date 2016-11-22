(ns clojure-clipper.ingredient-parser
  (:require [inflections.core :as infl]))

(def conjugates
  ["or" "to"])
(def unit-names
  ["tablespoon" "tbsp" "teaspoon" "tsp"
   "oz" "ounce"
   "lb" "pound"
   "cup" "glass" "spoon" "pinch"
   ])

(defn- parse-number
  "Returns the passed string if a number. Otherwise nil"
  [s]
  (if (re-find #"^-?\d+\.?\d*$" s)
    s))

(defn- unicode-fraction?
  "Returns string if it's a unicode fraction (with fancy / replaced). E.g. ½ → 1/2.
  Returns nil if not fractional"
  [num]
  (if-let [parsed (java.text.Normalizer/normalize num java.text.Normalizer$Form/NFKC)]
    (if (.contains parsed "⁄")
      (clojure.string/replace parsed "⁄" "/"))))

(defn- fraction?
  "Returns a string if it is a fraction. E.g. 1/2"
  [num]
  (let [comps (clojure.string/split num #"/")]
    (when (> (count comps) 1)
      (if (every? #(some? (parse-number %)) comps)
        num))))

(defn- amount?
  "If given string is an amount or not (i.e., numeric)"
  [amount-string]
  (or
   (parse-number amount-string)
   (fraction? amount-string)
   (unicode-fraction? amount-string)))

(defn- amount-phrase?
  "ie., 2 to 4, 4 or 6"
  [comps]
  (let [third (get comps 2)
        has-conjugate (.contains conjugates (second comps))
        has-amounts (and (amount? (first comps))
                         (amount? third))]
    (and has-conjugate has-amounts)))

(defn- parse-amount-from-components
  "Returns an amount if found"
  [comps]
  (let [fst (first comps)
        snd (second comps)
        thrd (first (drop 2 comps))]
    (if (and (amount? fst) (amount? snd))
      [(str fst " " snd) (drop 2 comps)] ; "For two numbers together, e.g. 3 1/2 or 2 4"
      (if (amount-phrase? comps)
        [(str fst " " snd " " thrd) (drop 3 comps)]
        (if (amount? fst) ; otherwise if first is amount...
          [(amount? fst) (rest comps)]
          [nil comps])))))

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

(defn parse-ingredient
  "Parse an ingredient string (e.g., 3 tablespoons olive oil)
  into a map with :amount :unit :ingredient"
  [in]
  (let [
        comps (clojure.string/split in #" ")
        [amount rest-after-amount] (parse-amount-from-components comps)
        [unit rest-after-unit] (parse-unit-from-components rest-after-amount)
        ingredient (clojure.string/trim (clojure.string/join " " rest-after-unit))
        ]
    {:amount amount :unit unit :ingredient ingredient}))

