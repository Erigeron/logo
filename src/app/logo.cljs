
(ns app.logo (:require ["pixi.js" :as PIXI]))

(defonce pixi-app
  (PIXI/Application.
   (clj->js {:width 400, :height 400, :transparent true, :antialias true, :resolution 1})))

(defn draw-logo! []
  (dotimes [n 8]
    (let [g (PIXI/Graphics.)]
      (-> g (.lineStyle 12 0x888899 1) (.drawEllipse 0 96 40 96))
      (-> g .-alpha (set! 1))
      (-> g .-transform .-pivot (.set 0 0))
      (-> g .-position (.set 200 200))
      (-> g .-rotation (set! (- (* n (/ js/Math.PI 4)) 0.1)))
      (.addChild pixi-app.stage g))
    (let [g (PIXI/Graphics.)]
      (-> g (.lineStyle 16 0xffee77 1) (.drawEllipse 0 96 40 96))
      (-> g .-alpha (set! 1))
      (-> g .-transform .-pivot (.set 0 0))
      (-> g .-position (.set 200 200))
      (-> g .-rotation (set! (* n (/ js/Math.PI 4))))
      (.addChild pixi-app.stage g))))

(defn create-logo! [store]
  (.appendChild (.querySelector js/document ".container") pixi-app.view)
  (comment js/console.log pixi-app.stage pixi-app.view)
  (draw-logo!))

(defn update-logo! [store] (.removeChildren pixi-app.stage) (draw-logo!))
