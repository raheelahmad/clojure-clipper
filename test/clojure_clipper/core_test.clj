(ns clojure-clipper.core-test
  (:require [clojure.test :refer :all]
            [clojure-clipper.core :as clipper]
            [clojure-clipper.data :as data]))

(def sources
  [{:source :nyt :name :nyt-lemon-garlic :url "htmls/nyt.html"}
   {:source :nyt :name :nyt-brussel-sprouts :url  "htmls/nyt_brussel_sprouts.html"}
   {:source :alr :name :alr-meatballs :url  "htmls/allrecipes.html"}
   {:source :alr :name :alr-apple-turnovers :url  "htmls/alr_apple_turnovers.html"}
   {:source :foodnw :name :foodnw-pancakes :url  "htmls/foodnw-zucchini-pancakes.html"}
   {:source :foodnw :name :foodnw-fajitas :url  "htmls/foodnw-spicy-fajita.html"}
   {:source :epic :name :epic-lamb :url  "htmls/epic-moroccan-lamb.html"}
   {:source :epic :name :epic-gratin :url  "htmls/epic-spinach-gratin.html"}
   {:source :epic :name :epic-pizza :url  "htmls/epic-pizza.html"}
   {:source :epic :name :epic-sandwiches :url  "htmls/epic-sandwiches.html"}
   {:source :bon :name :bon-deviled :url  "htmls/bon-deviled.html"}
   ])

