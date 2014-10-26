(ns shire-digest.producer.generators
  "Generators collection."
  (:require [shire-digest.generator.core :refer [create]]
            [shire-digest.generator.simple :as simple]))


(def generators
  {:simple simple/new-generator})


(defn has?
  "Test generator existence."
  [generator-name]
  (contains? generators (keyword generator-name)))


(defn get-by-name
  "Get a generator by name."
  [generator-name]
  (generators (keyword generator-name)))
