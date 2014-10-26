(ns shire-digest.producer.crawlers
  "Crawlers collection."
  (:require [shire-digest.meta.link :as link]
            [shire-digest.crawler.core :refer [parse]]
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


(defn do-crawl
  "Crawl a site"
  [url crawler-name options]
  (let [crawler (get-by-name crawler-name)
        link (link/parse-string url)]
    (parse crawler link)))


(defn execute
  "Start crawling."
  [sites]
  (reduce (fn [a b] (concat a b)) '()
          (for [[url {:keys [crawler options]}] (seq sites)
                :when (has? crawler)]
            (do-crawl url crawler options))))
