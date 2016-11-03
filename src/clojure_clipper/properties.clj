(ns clojure-clipper.properties
  (:require [net.cgrand.enlive-html :as html]))

(def schema-selector (html/attr= :itemtype "http://schema.org/Recipe"))
(def prop-selector (html/attr= :itemprop prop))

(defn get-prop-container [content prop from-top]
  (first
   (html/select content
                (if from-top
                  [schema-selector prop-selector]
                  [prop-selector])
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
                                     :alr #(:content (:attrs %))}
                 }

   ;; :instructions #(:src (:attrs %))
   ;; :description {:nyt #(:content (second (:content %)))
   ;;               :alr #(:content (:attrs %))}
   })

;; (def source-properties
;;   {:nyt })

