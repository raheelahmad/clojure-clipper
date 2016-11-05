(ns clojure-clipper.properties
  (:require [net.cgrand.enlive-html :as html]))

(def schema-selector (html/attr= :itemtype "http://schema.org/Recipe"))
(defn prop-selector [prop] (html/attr= :itemprop prop))

(defn get-prop-container [content prop from-top]
  ;; Get the container inside which we will find the property
  (first
   (html/select content
                (if from-top
                  [schema-selector (prop-selector prop)]
                  [(prop-selector prop)])
                )))

(defn default-container [content prop]
  (get-prop-container content prop true))
(defn prop-container [content prop]
  (get-prop-container content prop false))

(def properties
  {
   :name {:key "name"
          :container-selector default-container
          :property-selector {
                              :nyt #(first (:content %))
                              :alr #(:content (:attrs %))
                              }
          }
   :image {
           :key "image"
           :container-selector default-container
           :property-selector #(:src (:attrs %))
           }
   :description {
                  :key "description"
                  :container-selector default-container
                  :property-selector {:nyt #(:content (second (:content %)))
                                      :alr #(:content (:attrs %))}
                  }
   :instructions {
                  :key "recipeInstructions"
                  :container-selector prop-container
                  :property-selector {:nyt #(:content (second (:content %)))
                                      :alr (fn [cont]
                                             (->>
                                              cont
                                              :content
                                              (filter #(= (:tag %) :li))
                                              (map #(:content %))
                                              (map #(first %))
                                              (map #(:content %))
                                              (map #(first %))))
                                     }
                  }
   })

;; (def source-properties
;;   {:nyt })

