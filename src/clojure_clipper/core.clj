(ns clojure-clipper.core
  (:require [net.cgrand.enlive-html :as html]
            [clojure.string :as str]))

(def sources)

(def ^:dynamic *nyt* "http://cooking.nytimes.com/recipes/1016153-lemon-and-garlic-chicken-with-mushrooms")
(def ^:dynamic *all-recipe* "http://allrecipes.com/recipe/235710/chef-johns-ricotta-meatballs/")

(defn fetch [url]
  (html/html-resource (java.net.URL. url)))

(defn get-prop-container [source prop]
  (first
   (html/select
    source
    [(html/attr= :itemtype "http://schema.org/Recipe")
     (html/attr= :itemprop prop)])))

(defn get-prop [source prop]
  (let [selectors (:selector prop)
        selector (get selectors source)
        key (:key prop)
        prop-container (get-prop-container source key)]
    (print source)
    (selector prop-container)))

(defn parse-recipe [source]
  (let [page (fetch source)]
    (map #(get-prop page %)
         properties)))

(def properties
  [ {:key "name"
     :title "Name"
     :selector {*nyt* #(:content %)
                *all-recipe* #(:content %)}}
   ;; :image "Photo"
   ;; :description "Description"
   ;; :recipeInstructions "Instructions"
   ])

(parse-recipe *all-recipe*)
