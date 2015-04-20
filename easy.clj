; http://www.4clojure.com/problem/24
(= (reduce + (list 0 -2 5 5)) 8)

; http://www.4clojure.com/problem/25
(= (filter #(odd? %1) #{1 2 3 4 5}) '(1 3 5)) ; or (filter odd?)

; http://www.4clojure.com/problem/23
(= ((fn [coll] 
      (reduce conj () coll))
    [1 2 3 4 5]) 
   [5 4 3 2 1])

; http://www.4clojure.com/problem/27
(defn palindrome
  [s]
  (let [se (seq s)]
    (= (reverse se) se)))
(false? (palindrome '(1 2 3 4 5)))
(true? (palindrome "racecar"))

; http://www.4clojure.com/problem/26
; first n fibonacci's
(= ((fn [n]
      (take n ((fn fib [a b] (cons a (lazy-seq (fib b (+ a b))))) 1 1))  
     ) 6) '(1 1 2 3 5 8))

; http://www.4clojure.com/problem/38
; max of varargs
(= ((fn [& args] (reduce #(if (> %2 %1) %2 %1) (first args) args))
 1 8 3 4) 
   8)

; http://www.4clojure.com/problem/29
; return only uppper-cases from string
(= ((fn [s] (apply str (filter #(Character/isUpperCase %) s))) "HeLlO, WoRlD!") "HLOWRD")

; http://www.4clojure.com/problem/32
; duplicate sequence
(= (mapcat #(list % %) [:a :a :b :b]) 
   '(:a :a :a :a :b :b :b :b))

; http://www.4clojure.com/problem/48
; intro to some
(= 6 (some #{2 7 6} [5 6 7 8]))

; http://www.4clojure.com/problem/34
; range function
(= ((fn [s e] (take-while #(< % e) (iterate inc s))) -2 2) 
  '(-2 -1 0 1))

; http://www.4clojure.com/problem/28
; flatten seq
(= ((fn [s] (filter #(not (sequential? %))
  (rest (tree-seq sequential? seq s)))) () 
'((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))

; http://www.4clojure.com/problem/39
; interleave sequence
(defn inter [a b]
  (if (and (seq a) (seq b))
    (into [(first a) (first b)] (inter (rest a) (rest b)))))
(inter [1 3 4] [1 2])
(= (inter [1 2 3] [:a :b :c]) 
   '(1 :a 2 :b 3 :c))

;; LOL version: (mapcat list)

