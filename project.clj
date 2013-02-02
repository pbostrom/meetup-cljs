(defproject meetup-cljs "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [compojure "1.1.5"]
                 [hiccup "1.0.2"]]
  :plugins [[lein-ring "0.8.2"]
            [lein-cljsbuild "0.3.0"]]
  :ring {:handler meetup-cljs.handler/app}
  :cljsbuild 
  {:builds [
            {:source-paths ["src-cljs"]
             :compiler
             {:output-to "resources/public/js/main.js"}}]}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.3"]]}})
