package com.splanes.kotlin.leetcode.exercises.integers

import com.splanes.kotlin.leetcode.util.log

fun main() {
  val reverseInteger = ReverseInteger()
  val input = -123
  val expected = -321
  val actual = reverseInteger.reverse(input)

  log(
    case = 1,
    input = input,
    expected = expected,
    actual = actual
  )
}

/**
 * ## ReverseInteger
 * ### Code: 7
 * A class that provides functionality to reverse the digits of an integer.
 *
 * This class includes a method to reverse the order of digits in a given integer.
 * It ensures that the reversed value is handled correctly based on the size
 * constraints of a 32-bit signed integer.
 */
class ReverseInteger {
  fun reverse(x: Int): Int {
    val numStr = x.toString()
    return numStr
      .reversed()
      .let { num -> if (x < 0) num.dropLast(1) else num }
      .toIntOrNull()
      ?.let { num -> if (x < 0) -num else num } ?: 0
  }
}