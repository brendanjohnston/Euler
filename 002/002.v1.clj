(defn p002
  ([limit]
    (p002 limit 1 1 0)
  )
  ([limit x y sum]
    (if
      (< y limit)
      (p002 limit y (+ x y) (if (even? y) (+ sum y) sum))
      sum
    )
  )
)

(defn now [] (java.util.Date.))

(def d1 (.getTime (now)))

(def solution (p002 4000000))

(def d2 (.getTime (now)))

(println (str "solution: " solution ", in " (- d2 d1) "ms"))