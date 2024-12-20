package com.splanes.kotlin.leetcode.strings

fun main() {

  val longestSubstringWithoutRepeatingChars = LongestSubstringWithoutRepeatingChars()

  var input = "abcabcbb"
  var expected = 3
  var actual = longestSubstringWithoutRepeatingChars.find(input)

  println(
    """
      Case 1
      ------
      Input: $input
      Expected: $expected
      Actual: $actual
    """.trimIndent()
  )
  assert(expected == actual)

  input = "bbbbb"
  expected = 1
  actual = longestSubstringWithoutRepeatingChars.find(input)

  println(
    """
      Case 2
      ------
      Input: $input
      Expected: $expected
      Actual: $actual
    """.trimIndent()
  )
  assert(expected == actual)

  input = "pwwkew"
  expected = 3
  actual = longestSubstringWithoutRepeatingChars.find(input)

  println(
    """
      Case 3
      ------
      Input: $input
      Expected: $expected
      Actual: $actual
    """.trimIndent()
  )
  assert(expected == actual)
}

/**
 * ## Description
 * ### Code: 3
 *
 * Given a string s, find the length of the longest
 * substring without repeating characters.
 *
 * ### Example
 * Input: s = "abcabcbb"
 *
 * Output: 3
 *
 * Explanation: The answer is "abc", with the length of 3.
 */
class LongestSubstringWithoutRepeatingChars {

  fun find(anyString: String): Int {

    val chars = anyString.toCharArray()
    val founds = mutableListOf<Char>()
    val aux = mutableListOf<Char>()
    var array = chars

    for (char in chars) {
      for (c in array) {
        if (!aux.contains(c)) {
          aux.add(c)
        } else if (aux.count() > founds.count()) {
          founds.clear()
          founds.addAll(aux)
          aux.clear()
          array = array.drop(1).toCharArray()
          break
        } else {
          aux.clear()
          array = array.drop(1).toCharArray()
          break
        }
      }
    }

    return founds.count().coerceAtLeast(1)
  }
}