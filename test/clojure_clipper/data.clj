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

(def foodnw-fajitas-instructions
  "In the sleeve of a slow cooker, add the onions, peppers, corn, tomatoes, garlic, 1 tablespoon chile powder, chipotle, and broth. Season with and salt and pepper, to taste. Cook on low for 4 to 6 hours. In a deep skillet over medium heat, add the canola oil and heat to 365 degrees F. Fry the tortilla pieces until brown and crispy, 1 to 2 minutes. Drain on brown paper and immediately season with salt and the remaining 1 tablespoon chile powder. (Reserve half the chips for Online Round 2 Recipe Creamy Mexican Dip with Spiced Chips.)Preheat the broiler. (Reserve 1 cup of the onion and pepper mixture for Round 2 Recipe Creamy Mexican Dip with Spiced Chips.) Ladle the soup into ovenproof bowls or crocks and top each with 2 tablespoons cheese. (Reserve remaining 1/2 cup cheese for Round 2 Recipe Crispy Steak Sandwiches.) Put the bowls on a sheet pan and put under the broiler until the cheese is brown and bubbly, 1 to 2 minutes. Garnish with scallions and serve.")

(def bon-lamb-instructions
  ": , Preheat oven to 425°. Mix oregano, olive oil, 3 Tbsp. pomegranate molasses, and 2 Tbsp. fennel seeds in a small bowl; season oregano mixture with salt and pepper. , Toss fennel, onion, remaining 1 Tbsp. fennel seeds, and remaining 2 tsp. pomegranate molasses in a large baking dish or roasting pan; season with salt and pepper. Distribute evenly across bottom of pan. , Season lamb with salt and pepper. Heat 1 Tbsp. vegetable oil in a large skillet, preferably cast iron, over medium. Cook 1 rack of lamb, fat side down, until golden brown, 8–10 minutes. Turn and cook until other side is just browned, about 5 minutes. Transfer to dish with fennel mixture, placing fat side up, and rub with half of oregano mixture. Wipe out skillet and repeat with remaining 1 Tbsp. vegetable oil, second rack of lamb, and remaining oregano mixture. , Roast lamb and vegetables until an instant-read thermometer inserted into thickest part of lamb registers 125° for medium-rare, 25–30 minutes. Transfer lamb to a cutting board and let rest at least 10 minutes before carving. , Meanwhile, toss vegetables in pan drippings to coat and continue to roast until tender and starting to caramelize, 10–15 minutes. Remove from oven; add vinegar and toss to combine. , Serve lamb over vegetables topped with pomegranate seeds.")

(def bon-deviled-instructions
  ": , Bring a small pot of salted water to a boil. Carefully add eggs. Bring water to a simmer and cook eggs 10 minutes. Drain and transfer to a bowl of ice water; let sit until cool enough to handle. Peel. , Meanwhile, whisk mayonnaise, celery, relish, scallion, mustard, 2 tsp. parsley, and 2 dashes hot sauce in a medium bowl; season with salt and pepper. , Halve eggs lengthwise. Scoop yolks into mayonnaise mixture and place whites on a plate. Gently mash yolks into dressing; season with salt and pepper. Using 2 forks, fill egg halves with yolk mixture. , Top eggs with pepper and more parsley and serve with hot sauce. , Do Ahead: Eggs can be made 1 day ahead. Cover and chill egg whites and filling separately; fill just before serving.")

(def epic-sandwiches-instructions
  "Preparation Position oven rack six inches from the heat source and preheat broiler on high. Line broiler pan or rimmed baking sheet with foil. Brush eggplant slices on both sides with 2 tablespoons BBQ sauce and season with 1/2 teaspoon salt and 1/4 teaspoon peeper. Arrange slices on foil-lined pan. Broil eggplant until browned and soft, about 4 minutes. Meanwhile, in a medium bowl, toss mushrooms and red onion with oil, 1/2 teaspoon salt, and 1/4 teaspoon pepper and reserve. Remove broiler pan from oven, flip eggplant slices, and brush with 2 more tablespoons BBQ sauce. Scatter mushroom mixture around the eggplant on the pan and broil until browned and soft, about 3 minutes more. Add 1 slice of cheese to each eggplant plank and continue to broil until cheese is melted and browned, about 2 minutes more. To assemble the sandwiches, brush the top toasted half of each roll with 1 tablespoon mayonnaise and each bottom half with 1 tablespoon BBQ sauce. Layer an eggplant slice, some mushroom mixture, and a few slices of pepperoncini on the bottom of each roll. Close the sandwiches and serve immediately.")

