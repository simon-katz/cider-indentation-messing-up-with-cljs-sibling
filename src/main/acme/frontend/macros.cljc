(ns acme.frontend.macros
  (:refer-clojure :exclude [fn defn])
  #?(:cljs (:require-macros [acme.frontend.macros])))

;; TODO: Is it arg names?
;; TODO: Is it the names `defn` and `fn` and the `:refer-clojure`?

;; TODO: Is it the same without `defn` as the name? If so, change all the names.
;;       - Ah, `defn` and `defn*` behave the same.
;;       - So compare `def-x` and `x`.

;; TODO: Don't forget: You have some macros of your own that cock up.

;; TODO: Try CIDER 1.18.

;;;; _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _

(clojure.core/defmacro defn [nm & fdecl] ; arg list copied from Electric Clojure
  `(clojure.core/defn ~nm ~@fdecl))

(clojure.core/defmacro fn [& args] ; arg list copied from Electric Clojure
  `(clojure.core/fn ~@args))

;;;; _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _

(clojure.core/defmacro defn* [nm & fdecl]
  `(clojure.core/defn ~nm ~@fdecl))

(clojure.core/defmacro fn* [& args]
  `(clojure.core/fn ~@args))

;;;; _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _

(clojure.core/defmacro defn** [nm args & body]
  `(clojure.core/defn ~nm ~args ~@body))

(clojure.core/defmacro fn** [args & body]
  `(clojure.core/fn ~args ~@body))
