
;; second solution, benefited from a peek at: http://clojure-euler.wikispaces.com/Problem+001
(defn p001
  [multiples limit]
  (reduce
    +
    (distinct
      (reduce
        concat
        (map
          #(range 0 limit %)
          multiples
        )
      )
    )
  )
)

(defn now [] (java.util.Date.))

(def d1 (.getTime (now)))

(def solution (p001 [3 5] 1000))

(def d2 (.getTime (now)))

(println (str "solution: " solution ", in " (- d2 d1) "ms"))