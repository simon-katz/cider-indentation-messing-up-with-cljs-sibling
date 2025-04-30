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

;;;; _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
;;;; These are exactly like `defn` and `fn` except that they don't begin with
;;;; `def`.

;;;; For these, the indentation does not change after connecting to a sibling
;;;; CLJS REPL.

;;;; The indentation is inconsistent -- sometimes function-style and sometimes
;;;; macro-style.

(m/x-defn x-defn-1 [] ; function-style indentation
          3
          4)

(m/x-defn x-defn-2 ; macro-style indentation
  []
  3
  4)

(m/x-defn ; macro-style indentation
    x-defn-3
  []
  3
  4)

(m/x-fn [] ; function-style indentation
        2
        3)

(m/x-fn ; macro-style indentation
  []
  2
  3)