(def epic-lamb-instructions
  "Preparation Mix first 6 ingredients in large bowl. Add lamb and toss to coat. Heat 2 tablespoons oil in heavy large skillet over medium-high heat. Working in batches, add lamb to skillet and cook until browned on all sides, turning occasionally and adding 2 more tablespoons oil to skillet between batches, about 8 minutes per batch. Transfer lamb to another large bowl after each batch. Add onion and tomato paste to drippings in skillet. Reduce heat to medium; sauté until onion is soft, about 5 minutes. Add broth, garbanzo beans, apricots, tomatoes, cinnamon sticks, ginger, and lemon peel and bring to boil, scraping up browned bits. Return lamb to skillet and bring to boil. Reduce heat to low, cover, and simmer until lamb is just tender, about 1 hour. Uncover and simmer until sauce thickens enough to coat spoon, about 20 minutes. Season with salt and pepper. (Can be prepared 1 day ahead. Cool slightly. Refrigerate uncovered until cold, then cover and keep chilled. Rewarm over medium-low heat, stirring occasionally.) Transfer lamb and sauce to bowl. Sprinkle with cilantro and serve.")

(def epic-pizza-instructions
  "Preparation Place a rack in upper third of oven; preheat to 500°F. On a lightly floured surface, roll dough to a 12\" round (if dough springs back, cover with plastic and let rest 5 minutes, then roll again, resting as needed). Heat 2 Tbsp. oil in a cast-iron skillet over medium-high until very hot. Carefully transfer dough to skillet. Brush top of dough with remaining 1 Tbsp. oil. Cook, shaking pan occasionally and turning pan to avoid hot spots, until bottom of dough is golden brown and crispy, 3–4 minutes. Meanwhile, toss turkey with 1/4 cup cranberry sauce, if using, in a medium bowl. Remove skillet from heat. Using a large flat spatula, flip dough. Spread potatoes over dough, leaving a 3/4\" border on all sides; season with salt and pepper. Top with 1 cup cheese, then turkey mixture, vegetables, and onion. Top with remaining 1 cup cheese and red pepper flakes, if using. Bake pizza until dough is golden brown and cheese is melted, 6–8 minutes. Transfer pizza to a cutting board and cut into wedges. Serve with additional cranberry sauce alongside, if using. Cooks' NoteRoom temperature pizza dough is easier to roll out. To soften chilled dough, place on a rimmed baking sheet set over bowl of hot water.")

(def alr-apple-turnover-ingredients
  [{:amount "2" :unit "tablespoons" :name "lemon juice"}
   {:amount "4" :unit "cups" :name "water"}
   {:amount "4" :unit nil :name "Granny Smith apples - peeled, cored and sliced"}
   {:amount "2" :unit "tablespoons" :name "butter"}
   {:amount "1" :unit "cup" :name "brown sugar"}
   {:amount "1" :unit "teaspoon" :name "ground cinnamon"}
   {:amount "1" :unit "tablespoon" :name "cornstarch"}
   {:amount "1" :unit "tablespoon" :name "water"}
   {:amount "1" :unit nil :name "(17.25 ounce) package frozen puff pastry sheets, thawed"}
   {:amount "1" :unit "cup" :name "confectioners' sugar"}
   {:amount "1" :unit "tablespoon" :name "milk"}
   {:amount "1" :unit "teaspoon" :name "vanilla extract"}])

