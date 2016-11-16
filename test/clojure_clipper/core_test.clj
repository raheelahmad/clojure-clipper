(ns clojure-clipper.core-test
  (:require [clojure.test :refer :all]
            [clojure-clipper.core :as clipper]
            [clojure-clipper.data :as data]))

(def sources
  [{:symbol :nyt :name "NYT" :url  "htmls/nyt.html"}
   {:symbol :alr :name "All Recipes" :url  "htmls/allrecipes.html"}])

(def nyt-fixture (first (filter #(= (:symbol %) :nyt) sources)))
(def alr-fixture (first (filter #(= (:symbol %) :alr) sources)))

(defn test-data [site-symbol]
  (let [fixture (first (filter #(= (:symbol %) site-symbol) sources))
        parsed (clipper/parse-recipe fixture)
        ]
    parsed
    )
  )

(def expected {:nyt {
                     :yield "Serves 4"
                     :name "Lemon and Garlic Chicken With Mushrooms"
                     :author "Martha Rose Shulman"
                     :cook-time "PT45M"
                     :image "https://static01.nyt.com/images/2014/03/22/science/28recipehealth/28recipehealth-articleLarge.jpg"
                     :description "n this Provençal rendition of pan-cooked chicken breasts, the mushrooms take on and added dimension of flavor as they deglaze the pan with the help of one of their favorite partners, dry white wine."
                     :ingredients data/nyt-ingredients
                     }
               :alr {
                     :yield "8"
                     :name "Chef John's Ricotta Meatballs"
                     :author "Chef John"
                     :cook-time "PT40M"
                     :prep-time "PT20M"
                     :total-time "PT1H"
                     :image "http://images.media-allrecipes.com/userphotos/560x315/1077229.jpg"
                     :description "See how to turn regular beef meatballs into a ricotta-filled sensation."
                     :ingredients data/alr-ingredients
                     }
               }
  )

(doseq [[source-symbol expected-result] expected]
  (deftest recipe-tests
    (testing source-symbol
      (let [result (test-data source-symbol)]
        (doseq [[key expected-value] expected-result]
          (testing key
            (is (= expected-value (key result))))
          )
        ))))

