(ns clojure-clipper.core
  (:require [net.cgrand.enlive-html :as html]
            [clojure.string :as str]))

(def ^:dynamic *nyt* "http://cooking.nytimes.com/recipes/1016153-lemon-and-garlic-chicken-with-mushrooms")
(def ^:dynamic *all-recipe* "http://allrecipes.com/recipe/235710/chef-johns-ricotta-meatballs/?internalSource=hn_carousel%2001_Chef%20John's%20Ricotta%20Meatballs&referringId=17659&referringContentType=recipe%20hub&referringPosition=carousel%2001")

(defn fetch [url]
  (html/html-resource (java.net.URL. url)))

(defn get-prop [content prop]
  (html/select
   content
   [(html/attr= :itemtype "http://schema.org/Recipe")
    (html/attr= :itemprop "name")]))

(defn allrecipe [source]
  (->
   source
   fetch
   (get-prop "url")))

(allrecipe *nyt*)

