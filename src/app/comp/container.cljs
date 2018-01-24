
(ns app.comp.container
  (:require [hsl.core :refer [hsl]]
            [respo-ui.core :as ui]
            [respo.macros
             :refer
             [defcomp cursor-> action-> mutation-> <> div button textarea span]]
            [verbosely.core :refer [verbosely!]]
            [respo.comp.space :refer [=<]]
            [reel.comp.reel :refer [comp-reel]]
            [app.comp.logo :refer [comp-logo]]))

(defcomp
 comp-container
 (reel)
 (let [store (:store reel), states (:states store)]
   (div {} (comp-logo (:options store)) (cursor-> :reel comp-reel states reel {}))))
