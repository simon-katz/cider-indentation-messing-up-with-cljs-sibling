# Indentation changes after connecting to a sibling CLJS REPL

This repo can be used to show that, in CIDER, indentation of macro calls in a CLJ/CLJS project changes after connecting to a sibling CLJS REPL.

Checked with CIDER 1.17 and 1.18.

This is a shadow-cljs project, but I get the same behaviour in a Figwheel project.

## Prerequisites

This project requires node.js and npm, as documented at https://shadow-cljs.github.io/docs/UsersGuide.html#_standalone_via_code_npm_code

## Demonstrating the problem

The problem can be seen by following the following steps:

- At the command line, run `npm install`.

- In Emacs, run `M-x cider-jack-in-clj`.

- When you have a CLJ REPL, evaluate the contents of the `acme.frontend.app` namespace.

- Reindent the whole namespace.
  - Observe that nothing changes (or, if you're repeating this step, that the indentation returns to the original). The indentation here is good.

- Run `M-x cider-connect-sibling-cljs`.
  - Choose `shadow` in response to "Select ClojureScript REPL type".
  - Choose `:frontend` in response to "Select shadow-cljs build".

- Re-indent the whole namespace again.
  - Observe that some indentation changes and that the changes are a mixture of good and bad, as mentioned in the comments on the lines that change.
  - It makes no difference whether the current REPL (as defined at https://docs.cider.mx/cider/usage/managing_connections.html#current-repl) is the CLJ one or the CLJS one.

- Kill the CLJS REPL. Observe that re-indenting the namespace makes no further changes. (Still not good.)

- Kill the CLJ REPL and start over. The same behaviour repeats.

I've investigated a little — it seems that connecting a CLJS sibling REPL (without doing anything more) causes things in `cider--get-symbol-indent` to change, in particular the value of `(nrepl-dict-get meta "style/indent")` can change from a non-nil value to nil.
