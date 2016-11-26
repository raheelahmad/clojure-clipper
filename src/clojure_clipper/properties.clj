(ns clojure-clipper.properties
  (:require [net.cgrand.enlive-html :as html]
            [clojure.string :as str]
            [clojure-clipper.nyt-selectors :as nyt-helper]
            [clojure-clipper.alr-selectors :as alr-helper]
            [clojure-clipper.epic-selectors :as epic-helper]
            [clojure-clipper.nutrition-helpers :as nutrition]
            [clojure-clipper.ingredient-parser :as ingredients]
            ))

(def schema-selector (html/attr= :itemtype "http://schema.org/Recipe")) ; select the schema; top-level for the recipe
(defn- get-property-selector [prop] (html/attr= :itemprop prop)) ; select the property (as in <tag itemprop="some-property-name">)

(defn get-property-container
  "Get the container inside which we will find the property"
  [content property from-top]
  (let [property-selector (get-property-selector property)]
    (first
     (html/select content
                  (if from-top
                    ; some property containers should be selected with the schema-container first, and then the property
                    [schema-selector property-selector]
                    ; ... and some shoudl be selected directly with the property
                    [(get-property-selector property)])))))

(defn last-in-property-container
  "Same as default-container but selects last element if multiple matches"
  [content property]
  (last
   (html/select content
                [schema-selector (get-property-selector property)]
                )))

;; In most cases property-selector should be enough,
;; but sometimes it is necessary to select schema first (default-container)
(defn default-container [content property]
  (get-property-container content property true))
(defn property-container [content property]
  (get-property-container content property false))

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


(defn epic-find-content-string [container]
  (let [
        from-string (fn [s] s)
        from-map (fn [m] (epic-find-content-string (:content m)))
        from-seq (fn [m] (map epic-find-content-string m))]
    (cond
      (string? container) (from-string container)
      (map? container) (from-map container)
      (seq? container) (from-seq container)
      :else "")))

(def properties
  {:ingredients {:key "recipeIngredient"
                 :container-selector {:alr (fn [content property]
                                             (html/select content [(html/attr= :itemprop "ingredients")]))
                                      :nyt (fn [content property]
                                             (html/select content [(html/attr= :itemprop property)]))
                                      :epic (fn [content property]
                                              (html/select content [(html/attr= :itemprop "ingredients")]))
                                      :foodnw (fn [content property]
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
                                 :alr property-container}
            :property-selector #(first (:content %))}
   :nutrition {:key "nutrition"
               :container-selector {:nyt default-container
                                    :epic property-container
                                    :alr property-container}
               :property-selector {:nyt nutrition/nyt-nutrition-selector
                                   :alr nutrition/alr-nutrition-selector
                                   :epic nutrition/epic-nutrition-selector}
               :post-processor identity}
   :prep-time {:key "prepTime"
               :container-selector {
                                    :nyt default-container
                                    :foodnw default-container
                                    :epic property-container
                                    :alr property-container}
               :property-selector {
                                   :nyt #(:content (:attrs %))
                                   :foodnw #(:content (:attrs %))
                                   :epic #(:content (:attrs %))
                                   :alr #(:datetime (:attrs %))}}
   :cook-time {:key "cookTime"
               :container-selector {
                                    :nyt default-container
                                    :foodnw default-container
                                    :epic property-container
                                    :alr property-container}
               :property-selector {
                                   :nyt #(:content (:attrs %))
                                   :foodnw #(:content (:attrs %))
                                   :epic #(:content (:attrs %))
                                   :alr #(:datetime (:attrs %))}}
   :total-time {:key "totalTime"
                :container-selector {
                                     :nyt default-container
                                     :foodnw property-container
                                     :epic default-container
                                     :alr property-container}
                :property-selector {:nyt #(:content (:attrs %))
                                    :foodnw #(:content (:attrs %))
                                    :epic #(:content (:attrs %))
                                   :alr #(:datetime (:attrs %))}}
   :yield {:key "recipeYield"
           :container-selector {
                                :nyt default-container
                                :foodnw default-container
                                :epic property-container
                                :alr property-container}
           :property-selector {
                               :nyt #(first (:content %))
                               :epic #(or (first (:content %))
                                          (:content (:attrs %)))
                               :foodnw #(:content (:attrs %))
                              :alr #(:content (:attrs %))}}
   :image {:key "image"
           :container-selector {
                                :nyt default-container
                                :alr default-container
                                :foodnw last-in-property-container
                                :epic epic-helper/image-selector
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
                                      :foodnw last-in-property-container
                                      :epic property-container
                                      }
                 :property-selector {
                                     :nyt #(:content (second (:content %)))
                                     :alr #(:content (:attrs %))
                                     :foodnw #(:content (:attrs %))
                                     :epic #(or (flatten (epic-find-content-string %))
                                                (:content (first %)))
                                     }}
   :instructions {:key "recipeInstructions"
                  :container-selector property-container
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
                                      ; TODO: need to descend depth first
                                      :epic (fn [initial]
                                              (flatten (epic-find-content-string initial)))
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


