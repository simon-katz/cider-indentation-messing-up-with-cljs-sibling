(ns acme.frontend.app
  (:require
   [acme.frontend.macros :as m]))

#?(:clj  (defn my-clj-fun []) :cljs (defn my-cljs-fun []))

(defn init [] (println "Hello World"))

;;;; ___________________________________________________________________________

;; Below text after "->" describes the indentation changes after connecting to
;; a sibling CLJS REPL. I've used [good] or [bad] to say
;; whether I think the change is good or bad.

;;;; _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _

(m/defn defn-1 []
  3 ; -> function style [bad]
  4 ; -> function style [bad]
  )

(m/defn defn-2
  []
  3
  4)

(m/defn
  defn-3 ; -> +2 [good]
  []
  3
  4)

(m/fn []
  2 ; -> function style [bad]
  3 ; -> function style [bad]
  )

(m/fn
  []
  2
  3)

;;;; _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _

(m/defn* defn*-1 []
  3 ; -> function style [bad]
  4 ; -> function style [bad]
  )

(m/defn* defn*-2
  []
  3
  4)

(m/defn*
  defn*-3 ; -> +2 [good]
  []
  3
  4)

(m/fn* []
       2
       3)

(m/fn*
  []
  2
  3)

;;;; _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _

(m/defn** defn**-1 []
  3
  4)

(m/defn** defn**-2
  [] ; -> +2 [good]
  3
  4)

(m/defn**
  defn**-3 ; -> +2 [good]
  []       ; -> +2 [good]
  3
  4)

(m/fn** []
  2
  3)

(m/fn**
    []
  2
  3)