(def foodnw-pancakes-ingredients
  [{:amount "2" :unit nil :name "medium zucchini (about 3/4 pound)"}
   {:amount "2" :unit "tablespoons" :name "grated red onion"}
   {:amount "2" :unit nil :name "extra-large eggs, lightly beaten"}
   {:amount "6 to 8" :unit "tablespoons" :name "all-purpose flour"}
   {:amount "1" :unit "teaspoon" :name "baking powder"}
   {:amount "1" :unit "teaspoon" :name "kosher salt"}
   {:amount "1/2" :unit "teaspoon" :name "freshly ground black pepper"}
   {:amount nil :unit nil :name "Unsalted butter and vegetable oil"}])

(def foodnw-fajitas-ingredients
  [{:amount "2" :unit nil :name "medium yellow onions, sliced"}
   {:amount "2" :unit nil :name "green peppers, cored, seeded, and sliced into strips"}
   {:amount "1/2" :unit "cup" :name "frozen corn, thawed"}
   {:amount "1" :unit nil :name "(14-ounce) can diced tomatoes"}
   {:amount "1" :unit "tablespoon" :name "chopped garlic"}
   {:amount "2" :unit "tablespoons" :name "chile powder, divided"}
   {:amount "1" :unit nil :name "chipotle pepper in adobo sauce, chopped (reserve adobe for Creamy Mexican Dip)"}
   {:amount "1" :unit "quart" :name "chicken broth"}
   {:amount nil :unit nil :name "Kosher salt and freshly ground black pepper"}
   {:amount "2" :unit "cups" :name "canola oil, for frying"}
   {:amount "12" :unit nil :name "corn tortillas, cut into eighths"}
   {:amount "1" :unit "cup" :name "Monterey Jack cheese, shredded"}
   {:amount "2" :unit nil :name "scallions, sliced"}])

(def epic-spinach-gratin-ingredients
  [{:amount "4", :unit "tablespoons", :name "(1/2 stick) unsalted butter"}
   {:amount "4", :unit "cups", :name "chopped yellow onions (2 large)"}
   {:amount "1/4", :unit "cup", :name "flour"}
   {:amount "1/4", :unit "teaspoon", :name "grated nutmeg"}
   {:amount "1", :unit "cup", :name "heavy cream"}
   {:amount "2", :unit "cups", :name "milk"}
   {:amount "3", :unit "pounds", :name "frozen chopped spinach, defrosted (5 (10-ounce) packages)"}
   {:amount "1", :unit "cup", :name "freshly grated Parmesan cheese"}
   {:amount "1", :unit "tablespoon", :name "kosher salt"}
   {:amount "1/2", :unit "teaspoon", :name "freshly ground black pepper"}
   {:amount "1/2", :unit "cup", :name "grated Gruyere cheese"}])

(def epic-sandwiches-ingredients
  [{:amount "1", :unit nil, :name "large eggplant (about 1 1/2 pounds), trimmed and sliced lengthwise into four 1/2-inch thick planks"}
   {:amount "1/2", :unit "cup", :name "BBQ sauce, divided"}
   {:amount "1", :unit "teaspoon", :name "kosher salt"}
   {:amount "1/2", :unit "teaspoon", :name "freshly ground black pepper"}
   {:amount "8", :unit "ounces", :name "cremini mushrooms, thinly sliced"}
   {:amount "1", :unit nil, :name "red onion, halved and sliced into thin wedges"}
   {:amount "2", :unit "tablespoons", :name "vegetable oil"}
   {:amount "4", :unit nil, :name "slices provolone cheese (1/8-inch thick slices)"}
   {:amount "4", :unit nil, :name "ciabatta or hoagie rolls, split and toasted"}
   {:amount "1/4", :unit "cup", :name "mayonnaise"}
   {:amount "2", :unit nil, :name "jarred pepperoncini peppers, thinly sliced"}
   ])

