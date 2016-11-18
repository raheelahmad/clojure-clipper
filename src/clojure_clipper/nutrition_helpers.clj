(ns clojure-clipper.nutrition-helpers
  (:require [net.cgrand.enlive-html :as html]
            [camel-snake-kebab.core :refer :all]))

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


(defn nyt-nutrition-selector [container]
  (let [
        tags (->> container :content)
        values (reduce (fn [acc raw-info]
                         (let [
                               title (->> raw-info :attrs :itemprop (filter some?)
                                          (apply str) without-Content
                                          ->kebab-case
                                          )
                               amount-unit (-> raw-info :content first)
                               amount-unit-pair (when-let [as-one-string amount-unit]
                                                  (let [
                                                        pair (clojure.string/split as-one-string #" ")
                                                        amount (read-string (first pair))
                                                        unit (second pair)
                                                        pair-again (if (some? unit)
                                                                     [amount unit]
                                                                     [amount])
                                                        ]
                                                    pair-again))
                               ;; amount (read-string (first amount-unit-pair))
                               ;; unit (second amount-unit-pair)
                               ]
                           (if (not (clojure.string/blank? title))
                             (assoc acc title amount-unit-pair)
                             acc)
                           ))
                       {}
                       tags)
        ]
    values))


