(defn p002
  ([limit]
    (p002 limit 1 1 0)
  )
  ([limit x y sum]
    (if
      (< y limit)
      (p002 limit y (+ x y) (if (even? y) (+ sum y) sum))
      (identity sum)
    )
  )
)

(println (str "solution: " (p002 4000000)))