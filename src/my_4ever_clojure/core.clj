(ns my-4ever-clojure.core
  (:gen-class))

(defn- run-answer
  [answer & fns]
  (map #(% answer) fns))

; #1 Nothing but the Truth
(defn nothing-but-the-truth
  [answer]
  (= answer true))
;; (nothing-but-the-truth true)

; #2 Simple math
(defn simple-math
  [answer]
  (= (- 10 (* 2 3)) answer))
;; (simple-math 4)

; #3 Strings
(defn java-strings
  [answer]
  (= answer (.toUpperCase "hello world")))
;; (java-strings "HELLO WORLD")

; #4 Lists
(defn c-lists
  [answer]
  (= answer '(:a :b :c)))
(c-lists (list :a :b :c))

; #5 conj on lists
(def conj-on-list-answer '(1 2 3 4))

(defn conj-on-lists-1
  [answer]
  (= answer (conj '(2 3 4) 1)))
;; (conj-on-lists-1 conj-on-list-answer)

(defn conj-on-lists-2
  [answer]
  (= answer (conj '(3 4) 2 1)))
;; (conj-on-lists-2 conj-on-list-answer)

; #6 Vectors
(defn construct-vectors
  [answer]
  (= answer
     (list :a :b :c)
     (vec '(:a :b :c))
     (vector :a :b :c)))
;; (construct-vectors [:a :b :c])

; #7 conj on vectors
(defn conj-on-vectors
  [answer]
  (= answer (conj [1 2 3] 5)))
;; (conj-on-vectors [1 2 3 5])

; #8 Sets
(def construct-sets-answer #{:a :b :c :d})

(defn construct-sets-1
  [answer]
  (= answer (set '(:a :a :b :c :c :c :c :d :d))))
;; (construct-sets-1 construct-sets-answer)

(defn construct-sets-2
  [answer]
  (= answer
     (clojure.set/union #{:a :b :c} #{:b :c :d})))
;; (construct-sets-2 construct-sets-answer)

; #9 conj on sets
(defn conj-on-sets
  [answer]
  (= #{1 2 3 4} (conj #{1 4 3} answer)))
;; (conj-on-sets 2)

; #10 Maps
(def maps-answer 2)
(defn maps-get-by-map
  [answer]
  (= answer ((hash-map :a 1 :b 2 :c 3) :b)))
;; (maps-get-by-map maps-answer)

(defn maps-get-by-key
  [answer]
  (= answer (:b {:a 1 :b 2 :c 3})))

;; (maps-get-by-key maps-answer)

; #11 conj on maps
(defn conj-on-maps
  [answer]
  (= {:a 1 :b 2 :c 3} (conj {:a 1} answer [:c 3])))
;; (conj-on-maps [:b 2])

; #12 Sequences
(def sequences-answer 3)

(comment
  (run-answer sequences-answer
              #(= % (first '(3 2 1)))
              #(= % (second [2 3 1]))
              #(= % (last (list 1 2 3))))
  :rcf)


; #13 rest
(defn rest-check
  [answer]
  (= answer (rest [10 20 30 40])))
;; (rest-check '(20 30 40))

; #14 Functions 
(def functions-answer 8)

(comment
  (run-answer functions-answer
              #(= % ((fn add-five [x] (+ x 5)) 3))
              #(= % ((fn [x] (+ x 5)) 3))
              (fn [a] (= a (#(+ % 5) 3)))
              #(= % ((partial + 5) 3)))
  :rcf)

; #15 Double Down
; Write a function which doubles a number.
(defn double-down
  [x]
  (* x 2))

(comment
  (= (double-down 2) 4)
  (= (double-down 33) 66)
  (= (double-down 25) 50)
  (= (double-down 21) 42)
  :rcf)

; #16 Hello World
(defn hello-world-fn
  [name]
  (str "Hello, " name "!"))
(comment
  (hello-world-fn "Dave")
  (hello-world-fn "World")
  (hello-world-fn "Mary")
  :rcf)

; #17 map
(defn map-example
  [answer]
  (= answer (map #(+ % 5) '(1 2 3))))

(comment
  (map-example '(6 7 8))
  :rcf)

; #18 filter

(defn filter-example
  [answer]
  (= answer (filter #(> % 5) '(3 4 6 7 8 10))))
(comment
  (filter-example '(6 7 8 10))
  :rcf)

; #19 Last Element

(defn get-last-el
  [coll]
  (last coll))

(comment
  (run-answer get-last-el 
              (fn [a] (= (a [1 2 3 4 5]) 5))
              (fn [a] (= (a '(10 20 30)) 30)))
  :rcf)

; #20 Penultimate Element
(defn penultimate-el
  [coll]
  (first (take-last 2 coll)))

(comment
  (run-answer penultimate-el 
              (fn [a] (= (a (list 1 2 3 4 5)) 4))
              (fn [a] (= (a [:a :b :c :d]) :c))
              (fn [a] (= (a [[1 2] [3 4]]) [1 2])))
  :rcf)

; #21 nth
(defn get-nth
  [coll i]
  (nth coll i))

(comment
  (run-answer get-nth
              (fn [a]
                (= (a '(4 5 6 7) 2) 6))
              (fn [a]
                (= (a [:a :b :c] 0) :a))
              (fn [a]
                (= (a [1 2 3 4] 1) 2))
              (fn [a]
                (= (a '([1 2] [3 4] [5 6]) 2) [5 6])))
  :rcf)

; #22 count a seq
(defn count-seq
  [seq]
  (count seq))

(comment
  (run-answer count-seq
              (fn [a] (= (a '(1 2 3 3 1)) 5))
              (fn [a] (= (a "Hello world") 11))
              (fn [a] (= (a [[1 2] [3 4] [5 6]]) 3))
              (fn [a] (= (a '(12)) 1))
              (fn [a] (= (a '(:a :b :c)) 3)))
  :rcf)

; #23 Reverse a seq

(defn reverse-seq
  [seq]
  (reverse seq))

(comment
  (run-answer reverse-seq
              (fn [a] (= (a [1 2 3 4 5]) [5 4 3 2 1]))
              (fn [a] (= (a (sorted-set 5 7 2 7)) '(7 5 2)))
              (fn [a] (= (a [[1 2] [3 4] [5 6]]) [[5 6] [3 4] [1 2]])))
  :rcf)

; #24 Sum it all up
(comment
  (run-answer
    (fn [coll] (reduce + coll))
    #(= (% [1 2 3]) 6)
    #(= (% (list 0 -2 5 5)) 8)
    #(= (% #{4 2 1}) 7)
    #(= (% '(0 0 -1)) -1)
    #(= (% '(1 10 3)) 14))
  :rcf)

; #25 Find the odd number
;; (filter odd? [1 2 3 4 5])

(comment
  (run-answer
    #(filter odd? %)
    #(= (% #{1 2 3 4 5}) '(1 3 5))
    #(= (% [4 2 1 6]) '(1))
    #(= (% [2 2 4 6]) '())
    #(= (% [1 1 1 3]) '(1 1 1 3)))
  )

; #26 Fibonacci

(defn fibonacci
  ([size] (fibonacci size 1))
  ([size & items]
   (let [current items]
     (if (= size (count current))
       (apply list current)
       (apply fibonacci
              size
              (conj
               (vec items)
               (reduce + (take-last 2 items))))))))

(comment
  (fibonacci 3)
  (fibonacci 6)
  (fibonacci 8)
  )

; #27 Palindrome Detector
(defn palindrom-detector [x] x)



