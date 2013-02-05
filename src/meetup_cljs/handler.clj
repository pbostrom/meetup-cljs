(ns meetup-cljs.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.server.standalone :refer [serve]]
            [hiccup.page :refer [html5 include-js]]))

(defn home-page []
  (html5 
   [:body 
    [:h1 "Clojure Meetup cljs demo"]
    [:button#tb "The Button"]
    [:div#the-box "Stuff goes here"]
    (include-js "//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js")
    (include-js "js/main.js")]))

(defroutes app-routes
  (GET "/edn" [] (pr-str {:name "Paul" :id "pbostrom"}))
  (GET "/json" [] "{\"name\": \"Paul\" \"id\": \"pbostrom\"}")
  (GET "/" [] (home-page))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

(defn -main []
  (serve app))