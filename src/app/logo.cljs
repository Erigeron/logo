
(ns app.logo (:require ["pixi.js" :as PIXI]))

(defonce pixi-app
  (PIXI.Application.
   (clj->js {:width 400, :height 400, :transparent true, :antialias true, :resolution 1})))

(defn create-logo! [store]
  (.appendChild (.querySelector js/document ".container") pixi-app.view)
  (dotimes [n 8]
    (let [g (PIXI.Graphics.)]
      (-> g
          (.beginFill 0xffee44)
          (.lineStyle 0 0x8888ff 1)
          (.drawEllipse 0 96 28 96)
          (.endFill))
      (-> g .-alpha (set! 0.6))
      (-> g .-transform .-pivot (.set 0 0))
      (-> g .-position (.set 200 200))
      (-> g .-rotation (set! (* n (/ js/Math.PI 4))))
      (.addChild pixi-app.stage g))))

(defn update-logo! [store]
  (.log js/console pixi-app.stage)
  (.reload js/location)
  (dotimes [n 10]
    (comment
     let
     ((graphics (PIXI.Graphics.)))
     (-> graphics (.beginFill 0xff3300) (.drawEllipse 100 100 80 40) (.endFill))
     (.addChild pixi-app.stage graphics))))