(def epic-pizza-ingredients
  [{:amount nil, :unit nil, :name "All-purpose flour (for surface)"}
   {:amount "8", :unit "ounces", :name "prepared pizza dough, room temperature"}
   {:amount "3", :unit "tablespoons", :name "olive oil, divided"}
   {:amount "1 1/2", :unit "cups", :name "shredded cooked turkey or rotisserie chicken"}
   {:amount "1/4", :unit "cup", :name "cranberry sauce, plus more for serving (optional)"}
   {:amount "1", :unit "cup", :name "mashed"}
   {:amount nil, :unit nil, :name "Kosher salt, freshly ground black pepper"}
   {:amount "2", :unit "cups", :name "shredded mozzarella, cheddar, and/or Fontina cheese (about 6 ounces), divided"}
   {:amount "1", :unit "cup", :name "cooked vegetables, such as green beans, Brussels sprouts, sautéed greens, carrots, squash, or mushrooms"}
   {:amount "1/2", :unit "cup", :name "sliced red onion"}
   {:amount nil, :unit nil, :name "Pinch crushed red pepper flakes (optional)"}
   {:amount nil, :unit nil, :name "A 12-inch cast-iron skillet"}])

(def epic-lamb-ingredients
  [{:amount "1", :unit "tablespoon", :name "ground cumin"}
   {:amount "2", :unit "teaspoons", :name "ground coriander"}
   {:amount "1 1/2", :unit "teaspoons", :name "salt"}
   {:amount "1", :unit "teaspoon", :name "fennel seeds"}
   {:amount "1/2", :unit "teaspoon", :name "cayenne pepper"}
   {:amount "1/2", :unit "teaspoon", :name "ground black pepper"}
   {:amount "2 1/2", :unit "pounds", :name "trimmed boned lamb shoulder, cut into 1 1/2- to 2-inch pieces"}
   {:amount "4", :unit "tablespoons", :name "olive oil, divided"}
   {:amount "1", :unit nil, :name "large onion, finely chopped"}
   {:amount "1", :unit "tablespoon", :name "tomato paste"}
   {:amount "2", :unit "cups", :name "low-salt chicken broth"}
   {:amount "1 15", :unit nil, :name "1/2-ounce can garbanzo beans (chickpeas), drained"} ; TODO
   {:amount "1", :unit "cup", :name "dried apricots (about 5 ounces)"}
   {:amount "2", :unit nil, :name "large plum tomatoes, chopped"}
   {:amount "2", :unit nil, :name "cinnamon sticks"}
   {:amount "1", :unit "tablespoon", :name "minced peeled fresh ginger"}
   {:amount "2", :unit "teaspoons", :name "(packed) grated lemon peel"}
   {:amount "2", :unit "tablespoons", :name "chopped fresh cilantro"}
   ])

(def alr-meatballs-ingredients
  [{:amount "1/2" :unit nil :name "onion, minced"}
   {:amount "2" :unit "tablespoons" :name "olive oil"}
   {:amount "3" :unit nil :name "cloves garlic, minced"}
   {:amount "1" :unit "pound" :name "ground beef"}
   {:amount "1" :unit "cup" :name "whole milk ricotta cheese"}
   {:amount "1/4" :unit "cup" :name "packed chopped Italian parsley"}
   {:amount "1" :unit nil :name "egg, beaten"}
   {:amount "1 1/2" :unit "teaspoons" :name "kosher salt"}
   {:amount "1/2" :unit "teaspoon" :name "freshly ground black pepper"}
   {:amount "1" :unit "pinch" :name "cayenne pepper, or to taste"}
   {:amount "1/3" :unit "cup" :name "dry bread crumbs"}
   {:amount "2" :unit "tablespoons" :name "olive oil"}
   {:amount "1" :unit nil :name "(28 ounce) jar marinara sauce"}
   {:amount "1" :unit "cup" :name "water"}])

