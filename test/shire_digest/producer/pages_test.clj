(ns shire-digest.producer.pages-test
  (:require [clojure.test :refer :all]
            [shire-digest.producer.pages :refer :all]))

(deftest test-get-crawler-by-name
  (testing "Get from pre-defined name."
    (let [predefined ["echo" "en-wikipedia-tfa"]]
      (is (every? (fn [x] x) (map get-crawler-by-name predefined)))))
  (testing "Get from undefine name."
    (is (not (get-crawler-by-name "not-exist-yet")))))
