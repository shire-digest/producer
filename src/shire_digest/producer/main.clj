(ns shire-digest.producer.main
  "Commandline entry point."
  (:require [shire-digest.producer.cli :refer [parse-options]]
            [shire-digest.producer.config :as config]
            [shire-digest.producer.env :refer [prepare-directories]]
            [shire-digest.producer.pages :as pages]
            [shire-digest.producer.generators :as generators]
            [shire-digest.meta.link :as link])
  (:gen-class))


(defn crawl-url
  "Crawl a url with given crawler."
  [url crawler-name]
  (let [parsed-link (link/parse-string url)
        crawler (pages/get-crawler-by-name crawler-name)]
    (if crawler
      (pages/parse-with parsed-link crawler)
      ;; TODO Handle missing crawler.
      [])))

(defn get-post-metas
  "Get post metas from required sites."
  [sites]
  (apply merge (for [{:keys [url crawler]} sites]
           (crawl-url url crawler))))

(defn generate-document
  "Generate a document from post metas."
  [post-metas options generator-name]
  (let [make-generator (generators/get-generator-by-name generator-name)]
    (if make-generator
      (generators/generate-with post-metas options make-generator)
      ;; TODO Handle missing generator.
      nil)))

(defn generate-documents
  "Generate documents from specified generators."
  [post-metas options generators]
  (apply (fn [x] (generate-document post-metas options x)) generators))

(defn -main [& args]
  (let [cli-options (parse-options args)
        {:keys [config]} cli-options
        [options sites generators] (config/from-json-file config)]
    (prepare-directories options)
    (generate-documents (get-post-metas sites) options generators)))
