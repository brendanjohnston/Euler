
;; my very first foray into clojure
(defn p001
  [multiples limit]
  (reduce
    (fn
      [sum, value]
      (if
        (some
          #(= 0 (mod value %))
          multiples
        )
        (+ sum value)
        sum
      )
    )
    (range 0 limit)
  )
)

(defn now [] (java.util.Date.))

(def d1 (.getTime (now)))

(def solution (p001 [3 5] 1000))

(def d2 (.getTime (now)))

(println (str "solution: " solution ", in " (- d2 d1) "ms"))

