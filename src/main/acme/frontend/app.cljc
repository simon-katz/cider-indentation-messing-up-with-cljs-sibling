(ns acme.frontend.app
  (:require
   [acme.frontend.macros :as m]))

#?(:clj  (defn my-clj-fun []) :cljs (defn my-cljs-fun []))

(defn init [] (println "Hello World"))

(m/mac1 1
    2
  3
  4)

(m/mac2 1
        2
        3
        4)

(m/mac3 1
  2
  3
  4)

(m/mac4 1
  2
  3
  4)

(m/defn defn-1 []
  3
  4)

(m/defn defn-2
  []
  3
  4)

(m/defn
  defn-3
  []
  3
  4)

(m/defn* defn*-1 []
  3
  4)

(m/defn* defn*-2
  []
  3
  4)

(m/defn*
  defn*-3
  []
  3
  4)

(m/defn** defn**-1 []
  3
  4)

(m/defn** defn**-2
  []
  3
  4)

(m/defn**
  defn**-3
  []
  3
  4)

(m/fn []
  2
  3)

(m/fn
  []
  2
  3)

(m/fn* []
       2
       3)

(m/fn*
  []
  2
  3)

(m/fn** []
  2
  3)

(m/fn**
    []
  2
  3)
