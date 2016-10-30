(ns clojure-clipper.core
  (:require [net.cgrand.enlive-html :as html]
            [clojure.string :as str]
            clojure-clipper.properties))

;; TODO
;; - separate source files
;; - download & use recipe HTMLs
;; - write tests

(def sources
  [
   {:symbol :nyt :name "NYT" :url  "http://cooking.nytimes.com/recipes/1016153-lemon-and-garlic-chicken-with-mushrooms"}
   {:symbol :alr :name "All Recipes" :url  "http://allrecipes.com/recipe/235710/chef-johns-ricotta-meatballs/"}]) 

(defn fetch [url] (html/html-resource (java.net.URL. url)))

(defn get-prop-container [content prop]
  (first
   (html/select content
    [(html/attr= :itemtype "http://schema.org/Recipe") (html/attr= :itemprop prop)])))

(defn get-prop [source content prop]
  (let [selectors (:selectors prop)
        source-symbol (:symbol source)
        ;; selector is found either in :selector,
        ;; or for in :selectors map with key as source's symbol
        selector (or (:selector prop)
                     (get selectors source-symbol))
        key (:key prop)
        name (:title prop)
        prop-container (get-prop-container content key)
        prop-value (selector prop-container)]
    (if (= key "recipeInstructions")
      (clojure.pprint/pprint prop-container))
    {name prop-value})) 

(defn parse-recipe [source]
  (let [url (:url source)
        page (fetch url)]
    {(:name  source)
     (apply merge
            (map #(get-prop source page %) properties))}))


(clojure.pprint/pprint
(map parse-recipe sources)
)
