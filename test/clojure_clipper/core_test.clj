(ns clojure-clipper.core-test
  (:require [clojure.test :refer :all]
            [clojure-clipper.core :as clipper]
            [clojure-clipper.data :as data]))

(def sources
  [{:source :nyt :name :nyt-lemon-garlic :url "htmls/nyt.html"}
   {:source :nyt :name :nyt-brussel-sprouts :url  "htmls/nyt_brussel_sprouts.html"}
   {:source :alr :name :alr-meatballs :url  "htmls/allrecipes.html"}
   {:source :alr :name :alr-apple-turnovers :url  "htmls/alr_apple_turnovers.html"}
   ])

(defn parsed-recipe [recipe-name]
  (let [fixture (first (filter #(= (:name %) recipe-name) sources))
        parsed (clipper/parse-recipe fixture)]
    parsed
    )
  )

(def expected {
               :nyt-brussel-sprouts {
                                     :name "Brussels Sprouts Sliders"
                                     :yield "Serves 8 - 10 appetizer portions"
                                     :image "https://static01.nyt.com/images/2014/11/05/science/05VEGTHANKSGIVING3/05VEGTHANKSGIVING3-articleLarge.jpg"
                                     :cook-time "PT1H45M"
                                     :description "A creative and fun way to enjoy a great fall and winter vegetable: crunchy “buns” of roasted brussels sprouts with a tasty middle -- a confit of caramelized onions, tangy mustard and savory tempeh -- that makes for “dreamy bites of pure umami goodness,\" said Marla Rose of Berwyn, Ill. who sent us this special recipe."
                                     :ingredients data/nyt-brussel-sprouts-ingredients
                                     ;; :nutrition data
                              }
               :nyt-lemon-garlic {
                     :yield "Serves 4"
                     :name "Lemon and Garlic Chicken With Mushrooms"
                     :author "Martha Rose Shulman"
                     :cook-time "PT45M"
                     :image "https://static01.nyt.com/images/2014/03/22/science/28recipehealth/28recipehealth-articleLarge.jpg"
                     :description "In this Provençal rendition of pan-cooked chicken breasts, the mushrooms take on and added dimension of flavor as they deglaze the pan with the help of one of their favorite partners, dry white wine."
                     :ingredients data/nyt-lemon-garlic-ingredients
                     :nutrition data/nyt-lemon-garlic-nutrition
                                  }
               :alr-apple-turnovers {
                                     :name "Apple Turnovers"
                                     :yield "8"
                                     :author "Maureen O'leary"
                                     :cook-time "PT25M"
                                     :prep-time "PT30M"
                                     :total-time "PT55M"
                                     :image "http://images.media-allrecipes.com/userphotos/250x250/934026.jpg"
                                     :description "Anyone can make these delicious homemade apple pastries."
                                     :ingredients data/alr-apple-turnover-ingredients
                                     :nutrition data/alr-apple-turnover-nutrition
                                     }
               :alr-meatballs {
                               :name "Chef John's Ricotta Meatballs"
                               :yield "8"
                               :author "Chef John"
                               :cook-time "PT40M"
                               :prep-time "PT20M"
                               :total-time "PT1H"
                               :image "http://images.media-allrecipes.com/userphotos/560x315/1077229.jpg"
                               :description "See how to turn regular beef meatballs into a ricotta-filled sensation."
                               :ingredients data/alr-meatballs-ingredients
                               :nutrition data/alr-meatballs-nutrition
                     }
               }
  )

(deftest recipe-tests
  (doseq [[recipe-name expected-result] expected]
    (testing recipe-name
      (let [result (parsed-recipe recipe-name)]
        (doseq [[key expected-value] expected-result]
          (testing key
            (is (= expected-value (key result))))
          )
        ))))

