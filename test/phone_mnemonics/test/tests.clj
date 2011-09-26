(ns phone-mnemonics.test.tests
  (:use [phone-mnemonics.core])
  (:use [midje.sweet])
  (:require [clojure.string :as str]))

(unfinished)

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

(defn number-for-word [word]
  (map char-code (.toUpperCase word)))

(defn words-for-num[] (group-by number-for-word (filter #(<= (count %) 8) (words))))

(fact "A map of mnemonics must be available"
  mnemonics => (contains {\2 "ABC"}))

(fact "We only want words that are 8 letters or shorter mapped by their corresponding number"
  (words-for-num) => (in-any-order {...key... ["short"] ...key2... ["medium"] ...key3... ["8letters"]})
  (provided
    (number-for-word "short") => ...key...
    (number-for-word "medium") => ...key2...
    (number-for-word "8letters") => ...key3...
    (number-for-word "10letters") => ...key3... :times 0
    (words) => #{"short" "medium" "8letters" "10letters"}))

(fact "We want to translate a word into a number"
  (number-for-word "OI") => [\6 \4]
    (provided
      (char-code \O) => \6
      (char-code \I) => \4))

(fact "Numbers should be mapped by letter"
  (char-code \O) => \6
  (char-code \I) => \4)

(fact "Words should be found in the dicionary"
  (take 1 words) => ["A"])
