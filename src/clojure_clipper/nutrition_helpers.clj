(ns clojure-clipper.nutrition-helpers
  (:require [net.cgrand.enlive-html :as html]
            [camel-snake-kebab.core :refer :all]))

(def nutrition-items ["sodiumContent" "calories" "fatContent" "saturatedFatContent"
                      "transFatContent" "carbohydrateContent" "fiberContent" "proteinContent" "cholestrolContent"
                      "cholesterolContent"])
(defn without-Content [title]
  (let [to-index (or (clojure.string/index-of title "Content")
                     (count title))
        without (.substring title 0 to-index)]
    without))
(defn remove-nils [some-map]
  (into {} (filter (comp some? val) some-map)))

(defn alr-nutrient-unit [raw-info]
  (-> raw-info :content second clojure.string/trim))
(defn alr-nutrient-amount [raw-info]
  (-> raw-info :content first :content first clojure.string/trim read-string))
(defn epic-nutrient-unit [raw-info]
  (let [raw-string (-> raw-info :content first clojure.string/trim)
        components (re-find #"(\d+)(\s+)?(\w+)?\(?(\d+)?%?\)?" raw-string)
        amount (get components 1)
        unit (get components 3)
        percent (get components 4)]
    { :amount amount :unit unit :percent percent }))
(defn epic-nutrient-amount [raw-info]
  (-> raw-info :content first :content first clojure.string/trim read-string))
(defn nutrient-title [raw-info]
  (-> raw-info :attrs :itemprop without-Content ->kebab-case))

(defn alr-nutrition-selector [container]
  (let [tags (html/select container [:ul :li])
        nutrition-tags (filter #(.contains nutrition-items (-> % :attrs :itemprop))
                               tags)
        values (reduce (fn [acc raw-info]
                         (let [title (nutrient-title raw-info)
                               amount (alr-nutrient-amount raw-info)
                               unit (alr-nutrient-unit raw-info)]
                           (assoc acc (keyword title) {:amount amount :unit unit})))
                       {}
                       nutrition-tags)
        ]
    values))

(defn epic-nutrition-selector [container]
  (let [top-tags (html/select container [:ul :li])
        tags (->>
              top-tags
              (map :content)
              (apply concat))
        nutrition-tags (filter #(.contains nutrition-items (-> % :attrs :itemprop))
                               tags)
        values (reduce (fn [acc raw-info]
                         (let [title (nutrient-title raw-info)
                               amount-unit-map (epic-nutrient-unit raw-info)
                               info {(keyword title) amount-unit-map}
                               ]
                           acc
                           (assoc acc (keyword title) amount-unit-map)
                           ))
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
                                                  (let [pair (clojure.string/split as-one-string #" ")
                                                        amount (read-string (first pair))
                                                        unit (second pair)
                                                        pair-again (if (some? unit)
                                                                     {:amount amount :unit unit }
                                                                     {:amount amount})
                                                        ]
                                                    pair-again))]
                           (if (not (clojure.string/blank? title))
                             (assoc acc (keyword title) amount-unit-pair)
                             acc)))
                       {}
                       tags)]
    values))


