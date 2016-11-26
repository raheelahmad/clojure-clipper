(ns clojure-clipper.core
  (:require [net.cgrand.enlive-html :as html]
            [clojure.string :as str]
            [clojure.pprint :as pp]
            [spyscope.core :as spy]
            [clojure-clipper.properties :refer :all]))

(defn fetch [url] (html/html-resource url))

(defn get-selector
  "Get selector (selector-type, either property or container)
  from a list of selectors, for a source"
  [selector-type selectors source-symbol]
  (let [found-selectors (selector-type selectors)
        ; selector is either in a map keyed by source, or a singular selector
        found-selector (or (get found-selectors source-symbol)
                              found-selectors)]
    found-selector))

(defn get-property-selector [selectors source-symbol]
  (get-selector :property-selector selectors source-symbol))

(defn get-post-processor [selectors source-symbol]
  (or
   (get-selector :post-processor selectors source-symbol)
   default-post-processor))

(defn get-content-selector [selectors source-symbol]
  (or
   (get-selector :container-selector selectors source-symbol)
   default-container))

(defn get-property [source content selectors]
  (let [source-symbol (:source source)
        property-key (:key selectors)

        ; Get the container inside which the property is spread out
        container-selector (get-content-selector selectors source-symbol)
        prop-container (container-selector content property-key)
        ; Get the property from the container
        property-selector (get-property-selector selectors source-symbol)
        prop-value (property-selector prop-container)

        post-proccesor (get-post-processor selectors source-symbol)
        processed-prop-value (post-proccesor prop-value)

        ;; just-for-printing (if (and (= source-symbol :epic)
        ;;                            (= property-key "recipeInstructions"))
        ;;                     (let []
        ;;                       (clojure.pprint/pprint prop-container)
        ;;                       (clojure.pprint/pprint "------------------------------")
        ;;                       (clojure.pprint/pprint prop-value)
        ;;                       ))

        ]
    processed-prop-value))

(defn parse-recipe [source]
  (let [page (html/html-resource (:url source))
        result (reduce-kv (fn [col
                              property-name ; key from `properties`
                              property-selector ; selector that finds the property in page
                              ]
                            (assoc col
                                   property-name
                                   (get-property source page property-selector) ; this is the parsing step: get the property
                                   ))
                          {}
                          properties)]
    result))


