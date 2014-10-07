(ns shire-digest.producer.cli
  "Commandline interface."
  (:require [clojure.string :as string]
            [clojure.tools.cli :refer [parse-opts]]))


;; Commandline options.
(def opts
  [["-c" "--config CONFIG.json" "Configuration file (json format)."]
   ["-h" "--help" "Display this message."]])

(defn- options-ok?
  "Check user options."
  [options]
  (and
    (contains? options :config)))

(defn- error-msg
  "Print error message retrieved from clojure.tools.cli ."
  [errors]
  (str "The following errors occurred while parsing command:\n\n"
       (string/join \newline errors)))

(defn- usage
  "Print out program usage."
  [options-summary]
  (->> ["Shire Digest Producer"
        ""
        "Usage: <program> [options]"
        ""
        "Options:"
        options-summary]
       (string/join \newline)))

(defn exit
  "Exit program."
  [status msg]
  (println msg)
  (System/exit status))

(defn parse-options
  "Parse commandline options.
  Exit on help or errors occurr."
  [args]
  (let [{:keys [options arguments errors summary]} (parse-opts args opts)]
    ;; Handle errors & help.
    (cond
      (:help options) (exit 0 (usage summary))
      errors (exit 1 (error-msg errors))
      (not (options-ok? options)) (exit 1 (usage summary)))
    
    options))
