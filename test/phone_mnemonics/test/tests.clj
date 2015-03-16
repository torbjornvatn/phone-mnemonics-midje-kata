(ns phone-mnemonics.test.tests
  (:use [phone-mnemonics.core])
  (:use [midje.sweet])
  (:require [clojure.string :as str]))

(unfinished)

(def mnemonics {\2 "ABC"
                \3 "DEF"
                \4 "GHI"
                \5 "JKL"
                \6 "MNO"
                \7 "PQRS"
                \8 "TUV"
                \9 "WXYZ"})

(fact "A map of mnemonics must be available"
  mnemonics => (contains {\2 "ABC"}))

(fact "We only want words that are 8 letters or shorter mapped by their corresponding number")

(fact "We want to translate a word into a number")

(fact "Numbers should be mapped by letter")

(fact "Words should be found in the dicionary")
