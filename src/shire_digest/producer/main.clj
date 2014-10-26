(ns shire-digest.producer.main
  "Application entry point."
  (:gen-class)
  (:require [shire-digest.producer.cli :refer [parse-options exit]]
            [shire-digest.producer.config :as config]
            [shire-digest.producer.crawlers :as crawlers]
            [shire-digest.producer.generators :as generators]))


(defn- validate-site
  "Validate site defination."
  [site]
  (let [crawler-required (:crawler site)]
    (if (not (crawlers/has? crawler-required))
      (exit 1 (str "Crawler not found: " (str crawler-required))))))


(defn- validate-generator
  "Validate generator defination."
  [generator-required]
  (if (not (generators/has? generator-required))
    (exit 1 (str "Generator not found: " (str generator-required)))))


(defn -main [& args]
  (let [cli-options (parse-options args)
        config-file (:config cli-options)
        {:keys [sites generators]} (config/from-file config-file)]

    (doall (map validate-site (vals sites)))
    (doall (map validate-generator (keys generators)))

    (prn (->> sites crawlers/execute (generators/execute generators)))))
