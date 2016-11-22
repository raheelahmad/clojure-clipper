(ns clojure-clipper.data
  (:require  [clojure.test :as t]))

(def nyt-brussel-sprouts-instructions
  "Heat a large skillet over medium heat. Add 2 tablespoons olive oil, heat for a minute, then add the onions and a sprinkling of salt. Stir frequently, making sure to stir from the bottom of the pan up, to dislodge any sticking onions. They will begin to yellow and shrink in volume, as they darken from yellow to more of a caramel color, lower the heat. Keep cooking until they are at the desired state. This usually takes between 25 and 35 minutes. Let cool. Preheat the oven to 375 degrees. Cut the brussels sprouts in half from top to bottom, keeping the two halves close together. If you don’t , you will have to search for a pair that fits well together after they have roasted. Mix together two tablespoons olive oil, tamari, pressed garlic, cumin, cayenne and liquid smoke in a bowl to make the marinade. Taking one complete brussels sprouts pair at a time, dip both halves in the marinade. Remove and let sit cut side down on a parchment lined baking sheet. Bake for 12 minutes, then turn the sprouts and bake 7 more minutes. Prepare a second parchment lined baking sheet. Pour the marinade into a baking pan and let the tempeh sit in it for 20 minutes, then turn all the pieces and let them marinade another 10 minutes. Remove the tempeh and set them up without touching on the baking sheet. If there is any reserved marinade, brush over the remaining pieces. Bake at 375 for 12 minutes, gently turn, and bake for 5 minutes more. Cool onions, brussels sprouts and tempeh for assembly. Take one half of a brussels sprout, smear with mustard, add a piece of tempeh cut to fit the size of the sprout, add some onions (I used a melon baller for this). Take the other half of the brussels sprout and position it so the two spouts are like the buns on a burger, with the cut sides facing each other, and secure with a toothpick. Warm on a baking pan in a 325 degree oven for 10 to 15 minutes.")

(def nyt-lemon-garlic-instructions
  "Stir together olive oil, lemon juice, garlic, rosemary, and salt and pepper in a large bowl. Cut each chicken breast into 2 equal pieces (3 if they’re 12 ounces or more) and place in the bowl. Stir together and refrigerate for 15 to 30 minutes. Remove chicken from marinade and pat dry (discard marinade). Place two sheets of plastic wrap (1 large sheet if you have extra-wide wrap) on your work surface, overlapping slightly, to make 1 wide sheet, and brush lightly with olive oil. Place a piece of chicken in the middle of plastic sheet and brush lightly with oil. Cover the chicken with another wide layer of plastic wrap. Working from the center to the outside, pound chicken breast with the flat side of a meat tenderizer until about 1/4 inch thick. (Don’t pound too hard or you’ll tear the meat. If that happens it won’t be the end of the world, you’ll just have a few pieces to cook.) Repeat with the remaining chicken breast pieces. Season the pounded chicken breasts with salt and pepper on one side only. Dredge lightly in the flour (you will not use all of it) and tap the breasts to remove excess. Turn oven on low Heat a wide, heavy skillet over high heat and add oil. When oil is hot, place one or two pieces of chicken in the pan – however many will fit without crowding. Cook for 1 1/2 minutes, until bottom is browned in spots. Turn over and brown other side, about 1 1/2 minutes. (Do not overcook or the chicken will be dry.) Transfer to the platter or sheet pan and keep warm in the oven. If there is more than a tablespoon of fat in the pan, pour some (but not all) it off into a jar or bowl. Turn burner heat down to medium-high. Add mushrooms to the pan. Let them sear for about 30 seconds to a minute without moving them, then stir, scraping the bottom of the pan with a wooden spoon to deglaze. When mushrooms have softened slightly and begun to sweat, add wine, thyme or parsley, and salt and pepper to taste. Continue to stir until wine has evaporated and mushrooms are tender, 5 to 10 minutes. Spoon over the chicken, and serve.")

