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

(defn now [] (java.util.Date.))

(def d1 (.getTime (now)))

(def solution (p002 4000000))

(def d2 (.getTime (now)))

(println (str "solution: " solution ", in " (- d2 d1) "ms"))