

(defn factorial [n]
  (if (= n 0) 1
      (* n (factorial (dec n)))))

(defn factorial-bigint [n]
  (if (= n 0) 1
      (*' n (factorial-bigint (dec n)))))

(defn not-tail-recur [n]
  (if (= n 0) 1
      ; will throw error. recur not in tail pos
      (*' n (recur (dec n)))))

(defn loop-factorial [n]
  (if (= n 0) 1
      (loop [val n i n]
        (if (<= i 1) val)
        (recur (*' val (dec i)) (dec i)))))

(factorial 10)