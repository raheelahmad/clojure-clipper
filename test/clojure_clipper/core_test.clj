(ns clojure-clipper.core-test
  (:require [clojure.test :refer :all]
            [clojure-clipper.core :as clipper]
            [clojure-clipper.data :as data]))

(def sources
  [
   {:symbol :nyt :name "NYT" :url  "htmls/nyt.html"}
   {:symbol :alr :name "All Recipes" :url  "htmls/allrecipes.html"}
   ])

(def nyt-fixture (first (filter #(= (:symbol %) :nyt) sources)))
(def alr-fixture (first (filter #(= (:symbol %) :alr) sources)))

(deftest recipe-testing
  (testing "Recipe parsing"
    (testing "NYT"
      (let [nyt-parsed (get (clipper/parse-recipe nyt-fixture) "NYT")
            name (get nyt-parsed "Name")
            description (get nyt-parsed "Description")
            instructions (get nyt-parsed "Instructions")
            image (get nyt-parsed "Photo")]
        (is (= name "Lemon and Garlic Chicken With Mushrooms"))
        (is (= image "https://static01.nyt.com/images/2014/03/22/science/28recipehealth/28recipehealth-articleLarge.jpg"))
        (is (= instructions data/nyt-instructions))
        (is (= description "In this Provençal rendition of pan-cooked chicken breasts, the mushrooms take on and added dimension of flavor as they deglaze the pan with the help of one of their favorite partners, dry white wine."))
        ))
    (testing "All Recipes"
      (let [all-recipe-parsed (get (clipper/parse-recipe alr-fixture) "All Recipes")
            name (get all-recipe-parsed "Name")
            description (get all-recipe-parsed "Description")
            image (get all-recipe-parsed "Photo")]
        (is (= name "Chef John's Ricotta Meatballs"))
        (is (= image "http://images.media-allrecipes.com/userphotos/560x315/1077229.jpg"))
        (is (= description "See how to turn regular beef meatballs into a ricotta-filled sensation."))
        ))
    ))