(def alr-meatballs-instructions
  "Saute onion in 2 tablespoons olive oil in a skillet over medium heat until onion is translucent, about 5 minutes. Stir garlic into onion and turn off heat. Transfer onion mixture to a large mixing bowl. Stir ground beef, ricotta cheese, parsley, egg, kosher salt, black pepper, and cayenne pepper with onion mixture until almost combined; stir in bread crumbs and continue to mix until thoroughly blended. Roll about 2 tablespoons of mixture into a 1-inch ball for each meatball. Pour 2 tablespoons olive oil in same skillet used to cook onions. Place skillet over medium heat and brown meatballs on all sides in hot oil, about 5 minutes. Hold a crumpled paper towel in a tongs and use it to remove excess grease from skillet. Pour marinara sauce and water over meatballs in skillet. Stir to combine and bring to a simmer. Reduce heat to medium-low and simmer, stirring occasionally, until meatballs are cooked through and no longer pink in the center, about 30 minutes.")

(def alr-apple-turnover-instructions
  "Combine the lemon and 4 cups water in a large bowl. Place the sliced apples in the water to keep them from browning. Melt butter in a large skillet over medium heat. Drain water from apples, and place them into the hot skillet. Cook and stir for about 2 minutes. Add brown sugar, and cinnamon, and cook, stirring, for 2 more minutes. Stir together cornstarch and 1 tablespoon water. Pour into the skillet, and mix well. Cook for another minute, or until sauce has thickened. Remove from heat to cool slightly. Preheat the oven to 400 degrees F (200 degrees C). Unfold puff pastry sheets, and repair any cracks by pressing them back together. Trim each sheet into a square. Then cut each larger square into 4 smaller squares. Spoon apples onto the center of each squares. Fold over from corner to corner into a triangle shape, and press edges together to seal. Place turnovers on a baking sheet, leaving about 1 inch between them. Bake for 25 minutes in the preheated oven, until turnovers are puffed and lightly browned. Cool completely before glazing. To make the glaze, mix together the confectioners' sugar, milk and vanilla in a small bowl. Adjust the thickness by adding more sugar or milk if necessary. Drizzle glaze over the cooled turnovers.")

(def foodnw-pancakes-instructions
  "Preheat the oven to 300 degrees F. Grate the zucchini into a bowl using the large grating side of a box grater. Immediately stir in the onion and eggs. Stir in 6 tablespoons of the flour, the baking powder, salt, and pepper. (If the batter gets too thin from the liquid in the zucchini, add the remaining 2 tablespoons of flour.)Heat a large (10 to 12-inch) saute pan over medium heat and melt 1/2 tablespoon butter and 1/2 tablespoon oil together in the pan. When the butter is hot but not smoking, lower the heat to medium-low and drop heaping soup spoons of batter into the pan. Cook the pancakes about 2 minutes on each side, until browned. Place the pancakes on a sheet pan and keep warm in the oven. Wipe out the pan with a dry paper towel, add more butter and oil to the pan, and continue to fry the pancakes until all the batter is used. The pancakes can stay warm in the oven for up to 30 minutes. Serve hot.")

(def alr-apple-turnover-ingredients
  [
   {:amount "2" :unit "tablespoons" :ingredient "lemon juice"}
   {:amount "4" :unit "cups" :ingredient "water"}
   {:amount "4" :unit nil :ingredient "Granny Smith apples - peeled, cored and sliced"}
   {:amount "2" :unit "tablespoons" :ingredient "butter"}
   {:amount "1" :unit "cup" :ingredient "brown sugar"}
   {:amount "1" :unit "teaspoon" :ingredient "ground cinnamon"}
   {:amount "1" :unit "tablespoon" :ingredient "cornstarch"}
   {:amount "1" :unit "tablespoon" :ingredient "water"}
   {:amount "1" :unit nil :ingredient "(17.25 ounce) package frozen puff pastry sheets, thawed"}
   {:amount "1" :unit "cup" :ingredient "confectioners' sugar"}
   {:amount "1" :unit "tablespoon" :ingredient "milk"}
   {:amount "1" :unit "teaspoon" :ingredient "vanilla extract"}
   ])

(def alr-meatballs-ingredients
  [
   {:amount "1/2" :unit nil :ingredient "onion, minced"}
   {:amount "2" :unit "tablespoons" :ingredient "olive oil"}
   {:amount "3" :unit nil :ingredient "cloves garlic, minced"}
   {:amount "1" :unit "pound" :ingredient "ground beef"}
   {:amount "1" :unit "cup" :ingredient "whole milk ricotta cheese"}
   {:amount "1/4" :unit "cup" :ingredient "packed chopped Italian parsley"}
   {:amount "1" :unit nil :ingredient "egg, beaten"}
   {:amount "1 1/2" :unit "teaspoons" :ingredient "kosher salt"}
   {:amount "1/2" :unit "teaspoon" :ingredient "freshly ground black pepper"}
   {:amount "1" :unit "pinch" :ingredient "cayenne pepper, or to taste"}
   {:amount "1/3" :unit "cup" :ingredient "dry bread crumbs"}
   {:amount "2" :unit "tablespoons" :ingredient "olive oil"}
   {:amount "1" :unit nil :ingredient "(28 ounce) jar marinara sauce"}
   {:amount "1" :unit "cup" :ingredient "water"}
   ])

