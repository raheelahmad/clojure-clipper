(defproject clojure-clipper "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [enlive "1.1.6"]
                 [spyscope "0.1.5"]
                 [inflections "0.12.2"]
                 [camel-snake-kebab "0.4.0"]
                 ]
  :plugins [[test2junit "1.1.2"]]
  :test2junit-output-dir ~(or (System/getenv "CIRCLE_TEST_REPORTS") "target/test2junit"))
