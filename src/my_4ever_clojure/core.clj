(ns my-4ever-clojure.core)

(defn nothing-but-true-1
  [smth]
  (= smth true))

(nothing-but-true-1 true)

(defn simple-math
  [x]
  (= (- 10 (* 2 3)) x))

(simple-math 4)

(defn use-java-str
  [x]
  (= x (.toUpperCase "hello world")))

(use-java-str "HELLO WORLD")

(defn def-lists
  [x y z]
  (= (list x y z) '(:a :b :c)))

(def-lists :a :b :c)

(defn conj-on-list-1
  [l]
  (= l (conj '(2 3 4) 1)))

(conj-on-list-1 '(1 2 3 4))

(defn conj-on-list-2
  [l]
  (= l (conj '(3 4) 2 1)))

(conj-on-list-2 '(1 2 3 4))

(defn def-vectors
  [v]
  (= v (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c)))

(def-vectors [:a :b :c])
