(ns shire-digest.producer.main
  "Commandline entry point."
  (:require [shire-digest.producer.cli :refer [parse-options]]
            [shire-digest.producer.config :as config])
  (:gen-class))


(defn -main [& args]
  (let [cli-options (parse-options args)
        {:keys [config]} cli-options
        [options sites generators] (config/from-json-file config)]
    (println options sites generators)))
