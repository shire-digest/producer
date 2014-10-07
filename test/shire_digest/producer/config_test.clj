(ns shire-digest.producer.config-test
  (:require [clojure.test :refer :all]
            [clojure.java.io :as io]
            [shire-digest.producer.config :refer :all]))

(deftest test-json-config
  (testing "Parse config from json file."
    (let [test-file (io/resource "test/simple.json")
          [options sites generators] (from-json-file test-file)]
      (is (.startsWith (:dest options) "/tmp"))
      (is (= (count sites) 1))
      (is (= (count generators) 1)))))
