(ns shire-digest.producer.generators
  "Generators collection."
  (:require [shire-digest.generator.core :refer [create]]
            [shire-digest.generator.simple :as simple]))


;; Declare your generators below.
;; TODO employ ref to make a mutable map.
(def generators
  {"simple" simple/new-generator})

(defn set-generator
  "Set a generator with name."
  [generator-name make-generator]
  ;; TODO employ ref to make a mutable map.
  nil)

(defn get-generator-by-name
  "Get a generator by name."
  [generator-name]
  (generators generator-name))

(defn generate-with
  "Generate a document."
  [post-metas options make-generator]
  (create (make-generator options) post-metas))
