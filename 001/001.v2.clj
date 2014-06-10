
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

(p001 [3 5] 1000)