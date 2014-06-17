(defn p003
  [limit]
  (def inner_limit (Math/ceil (Math/sqrt limit)))
  (last
    (filter
      #(zero? (mod limit %))
      (reduce
        (fn
          [primes value]
          (def inner_value (Math/ceil (Math/sqrt value)))
          (if
            (some
              #(zero? (mod value %))
              (take-while
                #(< % inner_value)
                primes
              )
            )
            primes
            (conj primes value)
          )
        )
        (into [[2]] (range 3 inner_limit 2))
      )
    )
  )
)

(println (p003 600851475143))