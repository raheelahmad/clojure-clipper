(ns clojure-clipper.core
  (:require [net.cgrand.enlive-html :as html]
            [clojure.string :as str]
            [clojure.pprint :as pp]
            [clojure-clipper.properties :refer :all]))

(defn fetch [url] (html/html-resource url))

(defn get-selector [selector-type selectors source-symbol]
  (let [property-selectors (selector-type selectors)
        property-selector (or (get property-selectors source-symbol)
                              property-selectors)]
    property-selector))

(defn get-property-selector [selectors source-symbol]
  (get-selector :property-selector selectors source-symbol))


(defn get-content-selector [selectors source-symbol]
  (get-selector :container-selector selectors source-symbol))


(defn get-prop [source content selectors]
  (let [source-symbol (:symbol source)
        property-key (:key selectors)
        property-selector (get-property-selector selectors source-symbol)
        container-selector (get-content-selector selectors source-symbol)
        prop-container (container-selector content property-key)
        prop-value (property-selector prop-container)
        prop-value-str (apply str prop-value)
        trimmed-prop-value (-> prop-value-str str/trim str/trim-newline)
        ]
    trimmed-prop-value))

(defn parse-recipe [source]
  (let [page (html/html-resource (:url source))
        result (reduce-kv (fn [col prop-name prop-selector]
                     (assoc col
                            prop-name
                            (get-prop source page prop-selector)))
                   {}
                   properties)]
    result))
