
;; my very first foray into clojure
(defn p001
  [multiples limit]
  (reduce
    (fn
      [sum, value]
      (if
        (first
          (filter
            #(= 0 (mod value %))
            multiples
          )
        )
        (+ sum value)
        sum
      )
    )
    (range 0 limit)
  )
)

(println (str "solution: " (p001 [3 5] 1000)))

