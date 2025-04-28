(ns acme.frontend.macros
  #?(:cljs (:require-macros [acme.frontend.macros])))

#?(:clj
   (defmacro mac1
     {:style/indent 2}
     [a b c d]
     `(do ~a ~b ~c ~d)))

#?(:clj
   (defmacro mac2
     [a b c d]
     `(do ~a ~b ~c ~d)))

#?(:clj
   (defmacro mac3 [a & fdecl]
     `(do ~a ~@fdecl)))

(defmacro mac4 [a & fdecl]
  `(do ~a ~@fdecl))
