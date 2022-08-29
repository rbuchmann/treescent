(ns treecent.core
  (:require [reagent.core :as r]
            ["ink"        :refer [render useInput Text]]))

(def text (r/adapt-react-class Text))
(def use-input useInput)


(defn simple-test []
  (let [counter (r/atom 0)]
    (fn []
      (use-input (fn [_input key]
                   (when (.-rightArrow key)
                     (swap! counter inc))
                   (when (.-leftArrow key)
                     (swap! counter dec))))
      [text (str "Tests passed: " @counter)])))

(defn main [& _args]
  (render (r/as-element [:f> simple-test])))
