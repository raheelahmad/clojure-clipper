(ns clojure-clipper.core
  (:require [net.cgrand.enlive-html :as html]
            [clojure.string :as str]))

(def sources
  [
   {:symbol :nyt
    :name "NYT"
    :url  "http://cooking.nytimes.com/recipes/1016153-lemon-and-garlic-chicken-with-mushrooms"}
   {:symbol :alr
    :name "All Recipes"
    :url  "http://allrecipes.com/recipe/235710/chef-johns-ricotta-meatballs/"}]) 

(defn fetch [url]
  (html/html-resource (java.net.URL. url)))

(defn get-prop-container [content prop]
  (first
   (html/select
    content
    [(html/attr= :itemtype "http://schema.org/Recipe")
     (html/attr= :itemprop prop)])))

(defn get-prop [source content prop]
  (let [selectors (:selectors prop)
        source-symbol (:symbol source)
        selector (get selectors source-symbol)
        key (:key prop)
        name (:title prop)
        prop-container (get-prop-container content key)
        prop-value (selector prop-container)]
    (str name ": " prop-value))) 

(def properties
  [
   {:key "name"
     :title "Name"
    :selectors {:nyt #(first (:content %))
                :alr #(:content (:attrs %))}}
   {:key "image"
    :title "Photo"
    :selectors {:nyt #(:src (:attrs %))
                :alr #(:src (:attrs %))}}
   ;; :image "Photo"
   ;; :description "Description"
   ;; :recipeInstructions "Instructions"
   ])

;; TODO: print properly with source name
(defn parse-recipe [source]
  (let [url (:url source)
        page (fetch url)]
    (map #(get-prop source page %) properties)))


(clojure.pprint/pprint
 (map parse-recipe sources))
