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
    [:button "The Button"]
    [:div#the-box "Stuff goes here"]
    (include-js "js/main.js")]))

(defroutes app-routes
  (GET "/" [] (home-page))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

(defn -main []
  (serve app))