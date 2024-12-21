package com.splanes.kotlin.leetcode.exercises.arrays

import com.splanes.kotlin.leetcode.util.log

fun main() {
  val twoSum = TwoSum()

  var input = intArrayOf(2,7,11,15)
  var target = 9
  var expected = intArrayOf(0,1)
  var actual = twoSum.twoSum(input, target)

  log(
    case = 1,
    input = "${input.toList()}, target = $target",
    expected = expected.toList(),
    actual = actual.toList()
  )
  assert(expected.contentEquals(actual))

  input = intArrayOf(3,2,4)
  target = 6
  expected = intArrayOf(1,2)
  actual = twoSum.twoSum(input, target)

  log(
    case = 2,
    input = "${input.toList()}, target = $target",
    expected = expected.toList(),
    actual = actual.toList()
  )
  assert(expected.contentEquals(actual))

  input = intArrayOf(3, 3)
  target = 6
  expected = intArrayOf(0,1)
  actual = twoSum.twoSum(input, target)

  log(
    case = 3,
    input = "${input.toList()}, target = $target",
    expected = expected.toList(),
    actual = actual.toList()
  )
  assert(expected.contentEquals(actual))
}

/**
 * ## Two Sum
 * ### Code: 1
 * A class that provides functionality to find indices of two numbers in an array that add up to a specific target.
 *
 * This class solves the "Two Sum" problem where the task is to identify two distinct indices `i` and `j` in an
 * array such that the numbers at these indices satisfy the equation nums[i] + nums[j] = target.
 *
 * ### Example
 * ```
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * ```
 */
class TwoSum {

  fun twoSum(nums: IntArray, target: Int): IntArray {
    val numMap = mutableMapOf<Int, Int>()
    for ((index, num) in nums.withIndex()) {
      val complement = target - num
      if (numMap.containsKey(complement)) {
        return intArrayOf(numMap[complement]!!, index)
      }
      numMap[num] = index
    }
    return intArrayOf()
  }
}