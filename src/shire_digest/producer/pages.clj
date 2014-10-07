(ns shire-digest.producer.pages
  "Page crawlers collection."
  (:require [shire-digest.crawler.core :refer [parse]]
            [shire-digest.crawler.echo :refer [echo-crawler]]
            [shire-digest.crawler.wikipedia.en.tfa :as en-tfa]))

;; Declare your crawler below.
;; TODO employ ref to make a mutable map.
(def crawlers
  {"echo" echo-crawler
   "en-wikipedia-tfa" en-tfa/tfa-crawler})

(defn set-crawler
  "Set a crawler with name."
  [crawler-name crawler]
  ;; TODO employ ref to make a mutable map.
  nil)

(defn get-crawler-by-name
  "Get a crawler by name."
  [crawler-name]
  (crawlers crawler-name))

(defn parse-with
  "Crawl a link."
  [link crawler]
  (parse crawler link))
