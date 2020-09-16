
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
   (apply str (interpose "\n" (map fizzbuzz (repeat start end))))))
