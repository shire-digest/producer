(ns shire-digest.producer.config
  "Config parser."
  (:require [shire-digest.meta.config :refer [refine]]))


(defn- read-from-file-with-trusted-contents
  [file-name]
  (with-open [r (java.io.PushbackReader.
                  (clojure.java.io/reader file-name))]
    (binding [*read-eval* false]
      (read r))))


(defn from-file
  "Parse config from file."
  [file-name]
  (let [raw-config (read-from-file-with-trusted-contents file-name)]
    (refine raw-config)))
