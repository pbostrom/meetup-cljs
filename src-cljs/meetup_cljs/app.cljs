(ns meetup-cljs.app)
(defn clj->js
  "Recursively transforms ClojureScript maps into Javascript objects,
   other ClojureScript colls into JavaScript arrays, and ClojureScript
   keywords into JavaScript strings."
  [x]
  (cond
   (string? x) x
   (keyword? x) (name x)
   (map? x) (.-strobj (reduce (fn [m [k v]]
                                (assoc m (clj->js k) (clj->js v))) {} x))
   (coll? x) (apply array (map clj->js x))
   :else x))

(def jq js/jQuery)

(defn process-json [resp]
  (.log js/console (js->clj resp)))

(defn process-edn [resp]
  (let [mymap (cljs.reader/read-string resp)]
    (.log js/console (keys mymap))))

(def json-call {:url "/json"
                :success process-json})

(def edn-call {:url "/edn"
               :success process-edn})

(defn say-hi []
  (js/alert "Hello Clojure Meetup!"))

(defn jq-ajax []
  (.ajax jq (clj->js json-call)))

(.on (jq "#tb") "click" jq-ajax)