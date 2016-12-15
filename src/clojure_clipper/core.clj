(ns clojure-clipper.core
  (:require [net.cgrand.enlive-html :as html]
            [clojure.string :as str]
            [clojure.pprint :as pp]
            [spyscope.core :as spy]
            [clojure-clipper.sources :as src]
            [clojure-clipper.properties :refer :all]))

(defn fetch [url] (html/html-resource url))

(defn get-selector
  "Get selector (selector-type: either property, post-processor or container)
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

        ;; just-for-printing (if (and (= source-symbol :bon)
        ;;                            (= property-key "image"))
        ;;                     (let []
        ;;                       (println "===================\n=========================")
        ;;                       (clojure.pprint/pprint prop-container)
        ;;                       (clojure.pprint/pprint "------------------------------")
        ;;                       (clojure.pprint/pprint prop-value)
        ;;                       ))
        ]


    processed-prop-value))


(defn- parse-recipe
  "Parses the recipe with give `page` content from a determined `source`"
  [page source]
  (let [
        source-symbol (:source source)
        source-name (get-in src/sources [source-symbol :name])
        result (reduce-kv (fn [col
                               property-name ; key from `properties`
                               property-selector] ; selector that finds the property in page

                           (assoc col
                                  property-name
                                  (get-property source page property-selector))) ; this is the parsing step: get the property

                         {:source-name source-name}
                         properties)]
   result))

(defn parse-local-recipe
  "Used by tests to parse local recipe resource.
  source-map includes :url and :source (local url cannot be used to determine its :source name)"
  [source-map]
  (let [page (html/html-resource (:url source-map))]
    (parse-recipe page source-map)))

(defn parse-recipe-at-url
  "Main API function for parsing at a URL. Uses the URL's domain name to determine the
  :source, which parametrizes how the recipe will be parsed"
  [url]
  (let [page (html/html-resource (java.net.URL. url))
        source-symbol (src/url-to-source-symbol url)
        parsed-map (parse-recipe page {:url url :source source-symbol})
        parsed-map-with-source (concat parsed-map
                                       {:source source-symbol :source-url url})]
    parsed-map-with-source))

;; (clojure.pprint/pprint (parse-recipe-at-url "http://www.epicurious.com/recipes/food/views/bbq-eggplant-sandwiches-with-provolone-and-mushrooms-51261010"))
;; (clojure.pprint/pprint (parse-recipe-at-url "http://www.epicurious.com/recipes/food/views/mushroom-leek-and-fontina-frittata-51143040"))
;; (clojure.pprint/pprint (parse-recipe-at-url "http://www.foodnetwork.com/recipes/anne-burrell/almond-and-raisin-biscotti-recipe2.html"))