(defn parsed-recipe [recipe-name]
  (let [fixture (first (filter #(= (:name %) recipe-name) sources))
        parsed (clipper/parse-recipe fixture)]
    parsed))

(def expected {
               :bon-deviled {:name "\"The Greatest\" Deviled Eggs"
                             :description "The filling for these eggs is coarsely mashed and studded with crunchy celery and scallion."
                             :yield "4  Servings"
                             :instructions data/bon-deviled-instructions
                             :ingredients data/bon-deviled-ingredients
                             :nutrition data/bon-deviled-nutrition
                             }
               :epic-sandwiches {:name "BBQ Eggplant Sandwiches with Provolone and Mushrooms"
                                 :description "These cheesy, BBQ sauce-slathered eggplant-steak sandwiches seem almost meaty, even though they'’re entirely vegetarian."
                                 :image "http://assets.epicurious.com/photos/54c7a61ae231becc7f3deeff/master/pass/51261010_bbq-eggplant-sandwich_6x4.jpg"
                                 :prep-time "PT10M"
                                 :cook-time "PT20M"
                                 :ingredients data/epic-sandwiches-ingredients
                                 :nutrition data/epic-sandwiches-nutrition
                                 :instructions data/epic-sandwiches-instructions
                            }
               :epic-pizza {:name "Thanksgiving Skillet Pizza"
                            :description "Transform your Thanksgiving leftovers into this irresistible pizza, with mashed potatoes taking the place of traditional tomato sauce. Cooking in a cast-iron skillet ensures a super-crispy crust and gets your pizza on the table in 22 minutes or less."
                            :image "http://assets.epicurious.com/photos/582b5eae31bd0b471cece6f3/master/pass/thanksgiving-skillet-pizza-hero-14112016.jpg"
                            :yield "Makes 1 (12\") pizza"
                            :instructions data/epic-pizza-instructions
                            :cook-time "PT22M"
                            :prep-time "PT10M"
                            :ingredients data/epic-pizza-ingredients
                             }
               :epic-lamb {:name "Moroccan Slow-Cooked Lamb"
                           :description "Goes great with: Couscous flavored with chopped mint, toasted slivered almonds, and grated lemon peel. What to drink: Australian Shiraz or red Faugères from the Languedoc in France."
                           :image "http://assets.epicurious.com/photos/560de52cf3a00aeb2f1d5328/master/pass/231597.jpg"
                           :yield "Makes 6 servings"
                           :ingredients data/epic-lamb-ingredients
                           :instructions data/epic-lamb-instructions
                           :nutrition data/epic-lamb-nutrition
                           }
               :foodnw-fajitas {:name "Spicy Fajita Soup"
                                :description "Get this all-star, easy-to-follow Spicy Fajita Soup recipe from Sandra Lee"
                                :image "http://foodnetwork.sndimg.com/content/dam/images/food/fullset/2011/2/20/0/SM0408H_spicy-fajita-soup_s4x3.jpg.rend.sni12col.landscape.jpeg"
                                :total-time "PT5H15M"
                                :cook-time "PT5H0M"
                                :prep-time "PT0H15M"
                                :yield "4 servings"
                                :instructions data/foodnw-fajitas-instructions
                                :ingredients data/foodnw-fajitas-ingredients
                                }
               :foodnw-pancakes {:name "Zucchini Pancakes"
                                 :description "Get this all-star, easy-to-follow Zucchini Pancakes recipe from Ina Garten"
                                 :image "http://foodnetwork.sndimg.com/content/dam/images/food/fullset/2011/7/26/0/BX0214_zucchini-pancakes_s4x3.jpg.rend.sni12col.landscape.jpeg"
                                 :total-time "PT0H24M"
                                 :cook-time "PT0H4M"
                                 :prep-time "PT0H20M"
                                 :yield "10 (3-inch) pancakes"
                                 :instructions data/foodnw-pancakes-instructions
                                 :ingredients data/foodnw-pancakes-ingredients
                                 }
               :nyt-brussel-sprouts {:name "Brussels Sprouts Sliders"
                                     :yield "Serves 8 - 10 appetizer portions"
                                     :image "https://static01.nyt.com/images/2014/11/05/science/05VEGTHANKSGIVING3/05VEGTHANKSGIVING3-articleLarge.jpg"
                                     :cook-time "PT1H45M"
                                     :description "A creative and fun way to enjoy a great fall and winter vegetable: crunchy “buns” of roasted brussels sprouts with a tasty middle -- a confit of caramelized onions, tangy mustard and savory tempeh -- that makes for “dreamy bites of pure umami goodness,\" said Marla Rose of Berwyn, Ill. who sent us this special recipe."
                                     :ingredients data/nyt-brussel-sprouts-ingredients
                                     :nutrition data/nyt-brussel-sprouts-nutrition
                                     :instructions data/nyt-brussel-sprouts-instructions
                                     }
               :nyt-lemon-garlic {:yield "Serves 4"
                                  :name "Lemon and Garlic Chicken With Mushrooms"
                                  :author "Martha Rose Shulman"
                                  :cook-time "PT45M"
                                  :image "https://static01.nyt.com/images/2014/03/22/science/28recipehealth/28recipehealth-articleLarge.jpg"
                                  :description "In this Provençal rendition of pan-cooked chicken breasts, the mushrooms take on and added dimension of flavor as they deglaze the pan with the help of one of their favorite partners, dry white wine."
                                  :ingredients data/nyt-lemon-garlic-ingredients
                                  :nutrition data/nyt-lemon-garlic-nutrition
                                  :instructions data/nyt-lemon-garlic-instructions
                                  }
               :alr-apple-turnovers {:name "Apple Turnovers"
                                     :yield "8"
                                     :author "Maureen O'leary"
                                     :cook-time "PT25M"
                                     :prep-time "PT30M"
                                     :total-time "PT55M"
                                     :image "http://images.media-allrecipes.com/userphotos/250x250/934026.jpg"
                                     :description "Anyone can make these delicious homemade apple pastries."
                                     :ingredients data/alr-apple-turnover-ingredients
                                     :nutrition data/alr-apple-turnover-nutrition
                                     :instructions data/alr-apple-turnover-instructions
                                     }
               :alr-meatballs {:name "Chef John's Ricotta Meatballs"
                               :yield "8"
                               :author "Chef John"
                               :cook-time "PT40M"
                               :prep-time "PT20M"
                               :total-time "PT1H"
                               :image "http://images.media-allrecipes.com/userphotos/560x315/1077229.jpg"
                               :description "See how to turn regular beef meatballs into a ricotta-filled sensation."
                               :ingredients data/alr-meatballs-ingredients
                               :nutrition data/alr-meatballs-nutrition
                               :instructions data/alr-meatballs-instructions
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

