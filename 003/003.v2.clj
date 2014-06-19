(defn p003
  [limit]
  (def inner_limit (Math/ceil (Math/sqrt limit)))
  (last
    (reduce
      (fn [x y]
        (if
          (vector? x)
          (if (some #(zero? (mod y %)) x) x (conj x y))
          (if (zero? (mod y x)) x [x y])
        ))
      (filter
        #(zero? (mod limit %))
        (into [2] (range 3 inner_limit 2))
      ))))

(defn now [] (java.util.Date.))

(def d1 (.getTime (now)))

(println (p003 600851475143))

(def d2 (.getTime (now)))

(println (str (- d2 d1) " ms"))