(def nyt-brussel-sprouts-ingredients
  [{:amount "6", :unit "tablespoons", :name "olive oil, divided"}
   {:amount "2", :unit nil, :name "large sweet or yellow onions, sliced thin"}
   {:amount nil, :unit nil, :name "Salt to taste"}
   {:amount "20", :unit nil, :name "large brussels sprouts"}
   {:amount "1", :unit "tablespoon", :name "tamari"}
   {:amount "2 to 3", :unit nil, :name "cloves garlic, pressed"}
   {:amount nil, :unit nil, :name "a dash of liquid smoke (if desired)"}
   {:amount "1/2", :unit "teaspoon", :name "ground cumin"}
   {:amount "1/4", :unit "teaspoon", :name "cayenne pepper"}
   {:amount "8", :unit "ounces", :name "tempeh, cut into thin slices"}
   {:amount "5", :unit "teaspoons", :name "grainy mustard"}])

(def nyt-lemon-garlic-ingredients
  [{:amount "2", :unit nil, :name "boneless skinless chicken breasts (most weigh 8 to 10 ounces)"}
   {:amount "2", :unit "tablespoons", :name "extra-virgin olive oil"}
   {:amount "3", :unit "tablespoons", :name "fresh lemon juice"}
   {:amount "2", :unit nil, :name "garlic cloves, minced or puréed"}
   {:amount "1", :unit "teaspoon", :name "chopped fresh rosemary"}
   {:amount nil, :unit nil, :name "Salt to taste"}
   {:amount nil, :unit nil, :name  "Freshly ground pepper"}
   {:amount "2", :unit "tablespoons", :name "all-purpose flour or a gluten-free flour such as rice flour or corn flour"}
   {:amount "2", :unit "tablespoons", :name "grapeseed, sunflower or canola oil"}
   {:amount "1", :unit "pound", :name "mushrooms, sliced"}
   {:amount "1", :unit "teaspoon", :name "fresh thyme leaves or 1 tablespoon chopped flat-leaf parsley"}
   {:amount "1/4", :unit "cup", :name "dry white wine"}])

(def bon-lamb-ingredients
  [{:amount "3", :unit "tablespoons", :name "chopped fresh oregano"}
   {:amount "2", :unit "tablespoons", :name "olive oil"}
   {:amount "3", :unit "tablespoons", :name "plus 2 teaspoons pomegranate molasses"}
   {:amount "3", :unit "tablespoons", :name "fennel seeds, divided"}
   {:amount nil, :unit nil, :name "Kosher salt and freshly ground black pepper"}
   {:amount "2", :unit nil, :name "medium fennel bulbs, sliced lengthwise"}
   {:amount "1", :unit nil, :name "small onion, thinly sliced"}
   {:amount "2 3–3½-pound", :unit nil, :name "racks of lamb, rib bones frenched"}
   {:amount "2", :unit "tablespoons", :name "vegetable oil"}
   {:amount "2", :unit "tablespoons", :name "white wine vinegar"}
   {:amount "1/4", :unit "cup", :name "pomegranate seeds"}
   {:amount nil, :unit nil, :name "Be sure to ask for American lamb rather than New Zealand. The delicate New Zealand breeds are much smaller than the meaty domestic varieties, so the cooking time (and yield) would change significantly."}
   {:amount nil, :unit nil, :name "Pomegranate molasses is available at Middle Eastern markets and some supermarkets, and online."}])

(def bon-deviled-ingredients
  [{:amount nil, :unit nil, :name "Kosher salt"}
   {:amount "8", :unit nil, :name "large eggs"}
   {:amount "3", :unit "tablespoons", :name "mayonnaise"}
   {:amount "3", :unit "tablespoons", :name "very finely chopped celery"}
   {:amount "2", :unit "tablespoons", :name "finely chopped drained pickle relish"}
   {:amount "2", :unit "tablespoons", :name "very finely chopped scallion"}
   {:amount "2", :unit "teaspoons", :name "yellow mustard"}
   {:amount "2", :unit "teaspoons", :name "very finely chopped parsley, plus more for serving"}
   {:amount "2", :unit nil, :name "dashes hot sauce (such as Tabasco), plus more for serving"}
   {:amount nil, :unit nil, :name "Freshly ground black pepper"}])

