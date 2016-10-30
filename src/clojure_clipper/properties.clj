(ns clojure-clipper.properties)

(def properties
  [
   {:key "name"
    :title "Name"
    :selectors {:nyt #(first (:content %))
                :alr #(:content (:attrs %))}}
   {:key "image"
    :title "Photo"
    :selector #(:src (:attrs %))}
   {
    :key "description"
    :title "Description"
    :selectors {:nyt #(:content (second (:content %)))
                :alr #(:content (:attrs %))
                }}
   ;; :image "Photo"
   ;; :description "Description"
   ;; :recipeInstructions} "Instructions"
   ])


