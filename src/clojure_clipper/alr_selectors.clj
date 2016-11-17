(ns clojure-clipper.alr-selectors
  (:require [net.cgrand.enlive-html :as html]))

(def nutrition-items ["sodiumContent" "calories" "fatContent" "saturatedFatContent"
                      "transFatContent" "carbohydrateContent" "fiberContent" "proteinContent" "cholestrolContent"])
(defn without-Content [title]
  (let [to-index (or (clojure.string/index-of title "Content")
                     (count title))
        without (.substring title 0 to-index)]
    without))
(defn nutrient-unit [raw-info]
  (-> raw-info :content second clojure.string/trim))
(defn nutrient-amount [raw-info]
  (-> raw-info :content first :content first clojure.string/trim read-string))
(defn nutrient-title [raw-info]
  (-> raw-info :attrs :itemprop without-Content))

(defn alr-nutrition-selector [container]
  (let [
        tags (html/select container [:ul :li])
        nutrition-tags (filter #(.contains nutrition-items (-> % :attrs :itemprop))
                               tags)
        values (reduce (fn [acc raw-info]
                         (let [title (nutrient-title raw-info)
                               amount (nutrient-amount raw-info)
                               unit (nutrient-unit raw-info)]
                           (assoc acc title [amount unit])))
                       {}
                       nutrition-tags)
        ]
    values))

