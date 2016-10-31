(ns clojure-clipper.core
  (:require [net.cgrand.enlive-html :as html]
            [clojure.string :as str]
            clojure-clipper.properties))

;; TODO
;; - write tests

(def sources
  [
   {:symbol :nyt :name "NYT" :url  "htmls/nyt.html"}
   {:symbol :alr :name "All Recipes" :url  "htmls/allrecipes.html"}]) 

(defn fetch [url] (html/html-resource url))

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
    ; build the result as (this is just one possibility):
    {(:name  source) ; 1. the source name
     (apply merge    ; 3. merge properties into a single map
            (map #(get-prop source page %) properties) ; 2. get parsed values for each property; produces a list of maps
            )}))


(clojure.pprint/pprint
(map parse-recipe sources)
)
