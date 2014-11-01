(defproject shire-digest.producer "0.0.2-SNAPSHOT"
  :description ";)"
  :license {:name "SMPPL"
            :url "https://github.com/xhacker/SMPPL/blob/master/SMPPL-Freeware.md"}

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/tools.cli "0.3.1"]
                 [shire-digest.meta "0.0.1"]
                 [shire-digest.crawler "0.0.2-SNAPSHOT"]
                 [shire-digest.generator "0.0.2-SNAPSHOT"]]
  
  :source-paths ["src"]
  :out [shire-digest.producer.main]
  :main shire-digest.producer.main)
