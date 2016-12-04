(ns clojure-clipper.sources)

(defn url-to-source-symbol
  [url]
  (let [regex-to-source-name {#"(nytimes.com|nyt.com)" :nyt
                              #"(bonappetit.com)" :bon
                              #"(allrecipes.com)" :alr
                              #"(foodnetwork.com)" :foodnw
                              #"(epicurious.com)" :epic
                              }
        match (first (filter #(boolean (re-find (first %1) url))
                             regex-to-source-name))
        source-name (second match)]
    source-name))


(def sources {
              :nyt {:name "New York Times"}
              :bon {:name "Bon Appetit"}
              :alr {:name "All Recipes"}
              :foodnw {:name "The Food Network"}
              :epic {:name "Epicurious"}
              })

