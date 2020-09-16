(ns snake
  (:import
   (java.awt Color Dimension)
   (javax.swing JPanel JFrame Timer JOptionPane)
   (java.awt.event ActionListener KeyListener KeyEvent)))

;constants

(def field-width 50)
(def field-height 30)
(def point-size 15)
(def turn-millis 100)
(def win-length 10)
(def directions
  {KeyEvent/VK_LEFT [-1 0]
   KeyEvent/VK_RIGHT [1 0]
   KeyEvent/VK_UP [0 -1]
   KeyEvent/VK_DOWN [0 1]})

(defn create-snake []
  {:body (list [3 0] [2 0] [1 0] [0 0])
   :direction [1 0]
   :type :snake
   :color (Color. 15 160 70)})

(defn create-apple []
  {:location [(rand-int field-width) (rand-int field-height)]
   :color (Color. 210 50 90)
   :type :apple})

(defn point-to-screen-rect [[pt-x pt-y]]
  [(* pt-x point-size) (* pt-y point-size) point-size point-size])

(defn move [{:keys [body direction] :as snake} & grow]
  (assoc snake :body
         (cons
          (let [[head-x head-y] (first body)
                [dir-x dir-y] direction]
            [(+ head-x dir-x) (+ head-y dir-y)])
          (if grow body (butlast body)))))

(defn turn [snake direction]
  (assoc snake :direction direction))

(defn win? [{body :body}]
  >= (count body) win-length)

(defn head-overlaps-body? [head body]
  (contains? (set body) head))

(defn head-outside-bounds? [[head-x head-y]]
  (or
   (> head-x field-width)
   (< head-x 0)
   (> head-y field-height)
   (< head-y 0)))

(defn lose? [{[head & body] :body}]
  (or (head-overlaps-body? head body)
      (head-outside-bounds? head)))

(defn eats? [{[head] :body} {apple :location}]
  (= head apple))

;mutations