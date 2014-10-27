(ns shire-digest.producer.generators
  "Generators collection."
  (:require [shire-digest.generator.core :refer [generate]]
            [shire-digest.generator.simple :as simple]))


(def generators
  {:simple simple/create})


(defn has?
  "Test generator existence."
  [generator-name]
  (contains? generators (keyword generator-name)))


(defn get-by-name
  "Get a generator by name."
  [generator-name]
  (generators (keyword generator-name)))


(defn generate-with
  "Generate documents."
  [generator-name options posts]
  (let [generator ((get-by-name generator-name) options)]
    (generate generator posts)))


(defn execute
  "Start generate."
  [generators posts]
  (for [[generator-name options] (seq generators)]
    (generate-with generator-name options posts)))


(generate-with :simple {:dest "/tmp/xxxshire-digest"} [])
