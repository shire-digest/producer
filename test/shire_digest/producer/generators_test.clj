(ns shire-digest.producer.generators-test
  (:require [clojure.test :refer :all]
            [shire-digest.producer.generators :refer :all]))

(deftest test-get-generator-by-name
  (testing "Get from pre-defined name."
    (let [predefined ["simple"]]
      (is (every? (fn [x] x) (map get-generator-by-name predefined)))))
  (testing "Get from undefine name."
    (is (not (get-generator-by-name "not-exist-yet")))))
