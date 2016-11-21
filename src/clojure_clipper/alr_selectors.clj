(ns clojure-clipper.alr-selectors
  (:require [net.cgrand.enlive-html :as html]
            [clojure-clipper.ingredient-parser :as parser]))

(defn alr-ingredient-selector [container]
  (->> container
       (map :content)
       (map first)
       (map parser/parse-ingredient)
       ))