(def nyt-brussel-sprouts-ingredients
  [ {:amount "6", :unit "tablespoons", :ingredient "olive oil, divided"}
   {:amount "2", :unit nil, :ingredient "large sweet or yellow onions, sliced thin"}
   {:amount nil, :unit nil, :ingredient "Salt to taste"}
   {:amount "20", :unit nil, :ingredient "large brussels sprouts"}
   {:amount "1", :unit "tablespoon", :ingredient "tamari"}
   {:amount "2", :unit nil, :ingredient "to 3 cloves garlic, pressed"}
   {:amount nil, :unit nil, :ingredient "a dash of liquid smoke (if desired)"}
   {:amount "1/2", :unit "teaspoon", :ingredient "ground cumin"}
   {:amount "1/4", :unit "teaspoon", :ingredient "cayenne pepper"}
   {:amount "8", :unit "ounces", :ingredient "tempeh, cut into thin slices"}
   {:amount "5", :unit "teaspoons", :ingredient "grainy mustard"}
   ]
  )

(def nyt-lemon-garlic-ingredients
  [ {:amount "2", :unit nil, :ingredient "boneless skinless chicken breasts (most weigh 8 to 10 ounces)"}
   {:amount "2", :unit "tablespoons", :ingredient "extra-virgin olive oil"}
   {:amount "3", :unit "tablespoons", :ingredient "fresh lemon juice"}
   {:amount "2", :unit nil, :ingredient "garlic cloves, minced or puréed"}
   {:amount "1", :unit "teaspoon", :ingredient "chopped fresh rosemary"}
   {:amount nil, :unit nil, :ingredient "Salt to taste"}
   {:amount nil, :unit nil, :ingredient  "Freshly ground pepper"}
   {:amount "2", :unit "tablespoons", :ingredient "all-purpose flour or a gluten-free flour such as rice flour or corn flour"}
   {:amount "2", :unit "tablespoons", :ingredient "grapeseed, sunflower or canola oil"}
   {:amount "1", :unit "pound", :ingredient "mushrooms, sliced"}
   {:amount "1", :unit "teaspoon", :ingredient "fresh thyme leaves or 1 tablespoon chopped flat-leaf parsley"}
   {:amount "1/4", :unit "cup", :ingredient "dry white wine"} ]
  )

(def alr-apple-turnover-nutrition
  {
   "calories" [ 562 "kcal" ]
   "fat" [ 25.9 "g"]
   "carbohydrate" [ 80 "g"]
   "protein" [ 4.8 "g"]
   "sodium" [ 184 "mg"]
   } )

(def alr-meatballs-nutrition
  {
   "calories" [ 331 "kcal" ]
   "fat" [ 20.9 "g"]
   "carbohydrate" [ 18.9 "g"]
   "protein" [ 16.3 "g"]
   "sodium" [ 865 "mg"]
   } )


(def nyt-lemon-garlic-nutrition
  {
   "calories" [ 250 ]
   "fat" [ 15 "grams"]
   "saturated-fat" [ 1 "gram"]
   "trans-fat" [ 0 "grams"]
   "carbohydrate" [ 8 "grams"]
   "fiber" [ 1 "gram"]
   "protein" [ 18 "grams"]
   "cholesterol" [ 46 "milligrams"]
   "sodium" [ 616 "milligrams"]
   }
  )

(def nyt-brussel-sprouts-nutrition
  {
   "calories" [ 191 ]
   "fat" [ 13 "grams"]
   "saturated-fat" [ 2 "grams"]
   "trans-fat" [ 0 "grams"]
   "carbohydrate" [ 12 "grams"]
   "fiber" [ 3 "grams"]
   "protein" [ 8 "grams"]
   "sodium" [ 470 "milligrams"]
   }
  )

