
(ns app.schema (:require [hsl.core :refer [hsl]]))

(def store
  {:states {},
   :options {:height 160,
             :width 48,
             :offset 8,
             :bg (hsl 60 80 50 0.6),
             :border (hsl 240 80 60 0.3),
             :n 8}})
