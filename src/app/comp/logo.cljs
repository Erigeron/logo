
(ns app.comp.logo
  (:require [hsl.core :refer [hsl]]
            [respo-ui.core :as ui]
            [respo.macros
             :refer
             [defcomp cursor-> action-> mutation-> list-> <> div button textarea span]]
            [verbosely.core :refer [verbosely! log!]]
            [respo.comp.space :refer [=<]]))

(defcomp
 comp-logo
 (options)
 (log! options)
 (div
  {:style {:width 400, :height 400, :background-color :transparent, :position :relative}}
  (list->
   {}
   (->> (range (:n options))
        (map
         (fn [n]
           [n
            (div
             {:style {:width (:width options),
                      :height (:height options),
                      :background-color (:bg options),
                      :border-color (:border options),
                      :border-width "2px",
                      :border-style :solid,
                      :border-radius "50%",
                      :position :absolute,
                      :top 200,
                      :left (- 200 (/ (:width options) 2)),
                      :transform-origin (str (/ (:width options) 2) "px 0px"),
                      :transform (str
                                  "rotate("
                                  (* n (/ 360 (:n options)))
                                  "deg)"
                                  " translate(0px,"
                                  (:offset options)
                                  "px)")}})]))))))
