(ns clojure-clipper.data
  (:require  [clojure.test :as t]))

(def nyt-instructions
  "Stir together olive oil, lemon juice, garlic, rosemary, and salt and pepper in a large bowl. Cut each chicken breast into 2 equal pieces (3 if they’re 12 ounces or more) and place in the bowl. Stir together and refrigerate for 15 to 30 minutes. Remove chicken from marinade and pat dry (discard marinade). Place two sheets of plastic wrap (1 large sheet if you have extra-wide wrap) on your work surface, overlapping slightly, to make 1 wide sheet, and brush lightly with olive oil. Place a piece of chicken in the middle of plastic sheet and brush lightly with oil. Cover the chicken with another wide layer of plastic wrap. Working from the center to the outside, pound chicken breast with the flat side of a meat tenderizer until about 1/4 inch thick. (Don’t pound too hard or you’ll tear the meat. If that happens it won’t be the end of the world, you’ll just have a few pieces to cook.) Repeat with the remaining chicken breast pieces. Season the pounded chicken breasts with salt and pepper on one side only. Dredge lightly in the flour (you will not use all of it) and tap the breasts to remove excess. Turn oven on low Heat a wide, heavy skillet over high heat and add oil. When oil is hot, place one or two pieces of chicken in the pan – however many will fit without crowding. Cook for 1 1/2 minutes, until bottom is browned in spots. Turn over and brown other side, about 1 1/2 minutes. (Do not overcook or the chicken will be dry.) Transfer to the platter or sheet pan and keep warm in the oven. If there is more than a tablespoon of fat in the pan, pour some (but not all) it off into a jar or bowl. Turn burner heat down to medium-high. Add mushrooms to the pan. Let them sear for about 30 seconds to a minute without moving them, then stir, scraping the bottom of the pan with a wooden spoon to deglaze. When mushrooms have softened slightly and begun to sweat, add wine, thyme or parsley, and salt and pepper to taste. Continue to stir until wine has evaporated and mushrooms are tender, 5 to 10 minutes. Spoon over the chicken, and serve.")

(def allrecipe-instructions
  "Saute onion in 2 tablespoons olive oil in a skillet over medium heat until onion is translucent, about 5 minutes. Stir garlic into onion and turn off heat. Transfer onion mixture to a large mixing bowl. Stir ground beef, ricotta cheese, parsley, egg, kosher salt, black pepper, and cayenne pepper with onion mixture until almost combined; stir in bread crumbs and continue to mix until thoroughly blended. Roll about 2 tablespoons of mixture into a 1-inch ball for each meatball. Pour 2 tablespoons olive oil in same skillet used to cook onions. Place skillet over medium heat and brown meatballs on all sides in hot oil, about 5 minutes. Hold a crumpled paper towel in a tongs and use it to remove excess grease from skillet. Pour marinara sauce and water over meatballs in skillet. Stir to combine and bring to a simmer. Reduce heat to medium-low and simmer, stirring occasionally, until meatballs are cooked through and no longer pink in the center, about 30 minutes.")

(def nyt-ingredients
  [ {:amount "2", :unit nil, :ingredient "boneless skinless chicken breasts"}
   {:amount "2", :unit "tablespoons ", :ingredient "extra-virgin olive oil"}
   {:amount "3", :unit "tablespoons ", :ingredient "fresh lemon juice"}
   {:amount "2", :unit nil, :ingredient "garlic"}
   {:amount "1", :unit "teaspoon ", :ingredient "chopped fresh rosemary"}
   {:amount nil, :unit "Salt to taste", :ingredient nil}
   {:amount nil, :unit "Freshly ground pepper", :ingredient nil}
   {:amount "2", :unit "tablespoons ", :ingredient "all-purpose flour"}
   {:amount "2", :unit "tablespoons grapeseed, sunflower or canola oil", :ingredient nil}
   {:amount "1", :unit "pound ", :ingredient "mushrooms"}
   {:amount "1", :unit "teaspoon ", :ingredient "fresh thyme leaves"}
   {:amount "¼", :unit "cup ", :ingredient "dry white wine"} ]
  )
