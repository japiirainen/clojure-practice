
(defn fizzbuzz
  ([]
   (fizzbuzz 1 101))
  ([i]
   (cond
     (= 0 (mod i (* 3 5))) "fizzBuzz"
     (= 0 (mod i 5)) "buzz"
     (= 0 (mod i 3)) "fizz"
     :else (str i)))
  ([start end]
   (apply str (interpose "\n" (map fizzbuzz (range start end))))))


(def fizz? #(zero? (mod % 3)))
(def buzz? #(zero? (mod % 5)))
(def fizzbuzz? #(zero? (mod % (* 3 5))))

(def fuzzbuzz2
  #(cond
     (fizzbuzz? %) "fizzbuzz"
     (fizz? %) "fizz"
     (buzz? %) "buzz"
     :else %))


(comment
  (fizz? 3)
  (fizz? 4)
  (buzz? 4)
  (buzz? 5)
  (fizzbuzz? 10)
  (fizzbuzz? 15)
  (map fizzbuzz (range 1 101)))






