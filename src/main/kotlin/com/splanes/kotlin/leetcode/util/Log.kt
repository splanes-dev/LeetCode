package com.splanes.kotlin.leetcode.util

fun log(
  case: Int,
  input: Any,
  expected: Any,
  actual: Any
) {
  println(
    """
      
      Case $case
      ------
      | Input: $input
      | Expected: $expected
      | Actual: $actual
    """.trimIndent()
  )
}