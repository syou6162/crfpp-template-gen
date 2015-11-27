(ns crfpp-template-gen.core)

(let [id (atom -1)]
  (defn get-new-id! []
    (swap! id inc)))

(let [colum2id (atom {})]
  (defn get-colum-id [colum]
    (if-let [id (get @colum2id colum)]
      id
      (do
        (let [new-id (count @colum2id)]
          (swap! colum2id assoc colum new-id)
          new-id)))))

(defn get-new-feature [& pairs']
  (let [pairs (mapv vec (partition 2 pairs'))
        id (get-new-id!)
        result (->> pairs
                    (map
                     (fn [[k v]]
                       (str "%x[" v "," (get-colum-id k) "]")))
                    (clojure.string/join "/"))]
    (str "U" id ":" result)))
