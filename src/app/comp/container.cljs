
(ns app.comp.container
  (:require [hsl.core :refer [hsl]]
            [respo-ui.core :as ui]
            [respo.core
             :refer
             [defcomp cursor-> action-> mutation-> <> div button textarea span]]
            [respo.comp.space :refer [=<]]
            [reel.comp.reel :refer [comp-reel]]))

(defcomp
 comp-container
 (reel)
 (let [store (:store reel), states (:states store)]
   (div {} (div {:class-name "container"}) (cursor-> :reel comp-reel states reel {}))))
