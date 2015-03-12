; http://www.4clojure.com/problem/57
(=  [5 4 3 2 1] ((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5))


; http://www.4clojure.com/problem/71
(= (last (sort (rest (reverse [2 5 4 1 3 6]))))
   (-> [2 5 4 1 3 6] (reverse) (rest) (sort) (last))
   5)

; http://www.4clojure.com/problem/134
(true? ((fn [k m] (and (contains? m k) (nil? (m k)))) :a {:a nil :b 2}))
