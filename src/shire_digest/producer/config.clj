(ns shire-digest.producer.config
  "Config parser."
  (:require [clojure.java.io :as io]
            [cheshire.core :as json]))


(defn- from-map
  "Parse config from map."
  [config-map]
  (let [{:keys [output-directory sites generators]} config-map]
    [{:dest output-directory} ;; basic options
      sites ;; sites to be crawled
      generators ;; enabled generators
      ]))

(defn from-json-stream
  "Parse config from json stream."
  [stream]
  (let [parsed (json/parse-stream stream true)]
    (from-map parsed)))

(defn from-json-file
  "Parse config from json file."
  [file-path]
  (from-json-stream (io/reader file-path)))
