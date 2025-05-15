(ns br.eng.crisjr.notes.original-date
  (:require [cheshire.core :as json]
            [clojure.string :as string]
            [babashka.process :as p]))

(def inlet-file "index.blog.json")
(def outlet-file "index.new.blog.json")

(defn add-original-date [inlet]
  (map #(assoc % "original_date" (get % "creation_date"))
       inlet))

(defn- main []
  (let [index (-> (slurp inlet-file)
                  json/parse-string)
        index-with-dates (add-original-date index)
       outlet (json/generate-string index-with-dates
                                    {:pretty true})]
    (spit outlet-file outlet)))

(main)

