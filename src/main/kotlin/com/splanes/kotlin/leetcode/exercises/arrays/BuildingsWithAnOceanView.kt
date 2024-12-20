package com.splanes.kotlin.leetcode.exercises.arrays

fun main() {

  val exercise = BuildingsWithAnOceanView()

  val input1 = arrayOf(4, 2, 3, 1)
  val expected1 = arrayOf(0, 2, 3)

  val input2 = arrayOf(4, 3, 2, 1)
  val expected2 = arrayOf(0, 1, 2, 3)

  val input3 = arrayOf(1, 3, 2, 4)
  val expected3 = arrayOf(3)

  val input4 = arrayOf(2, 2, 2, 2)
  val expected4 = arrayOf(3)

  var result = exercise.calculateVisibility(input1)
  assertExpected(
    title = "Case 1",
    input = input1,
    expected = expected1,
    actual = result
  )

  result = exercise.calculateVisibility(input2)
  assertExpected(
    title = "Case 2",
    input = input2,
    expected = expected2,
    actual = result
  )

  result = exercise.calculateVisibility(input3)
  assertExpected(
    title = "Case 3",
    input = input3,
    expected = expected3,
    actual = result
  )

  result = exercise.calculateVisibility(input4)
  assertExpected(
    title = "Case 4",
    input = input4,
    expected = expected4,
    actual = result
  )

  println("*** Success! ***")
}

fun assertExpected(
  title: String,
  input: Array<Int>,
  expected: Array<Int>,
  actual: Array<Int>,
) {
  println(
    """
      $title
      ------
      | Input: ${input.toList()}
      | Expected: ${expected.toList()}
      | Result: ${actual.toList()}
      
    """.trimIndent()
  )
  assert(expected.contentEquals(actual))
}

/**
 * ## Description
 * ### Code: 1762
 *
 * There are n buildings in a line. You are given an integer array heights of size n that represents the heights of the
 * buildings in the line.
 *
 * The ocean is to the right of the buildings. A building has an ocean view if the building can see the ocean without
 * obstructions. Formally, a building has an ocean view if all the buildings to its right have a smaller height.
 *
 * Return a list of indices (0-indexed) of buildings that have an ocean view, sorted in increasing order.
 *
 * Link: https://leetcode.ca/2021-04-14-1762-Buildings-With-an-Ocean-View/
 */
class BuildingsWithAnOceanView {

  fun calculateVisibility(input: Array<Int>): Array<Int> {

    val result = mutableListOf<Int>().apply { add(input.lastIndex) }

    var index = input.lastIndex - 1
    while (index >= 0) {
      val height = input[index]
      val subList = input.asList().subList((index + 1), input.size)

      if (subList.all { h -> h < height }) result.add(index)
      index--
    }

    return result.apply { reverse() }.toTypedArray()
  }
}