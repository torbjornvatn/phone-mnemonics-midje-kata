(ns phone-mnemonics.test.tests
  (:use [phone-mnemonics.core])
  (:use [midje.sweet]))

(unfinished words)

(def mnemonics {\2 "ABC"
                \3 "DEF"
                \4 "GHI"
                \5 "JKL"
                \6 "MNO"
                \7 "PQRS"
                \8 "TUV"
                \9 "WXYZ"})

(defn encode[number]
  #{(first (words))})

(fact "A number should be encoded to one or more matching words"
  (encode ...number...) => #{...word...}
  (provided
    (words) => #{...word... ...another-word...}))

(fact "A map of mnemonics must be available"
  mnemonics => (contains {\2 "ABC"}))

