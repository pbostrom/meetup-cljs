(ns meetup-cljs.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [hiccup.page :refer [html5 include-js]]))

(def home-page (html5 
                 [:body 
                  [:h1 "Clojure Meetup cljs demo"]
                  (include-js "js/main.js")]))

(defroutes app-routes
  (GET "/" [] home-page)
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
