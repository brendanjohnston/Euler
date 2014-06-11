(defn p002
  [limit]
  (def x 0)
  (def y 1)
  (def s 0)
  (while
    (< y limit)
    (do
      (def z (+ x y))
      (def x y)
      (def y z)
      (if
        (even? x)
        (def s (+ s x))
      )
    )
  )
  s
)

(println (str "solution: " (p002 4000000)))