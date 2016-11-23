(ns clojure-clipper.properties
  (:require [net.cgrand.enlive-html :as html]
            [clojure.string :as str]
            [clojure-clipper.nyt-selectors :as nyt-helper]
            [clojure-clipper.alr-selectors :as alr-helper]
            [clojure-clipper.nutrition-helpers :as nutrition]
            [clojure-clipper.ingredient-parser :as ingredients]
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

(defn last-in-prop-container
  "Same as default-container but selects last element if multiple matches"
  [content prop]
  (last
   (html/select content
                [schema-selector (prop-selector prop)]
                )))

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
                                             (html/select content [(html/attr= :itemprop prop)]))
                                      :epic (fn [content prop]
                                              (html/select content [(html/attr= :itemprop "ingredients")]))
                                      :foodnw (fn [content prop]
                                             (html/select content [(html/attr= :itemprop "ingredients")]))
                                      }
                 :property-selector {
                                     :nyt nyt-helper/nyt-ingredient-selector
                                     :foodnw ingredients/default-ingredient-selector
                                     :alr ingredients/default-ingredient-selector
                                     :epic ingredients/default-ingredient-selector
                                     }
                 :post-processor #(identity %)}

   :name {:key "name"
          :property-selector {:nyt #(first (:content %))
                              :alr #(:content (:attrs %))
                              :foodnw #(first (:content %))
                              :epic #(first (:content %))
                              }}
   :author {:key "author"
            :container-selector {:nyt default-container
                                 :alr prop-container}
            :property-selector #(first (:content %))}
   :nutrition {:key "nutrition"
               :container-selector {:nyt default-container
                                    :epic prop-container
                                    :alr prop-container}
               :property-selector {:nyt nutrition/nyt-nutrition-selector
                                   :alr nutrition/alr-nutrition-selector
                                   :epic nutrition/epic-nutrition-selector}
               :post-processor identity}
   :prep-time {:key "prepTime"
               :container-selector {
                                    :nyt default-container
                                    :foodnw default-container
                                    :alr prop-container}
               :property-selector {
                                   :nyt #(:content (:attrs %))
                                   :foodnw #(:content (:attrs %))
                                   :alr #(:datetime (:attrs %))}}
   :cook-time {:key "cookTime"
               :container-selector {
                                    :nyt default-container
                                    :foodnw default-container
                                    :alr prop-container}
               :property-selector {
                                   :nyt #(:content (:attrs %))
                                   :foodnw #(:content (:attrs %))
                                   :alr #(:datetime (:attrs %))}}
   :total-time {:key "totalTime"
                :container-selector {
                                     :nyt default-container
                                     :foodnw prop-container
                                    :alr prop-container}
                :property-selector {:nyt #(:content (:attrs %))
                                    :foodnw #(:content (:attrs %))
                                   :alr #(:datetime (:attrs %))}}
   :yield {:key "recipeYield"
           :container-selector {
                                :nyt default-container
                                :foodnw default-container
                                :epic prop-container
                                :alr prop-container}
           :property-selector {
                               :nyt #(first (:content %))
                               :epic #(first (:content %))
                               :foodnw #(:content (:attrs %))
                              :alr #(:content (:attrs %))}}
   :image {:key "image"
           :container-selector {
                                :nyt default-container
                                :alr default-container
                                :foodnw last-in-prop-container
                                :epic prop-container
                                }
           :property-selector {
                               :nyt #(:src (:attrs %))
                               :alr #(:src (:attrs %))
                               :foodnw #(:src (:attrs %))
                               :epic #(:content (:attrs %))
                               }
           }
   :description {:key "description"
                 :container-selector {
                                      :nyt default-container
                                      :alr default-container
                                      :foodnw last-in-prop-container
                                      :epic prop-container
                                      }
                 :property-selector {
                                     :nyt #(:content (second (:content %)))
                                     :alr #(:content (:attrs %))
                                     :foodnw #(:content (:attrs %))
                                     :epic #(:content (first (:content %)))
                                     }}
   :instructions {:key "recipeInstructions"
                  :container-selector prop-container
                  :post-processor #(->> %
                                        default-post-processor
                                        ((fn [in]
                                           (-> in
                                           (clojure.string/replace #"\s+" " ") ; replace extra whietspaces with just 1.
                                           (clojure.string/replace #"\.([^ ])" ". $1") ; add space after the period in: ".Hello"
                                           (clojure.string/replace #"\.[ ]\)" ".)") ; replace ". )" with ".)"
                                           )))
                                        )
                  :property-selector {
                                      :epic (fn [content]
                                             (->>
                                              content
                                              :content
                                              (filter #(= (:tag %) :ol))
                                              first :content
                                              first :content
                                              first :content
                                              (filter #(= (:tag %) :li))
                                              (map :content)
                                              (map first)
                                              ))
                                      :foodnw (fn [cont]
                                             (->>
                                              cont
                                              :content
                                              (filter #(= (:tag %) :ul))
                                              first
                                              :content
                                              (filter #(= (:tag %) :li))
                                              (map :content)
                                              (map first)
                                              (map :content)
                                              (map (fn [sublevel]
                                                     (map
                                                          #(if (string? %)
                                                            %
                                                            (-> % :content first))
                                                          sublevel)))
                                              (map #(if (string? %) %
                                                        (apply str %)))
                                              ))
                                      :nyt (fn [cont]
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

