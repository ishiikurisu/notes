(ns br.eng.crisjr.notes.include-date
  (:require [cheshire.core :as json]
            [clojure.string :as string]
            [babashka.process :as p]))

(def inlet-file "index.blog.json")
(def outlet-file "index.new.blog.json")
(def month-to-number
  {"Jan" "01"
   "Feb" "02"
   "Mar" "03"
   "Apr" "04"
   "May" "05"
   "Jun" "06"
   "Jul" "07"
   "Aug" "08"
   "Sep" "09"
   "Oct" "10"
   "Nov" "11"
   "Dec" "12"})

(defn- clean-index-string [s]
  (->> s
       (string/trim)
       (filter #(not= (int %) 0xfeff))
       (apply str)))

(defn- run-command [command]
  (-> (p/process command {:out :string})
      (p/check)
      (get :out)))

(defn- fill-day-with-zeroes [day]
  (if (= 2 (count day))
      day
      (str "0" day)))

(defn- format-date [git-date]
  (let [pieces (string/split git-date #"\s+")
        year (nth pieces 5)
        month (->> (nth pieces 2) (get month-to-number))
        day (fill-day-with-zeroes (nth pieces 3))
        datetime (nth pieces 4)]
    (str year "-" month "-" day "T" datetime ".000Z")))

(defn- get-last-date [gitlog]
  (->> gitlog
       (string/split-lines)
       (filter #(.contains % "Date:"))
       (last)
       (format-date)))

(defn- get-first-date [gitlog]
  (->> (string/split-lines gitlog)
       (filter #(.contains % "Date:"))
       first
       format-date))

(defn- gemini-to-markdown [maybe-gmi]
  (string/replace maybe-gmi #"\.gmi" ".md"))

(defn- find-inclusion-date [entry]
  (let [path (get entry "path")
        raw-command "git log --all --full-history -- "
        md-gitlog (->> (gemini-to-markdown path)
                       (str raw-command)
                       run-command)
        gmi-gitlog (->> (str raw-command path)
                        run-command)]
    (-> entry
        (assoc "creation_date" (get-last-date (if (empty? md-gitlog)
                                                gmi-gitlog
                                                md-gitlog))
               "last_updated_date" (get-first-date gmi-gitlog))
        (dissoc "date"))))

(defn- main []
  (let [index (-> (slurp inlet-file)
                  clean-index-string
                  json/parse-string)
       index-with-dates (map find-inclusion-date index)
       outlet (json/generate-string index-with-dates
                                    {:pretty true})]
    (spit outlet-file outlet)))

(main)
