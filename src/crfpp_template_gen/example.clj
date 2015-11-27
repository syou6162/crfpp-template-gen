(ns crfpp-template-gen.example
  (:use [crfpp-template-gen.core :only (get-new-feature)]))

(defn -main [& args]
  (let [word-idx "word-idx"
        pos-idx "pos-idx"]
    (println "# word bigram")
    (doseq [[x y] (partition 2 1 (range -2 3))]
      (println (get-new-feature word-idx x word-idx y)))
    (println "# pos bigram")
    (doseq [[x y] (partition 2 1 (range -2 3))]
      (println (get-new-feature pos-idx x pos-idx y)))))
