package com.splanes.kotlin.leetcode.exercises.strings

import com.splanes.kotlin.leetcode.util.log

fun main() {
  val longestPalindromicSubstring = LongestPalindromicSubstring()

  var input = "babad"
  var expected = "bab"
  var actual = longestPalindromicSubstring.find(input)

  log(
    case = 1,
    input = input,
    expected = expected,
    actual = actual
  )
  assert(expected == actual)

  input = "cbbd"
  expected = "bb"
  actual = longestPalindromicSubstring.find(input)

  log(
    case = 2,
    input = input,
    expected = expected,
    actual = actual
  )

  assert(expected == actual)
}

/**
 * ## LongestPalindromicSubstring
 * ### Code: 5
 *
 * Given a string s, return the longest palindromic substring in s.
 *
 * ### Example:
 * Input: s = "babad"
 *
 * Output: "bab"
 *
 * Explanation: "aba" is also a valid answer.
 */
class LongestPalindromicSubstring {

  fun find(input: String): String {
    val chars = input.toCharArray()
    val result = mutableListOf<Char>()
    val tmp = mutableListOf<Char>()
    var aux = chars.drop(1)

    for (char in chars) {
      tmp.add(char)
      for (c in aux) {
        tmp.add(c)
        if (tmp == tmp.reversed() && tmp.count() > result.count()) {
          result.clear()
          result.addAll(tmp)
        }
      }
      aux = aux.drop(1)
      tmp.clear()
    }

    return result.joinToString("")
  }
}