(defproject meetup-cljs "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [compojure "1.1.5"]
                 [hiccup "1.0.2"]
                 [ring-server "0.2.7"]
                 [com.cemerick/piggieback "0.0.2"]]
  :plugins [[lein-cljsbuild "0.3.0"]]
  :cljsbuild 
  {:builds [
            {:source-paths ["src-cljs"]
             :compiler
             {:output-to "resources/public/js/main.js"}}]}
  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.3"]]}}
  :main meetup-cljs.handler)
