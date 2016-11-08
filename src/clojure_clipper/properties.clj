(ns clojure-clipper.properties
  (:require [net.cgrand.enlive-html :as html]
            [clojure.string :as str]))

(def schema-selector (html/attr= :itemtype "http://schema.org/Recipe"))
(defn prop-selector [prop] (html/attr= :itemprop prop))

(defn get-prop-container [content prop from-top]
  ;;; Get the container inside which we will find the property
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

(defn default-post-processor [value]
  (->>
   value
   (apply str) ;; stringify
   str/trim
   str/trim-newline)
  )

(defn add-space-as-needed [string]
  (if (Character/isSpace (first string))
    string
    (str " " string)))

(defn post-process-as-sentence [string]
  (let
      [sentences (map clojure.string/trim (clojure.string/split string #"\."))
       with-period (interpose ". " sentences)
       components (concat with-period ["."])
       result (apply str components)]
    result))

(def properties
  {
   :ingredients {
                 :key "recipeIngredient"
                 :container-selector (fn [content prop]
                                       (html/select content [(html/attr= :itemprop prop)]))
                 :property-selector {
                                     :nyt (fn [cont]
                                            (
                                             ->> cont
                                             (map :content)
                                             (reduce (fn [acc val]
                                                       (concat acc
                                                               (filter #(.contains ["quantity" "ingredient-name"] (-> % :attrs :class)) val)))
                                                     [])
                                             ))
                                     }
                 :post-processor #(identity %)
                 }
   }
  )

(def propertieso
  {
   :name {
          :key "name"
          :container-selector {
                               :nyt (fn [cont]
                                       )
                               }
          :property-selector {
                              :nyt #(first (:content %))
                              :alr #(:content (:attrs %))
                              }
          }
   :image {
           :key "image"
           :property-selector #(:src (:attrs %))
           }
   :description {
                 :key "description"
                 :property-selector {:nyt #(:content (second (:content %)))
                                     :alr #(:content (:attrs %))}
                  }
   :instructions {
                  :key "recipeInstructions"
                  :container-selector prop-container
                  :post-processor #(->> %
                                        default-post-processor
                                        )
                  :property-selector {
                                      :nyt (fn [cont]
                                             (->>
                                              cont
                                              :content
                                              (filter #(= (:tag %) :li))
                                              (map #(:content %))
                                              (map #(first %))
                                              ))
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
   }
  )

;; (def source-properties
;;   {:nyt })

