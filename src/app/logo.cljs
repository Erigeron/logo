
(ns app.logo (:require ["pixi.js" :as PIXI]))

(def pixi-app (PIXI.Application. (clj->js {:width 400, :height 400})))

(defn create-logo! [store] (js/console.log pixi-app))

(defn update-logo! [store] (.log js/console pixi-app))
