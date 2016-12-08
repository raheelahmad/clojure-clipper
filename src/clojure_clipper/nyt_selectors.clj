(ns clojure-clipper.nyt-selectors
  (:require [net.cgrand.enlive-html :as html]
            [clojure-clipper.ingredients.parser :as parser]))


(defn- get-ingredient [input] (-> input
                                 :content
                                 first))

(defn- get-component [input]
  (or (-> input
          :content
          first)
      (first input)))

(defn parse-comp
  "Normalize a component to string.
  Component could be
  ('6')
  or
  (
    {:tag :span, :attrs nil, :content ('olive oil')}
    ', a little warm'
  )
  ... Notice that in the second form, there could be multiple elements,
  where after the first map they are strings to be concatenated.
  "
  [input]
  (if (= (count input) 1)
    (first input)
    (->> input
         (map #(or (get-ingredient %) (identity %)))
         (apply str)
         )))

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
          (let [
                fst-comp (parse-comp first-val)
                snd-comp (parse-comp second-val)
                comps (apply str fst-comp " " snd-comp) ; comps finally has "3 tablespoon olive oil" format
                ]
            (parser/parse-ingredient comps)))))
  )