(def bon-lamb-nutrition
  [{:calories {:unit "kcal", :amount 800}}
   {:fat {:unit "g", :amount 64}}
   {:saturated-fat {:unit "g", :amount 25}}
   {:cholesterol {:unit "mg", :amount 185}}
   {:carbohydrates {:unit "g", :amount 13}}
   {:dietary-fiber {:unit "g", :amount 3}}
   {:total-sugars {:unit "g", :amount 5}}
   {:protein {:unit "g", :amount 42}}
   {:sodium {:unit "mg", :amount 170}}
   ])

(def bon-deviled-nutrition
  [{:calories {:unit "kcal", :amount 240}}
   {:fat {:unit "g", :amount 19}}
   {:saturated-fat {:unit "g", :amount 4.5}}
   {:cholesterol {:unit "mg", :amount 375}}
   {:carbohydrates {:unit "g", :amount 4}}
   {:dietary-fiber {:unit "g", :amount 0}}
   {:total-sugars {:unit "g", :amount 4}}
   {:protein {:unit "g", :amount 13}}
   {:sodium {:unit "mg", :amount 290}}])

(def alr-apple-turnover-nutrition
  {:calories {:amount 562 :unit "kcal" }
   :fat {:amount 25.9 :unit "g" }
   :carbohydrate {:amount 80 :unit "g" }
   :protein {:amount 4.8 :unit "g" }
   :sodium {:amount 184 :unit "mg" }
   :cholesterol {:amount 8, :unit "mg"}})

(def alr-meatballs-nutrition
  {
   :calories {:amount 331 :unit "kcal" }
   :fat {:amount 20.9 :unit "g" }
   :carbohydrate {:amount 18.9 :unit "g" }
   :protein {:amount 16.3 :unit "g" }
   :sodium {:amount 865 :unit "mg" }
   :cholesterol {:amount 75, :unit "mg"}})

(def nyt-lemon-garlic-nutrition
  {:calories {:amount 250 }
   :fat {:amount 15 :unit "grams" }
   :saturated-fat {:amount 1 :unit "gram" }
   :trans-fat {:amount 0 :unit "grams" }
   :carbohydrate {:amount 8 :unit "grams" }
   :fiber {:amount 1 :unit "gram" }
   :protein {:amount 18 :unit "grams" }
   :cholesterol {:amount 46 :unit "milligrams" }
   :sodium {:amount 616 :unit "milligrams" }})

(def nyt-brussel-sprouts-nutrition
  {
   :calories {:amount 191}
   :fat {:amount 13 :unit "grams"}
   :saturated-fat {:amount 2 :unit "grams"}
   :trans-fat {:amount 0 :unit "grams"}
   :carbohydrate {:amount 12 :unit "grams"}
   :fiber {:amount 3 :unit "grams"}
   :protein {:amount 8 :unit "grams"}
   :sodium {:amount 470 :unit "milligrams"}})

(def epic-sandwiches-nutrition
  {:calories {:amount "286", :unit nil, :percent nil}
   :carbohydrate {:amount "35", :unit "g", :percent "12"}
   :fat {:amount "10", :unit "g", :percent "16"}
   :protein {:amount "8", :unit "g", :percent "16"}
   :saturated-fat {:amount "2", :unit "g", :percent "11"}
   :sodium {:amount "708", :unit "mg", :percent "29"}
   :fiber {:amount "4", :unit "g", :percent "18"}
   :cholesterol {:amount "10", :unit "mg", :percent "3"}
   }
  )

(def epic-lamb-nutrition
  {:calories {:amount "777" :unit nil :percent nil}
   :carbohydrate {:amount "39" :unit "g" :percent "13"}
   :fat {:amount "52" :unit "g" :percent "81"}
   :protein {:amount "40" :unit "g" :percent "80"}
   :saturated-fat {:amount "19" :unit "g" :percent "96"}
   :sodium {:amount "904" :unit "mg" :percent "38"}
   :fiber {:amount "8" :unit "g" :percent "33"}
   :cholesterol {:amount "136", :unit "mg", :percent "45"}
   })
