;; Adapted from "An empirical comparison of C, C++, Java, Perl,
;; Python, Rexx, and Tcl for a search/string-processing program"
;; by Lutz Prechelt


;; This was a 15-minute effort while listening to a talk. It's *not*
;; well thought-out or designed.

;; By Stuart Sierra,
;; @stuartsierra on Twitter

(ns phone-mnemonics.fasit.phone-code
  (:require [clojure.set :as set])
  (:require [clojure.string :as str]))

(def words
  (str/split-lines (slurp "/usr/share/dict/words")))

(def mnemonics {\2 "ABC"
                \3 "DEF"
                \4 "GHI"
                \5 "JKL"
                \6 "MNO"
                \7 "PQRS"
                \8 "TUV"
                \9 "WXYZ"})

(def char-code
  (into {} (for [[digit string] mnemonics letter string] [letter digit])))

(defn word-code [word]
  (map char-code (.toUpperCase word)))

(def words-for-num
  (group-by word-code (filter #(<= (count %) 8) words)))

(defn encode
  "Given phone number digits as a string, return a set of possible
  word phrases which can be made from it."
  [number]
  (reduce clojure.set/union
          (for [split-point (range (count number))]
            (let [[first-words second-words] (map words-for-num (split-at split-point number))]
              (if (seq first-words)
                (set (for [first-word first-words
                           second-word second-words]
                       
                       (str first-word " " second-word)))
                (set second-words))))))

(comment
  ;; The first letter-code phone number, during a measles epidemic,
  ;; was 1-800-MEASLES.
  (encode "6327537")
  ;;=> #{... "measles" ... }
  )
(encode "6327537")