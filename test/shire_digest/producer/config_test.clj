(ns shire-digest.producer.config-test
  (:require [clojure.test :refer :all]
            [clojure.java.io :as io]
            [shire-digest.producer.config :refer :all]))


(deftest test-read-from-file
  (testing "Read config from file."
    (let [test-file (.getFile (io/resource "test/simple.clj"))
          {:keys [sites generators]} (from-file test-file)]
      (is (not (nil? sites)))
      (is (not (nil? generators))))))
