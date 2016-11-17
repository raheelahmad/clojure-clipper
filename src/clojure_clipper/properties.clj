(ns clojure-clipper.properties
  (:require [net.cgrand.enlive-html :as html]
            [clojure.string :as str]
            [clojure-clipper.nyt-selectors :as nyt-helper]
            [clojure-clipper.alr-selectors :as alr-helper]
            ))

(def schema-selector (html/attr= :itemtype "http://schema.org/Recipe"))
(defn prop-selector [prop] (html/attr= :itemprop prop))

(defn get-prop-container [content prop from-top]
  ;;; Get the container inside which we will find the property
  (first
   (html/select content
                (if from-top
                  [schema-selector (prop-selector prop)]
                  [(prop-selector prop)]))))

(defn default-container [content property]
  (get-prop-container content property true))
(defn prop-container [content property]
  (get-prop-container content property false))

(defn default-post-processor [value]
  (->>
   value
   (apply str) ;; stringify
   str/trim
   str/trim-newline))

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
  {:ingredients {:key "recipeIngredient"
                 :container-selector {:alr (fn [content prop]
                                             (html/select content [(html/attr= :itemprop "ingredients")]))
                                      :nyt (fn [content prop]
                                             (html/select content [(html/attr= :itemprop prop)]))}
                 :property-selector {:nyt nyt-helper/nyt-ingredient-selector
                                     :alr #(->> % (map :content) (map first))}
                 :post-processor #(identity %)}

   :name {:key "name"
          :property-selector {:nyt #(first (:content %))
                              :alr #(:content (:attrs %))}}
   :author {:key "author"
            :container-selector {:nyt default-container
                                 :alr prop-container}
            :property-selector #(first (:content %))}
   :nutrition {:key "nutrition"
               :container-selector {:nyt default-container
                                    :alr prop-container}
               :property-selector {:nyt alr-helper/alr-nutrition-selector
                                   :alr alr-helper/alr-nutrition-selector}
               :post-processor identity}
   :prep-time {:key "prepTime"
               :container-selector {:nyt default-container
                                    :alr prop-container}
               :property-selector {:nyt #(:content (:attrs %))
                                   :alr #(:datetime (:attrs %))}}
   :cook-time {:key "cookTime"
               :container-selector {:nyt default-container
                                    :alr prop-container}
               :property-selector {:nyt #(:content (:attrs %))
                                   :alr #(:datetime (:attrs %))}}
   :total-time {:key "totalTime"
               :container-selector {:nyt default-container
                                    :alr prop-container}
               :property-selector {:nyt #(:content (:attrs %))
                                   :alr #(:datetime (:attrs %))}}
   :yield {:key "recipeYield"
           :container-selector {:nyt default-container
                                :alr prop-container}
           :property-selector {:nyt #(first (:content %))
                              :alr #(:content (:attrs %))}}
   :image {:key "image"
           :property-selector #(:src (:attrs %))}
   :description {:key "description"
                 :property-selector {:nyt #(:content (second (:content %)))
                                     :alr #(:content (:attrs %))}}
   :instructions {:key "recipeInstructions"
                  :container-selector prop-container
                  :post-processor #(->> %
                                        default-post-processor)
                  :property-selector {:nyt (fn [cont]
                                             (->>
                                              cont
                                              :content
                                              (filter #(= (:tag %) :li))
                                              (map :content)
                                              (map first)))
                                      :alr (fn [cont]
                                             (->>
                                              cont
                                              :content
                                              (filter #(= (:tag %) :li))
                                              (map :content)
                                              (map first)
                                              (map :content)
                                              (map first)))}}})

