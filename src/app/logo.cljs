
(ns app.logo (:require ["pixi.js" :as PIXI]))

(defonce pixi-app
  (PIXI.Application.
   (clj->js {:width 400, :height 400, :transparent true, :antialias true, :resolution 1})))

(defn create-logo! [store]
  (.appendChild (.querySelector js/document ".container") pixi-app.view)
  (let [container (PIXI.Container.)]
    (.addChild pixi-app.stage container)
    (-> container .-position (.set 200 200))
    (dotimes [n 8]
      (let [graphics (PIXI.Graphics.)]
        (-> graphics .-transform .-pivot (.set 0 0))
        (set! (.-alpha graphics) 0.6)
        (-> graphics
            (.beginFill 0xffee44)
            (.lineStyle 0 0x8888ff 1)
            (.drawEllipse 0 96 28 96)
            (.endFill))
        (set! (.-rotation graphics) (* n (/ js/Math.PI 4)))
        (.addChild container graphics)))))

(defn update-logo! [store]
  (.log js/console pixi-app.stage)
  (.reload js/location)
  (dotimes [n 10]
    (comment
     let
     ((graphics (PIXI.Graphics.)))
     (-> graphics (.beginFill 0xff3300) (.drawEllipse 100 100 80 40) (.endFill))
     (.addChild pixi-app.stage graphics))))
