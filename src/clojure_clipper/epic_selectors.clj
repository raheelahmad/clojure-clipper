(ns clojure-clipper.epic-selectors
  (:require [net.cgrand.enlive-html :as html]))

(defn image-selector
  "Finds the biggest image for the images found in the recipe schema"
  [content prop]
  (let [get-width (fn [tag] (-> tag :attrs :width read-string))
        image-tags (html/select  content [(html/attr= :itemprop prop)])
        largest-image (reduce (fn [prev tag]
                                (> (get-width prev) (get-width tag))
                                prev tag)
                              image-tags)]
    largest-image))

