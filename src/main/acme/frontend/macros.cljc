(ns acme.frontend.macros
  (:refer-clojure :exclude [fn defn])
  #?(:cljs (:require-macros [acme.frontend.macros])))

#?(:clj
   (clojure.core/defmacro mac1
     {:style/indent 2}
     [a b c d]
     `(do ~a ~b ~c ~d)))

#?(:clj
   (clojure.core/defmacro mac2
     [a b c d]
     `(do ~a ~b ~c ~d)))

#?(:clj
   (clojure.core/defmacro mac3 [a & fdecl]
     `(do ~a ~@fdecl)))

(clojure.core/defmacro mac4 [a & fdecl]
  `(do ~a ~@fdecl))


;; Is it arg names?
;; Is it the names `defn` and `fn` and the `:refer-clojure`?

(clojure.core/defmacro defn [nm & fdecl] ; arg list copied from Electric Clojure
  `(clojure.core/defn ~nm ~@fdecl))

(clojure.core/defmacro defn* [nm & fdecl]
  `(clojure.core/defn ~nm ~@fdecl))

(clojure.core/defmacro defn** [nm args & body]
  `(clojure.core/defn ~nm ~args ~@body))

(clojure.core/defmacro fn [& args] ; arg list copied from Electric Clojure
  `(clojure.core/fn ~@args))

(clojure.core/defmacro fn* [& args]
  `(clojure.core/fn ~@args))

(clojure.core/defmacro fn** [args & body]
  `(clojure.core/fn ~args ~@body))
