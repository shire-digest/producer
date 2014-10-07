(ns shire-digest.producer.env
  "Environment related utilities."
  (:require [clojure.java.io :as io]))


(defn prepare-directories
  "Prepare output directories."
  [options]
  (let [output-dir (:dest options)]
    (io/make-parents (str output-dir "/foobar"))))
