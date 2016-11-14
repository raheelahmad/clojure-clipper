(ns clojure-clipper.core-test
  (:require [clojure.test :refer :all]
            [clojure-clipper.core :as clipper]
            [clojure-clipper.data :as data]))

(def sources
  [{:symbol :nyt :name "NYT" :url  "htmls/nyt.html"}
   {:symbol :alr :name "All Recipes" :url  "htmls/allrecipes.html"}])

(def nyt-fixture (first (filter #(= (:symbol %) :nyt) sources)))
(def alr-fixture (first (filter #(= (:symbol %) :alr) sources)))

(deftest recipe-testing
  (testing "NYT"
    (let [nyt-parsed (clipper/parse-recipe nyt-fixture)
          ingredients (get nyt-parsed :ingredients)
          name (get nyt-parsed :name)
          description (get nyt-parsed :description)
          instructions (get nyt-parsed :instructions)
          image (get nyt-parsed :image)]
      (is (= name "Lemon and Garlic Chicken With Mushrooms"))
      (is (= image "https://static01.nyt.com/images/2014/03/22/science/28recipehealth/28recipehealth-articleLarge.jpg"))
      (is (= description "In this Provençal rendition of pan-cooked chicken breasts, the mushrooms take on and added dimension of flavor as they deglaze the pan with the help of one of their favorite partners, dry white wine."))
      (is (= ingredients data/nyt-ingredients))
        ;; (is (= instructions data/nyt-instructions))
))
  (testing "All Recipes"
    (let [all-recipe-parsed (clipper/parse-recipe alr-fixture)
          ingredients (get all-recipe-parsed :ingredients)
          name (get all-recipe-parsed :name)
          description (get all-recipe-parsed :description)
          instructions (get all-recipe-parsed :instructions)
          image (get all-recipe-parsed :image)]
      (is (= name "Chef John's Ricotta Meatballs"))
      (is (= image "http://images.media-allrecipes.com/userphotos/560x315/1077229.jpg"))
      (is (= description "See how to turn regular beef meatballs into a ricotta-filled sensation."))
      (is (= ingredients data/alr-ingredients))
        ;; (is (= instructions data/allrecipe-instructions))
)))

