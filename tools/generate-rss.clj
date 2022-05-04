(ns br.eng.crisjr.notes.generate-rss
  (:require [cheshire.core :as json]))

(def inlet-file "index.blog.json")
(def outlet-file "feed.rss")

(defn generate-header [inlet]
  (str "<title>Cris Jr.'s Notes</title>"
       "<link>https://www.crisjr.eng.br/notes/index.html</link>"
       "<description>Personal notes about whatever</description>"))

(defn generate-item [item]
  (str "<item>"
       "<title>" (get item "title") "</title>"
       "<link>"
       "https://www.crisjr.eng.br/notes/note.html?which="
       (get item "path")
       "</link>"
       "<description>"
       (get item "description")
       "</description>"
       "</item>"))

(defn generate-items [inlet]
  (reduce (fn [state item]
            (str state (generate-item item)))
          ""
          inlet))

(defn generate-rss [inlet]
  (str "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"
       "<rss version=\"2.0\"><channel>"
       (generate-header inlet)
       (generate-items inlet)
       "</channel></rss>"))

(defn main []
  (let [inlet (-> inlet-file
                  slurp
                  json/parse-string)
        outlet (generate-rss inlet)]
    (spit outlet-file outlet)))

(main)
