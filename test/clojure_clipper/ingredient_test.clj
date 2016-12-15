(ns clojure-clipper.ingredient-test
  (:require  [clojure.test :refer :all]
             [clojure-clipper.ingredients.parser :as parser]))

(deftest ingredient-unit-tests
  (are [fluid-ounce-variant] (= "fluid ounce" (parser/unit-for-string fluid-ounce-variant))
    "fluid ounce" "fl oz" "fluid ounces" "fl ozs")
  (are [pound-variant] (= "pound" (parser/unit-for-string pound-variant))
    "lb" "lbs" "pound" "pounds")
  (are [teaspoon-variant] (= "teaspoon" (parser/unit-for-string teaspoon-variant))
    "teaspoon" "teaspoons" "tso" "tsps" "tsp." "tsps."
    )
  (are [tablespoon-variant] (= "tablespoon" (parser/unit-for-string tablespoon-variant))
    "tablespoon" "tablespoons" "tblsp" "tblsps" "tbl." "tbs." "tblsp."
    )
  (are [cup-variant] (= "cup" (parser/unit-for-string cup-variant))
    "cup" "cups"
    )
  (are [pint-variant] (= "pint" (parser/unit-for-string pint-variant))
    "pint" "pints" "pt" "fl pt"
    )
  (are [quart-variant] (= "quart" (parser/unit-for-string quart-variant))
    "quart" "quarts" "qt" "fl qt"
    )
  (are [gallon-variant] (= "gallon" (parser/unit-for-string gallon-variant))
    "gallon" "gallons" "gal" "gals"
    )
  (are [millileter-variant] (= "millileter" (parser/unit-for-string millileter-variant))
    "millileter" "millileter" "ml" "mls"
    )
  (are [liter-variant] (= "liter" (parser/unit-for-string liter-variant))
    "litre" "litres" "liter" "liters" "l"
    )
  (are [ounce-variant] (= "ounce" (parser/unit-for-string ounce-variant))
    "ounce" "ounces" "oz" "ozs"
    )
  (are [pinch-variant] (= "pinch" (parser/unit-for-string pinch-variant))
    "pinch" "pinches"
    )
  )
