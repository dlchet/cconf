(ns cconf.core
  (:require [cconf.argv]
            [cconf.env]
            [cconf.file]))

(defn argv
  "Load argv data into the config"
  ([] (argv {}))
  ([options] (argv {} options))
  ([config options] (cconf.argv/parse *command-line-args*)))

(defn env
  "Load environment variables into the config"
  ([] (env {}))
  ([options] (env {} options))
  ([config options] (cconf.env/parse (System/getenv))))

(defn file
  "Load data from a json file into the config"
  ([filename] (file {} filename))
  ([config filename] (cconf.file/parse filename)))

(defn defaults
  "Load any default values into the config"
  ([options] (defaults {} options))
  ([config options] options))
