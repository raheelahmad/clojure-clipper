(ns clojure-clipper.nyt-selectors)

(defn- get-nyt-ingredient [input] (-> input
                                 :content
                                 first))

(defn nyt-ingredient-selector [container]
  "Select ingredients from the ingredient container for NYT. Much malarkey is needed."
  (->>
   container
   (map :content)
   (reduce (fn [acc val]
             (concat acc
                     (filter #(.contains ["quantity" "ingredient-name"] (-> % :attrs :class))
                             val)))
           [])
   (map :content)
   (partition 2)
   (map (fn [[first-val second-val]]
          (let [amount (first first-val)
                first-of-second-val (first second-val)
                second-of-second-val (second second-val)
                ingredient-in-first-of-second (get-nyt-ingredient first-of-second-val)
                ingredient-in-second-of-second (get-nyt-ingredient second-of-second-val)
                ingredient (or ingredient-in-second-of-second
                               (get-nyt-ingredient first-of-second-val))
                unit (if (nil? ingredient-in-first-of-second) first-of-second-val)]
            {:amount amount :unit unit :ingredient ingredient}))))
  )
