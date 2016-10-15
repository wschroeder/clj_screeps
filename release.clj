(require 'cljs.build.api)

(cljs.build.api/build "src"
  {:output-to "out/clj.js"
   :optimizations :simple})

; NOTE: Do not be tempted to use :optimizations :advanced.  They are anything
; but.  They mangle the JavaScript names, breaking advertised contracts with
; what you should expect out of ClojureScript's JavaScript interop.  Hopefully
; this is resolved in a future version of ClojureScript.  We choose :simple in
; order to generate a single script file as our entrypoint into Screeps.

(System/exit 0)

