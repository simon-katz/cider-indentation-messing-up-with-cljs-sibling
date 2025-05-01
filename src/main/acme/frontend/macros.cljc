(ns acme.frontend.macros
  (:refer-clojure :exclude [fn defn])
  #?(:cljs (:require-macros [acme.frontend.macros])))

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

;;;; _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
;;;; These are exactly like `defn` and `fn` except that they don't begin with
;;;; `def`.

(clojure.core/defmacro x-defn [nm & fdecl] ; arg list copied from Electric Clojure
  `(clojure.core/defn ~nm ~@fdecl))

(clojure.core/defmacro x-fn [& args] ; arg list copied from Electric Clojure
  `(clojure.core/fn ~@args))
