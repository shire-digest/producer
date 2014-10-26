(ns shire-digest.producer.crawlers
  "Crawlers collection."
  (:require [shire-digest.crawler.core :refer [parse]]
            [shire-digest.crawler.echo :refer [echo-crawler]]
            [shire-digest.crawler.wikipedia.en.tfa :as en-tfa]))


(def crawlers
  {:echo echo-crawler
   :en-wikipedia-tfa en-tfa/tfa-crawler})


(defn has?
  "Test crawler existence."
  [crawler-name]
  (contains? crawlers (keyword crawler-name)))


(defn get-by-name
  "Get a crawler by name."
  [crawler-name]
  (crawlers (keyword crawler-name)))
