(require 'cljs.build.api)

(cljs.build.api/build "src"
  {:output-to "out/clj.js"
   :optimizations :advanced})

(System/exit 0)

