package com.splanes.kotlin.leetcode.lists

fun main() {
  val addTwoNumbers = AddTwoNumbers()

  var num1 = ListNode(2, ListNode(4, ListNode(3)))
  var num2 = ListNode(5, ListNode(6, ListNode(4)))

  var actual = addTwoNumbers.add(num1, num2)
  var expected = ListNode(7, ListNode(0, ListNode(8)))

  println(
    """
      Case 1
      ------
      Expected: $expected
      Actual: $actual
    """.trimIndent()
  )
  assert(actual == expected)

  num1 = ListNode(0)
  num2 = ListNode(0)

  actual = addTwoNumbers.add(num1, num2)
  expected = ListNode(0)

  println(
    """
      Case 2
      ------
      Expected: $expected
      Actual: $actual
    """.trimIndent()
  )
  assert(actual == expected)

  num1 = ListNode(9, ListNode(9, ListNode(9, ListNode(9, ListNode(9, ListNode(9, ListNode(9)))))))
  num2 = ListNode(9, ListNode(9, ListNode(9, ListNode(9))))

  actual = addTwoNumbers.add(num1, num2)
  expected = ListNode(8, ListNode(9, ListNode(9, ListNode(9, ListNode(0, ListNode(0, ListNode(0, ListNode(1))))))))

  println(
    """
      Case 3
      ------
      Expected: $expected
      Actual: $actual
    """.trimIndent()
  )
  assert(expected.equals(actual))

  println("*** Success! ***")
}

/**
 * ## Description
 * ### Code: 2
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * #### Example
 * Input: l1 = [2,4,3] & l2 = [5,6,4]
 *
 * Output: [7,0,8]
 *
 * Explanation: 342 + 465 = 807.
 */
class AddTwoNumbers {

  fun add(num1: ListNode, num2: ListNode): ListNode {
    val resultList = mutableListOf<Int>()
    var currentNum1: ListNode? = num1
    var currentNum2: ListNode? = num2
    var i = 0

    while (currentNum1 != null || currentNum2 != null) {
      var value = (currentNum1?.value ?: 0) + (currentNum2?.value ?: 0) + i

      if (value >= 10) {
        value -= 10
        i = 1
      } else {
        i = 0
      }

      resultList.add(value)
      currentNum1 = currentNum1?.next
      currentNum2 = currentNum2?.next
    }

    if (i > 0) resultList.add(1)

    val nodes = resultList.map(::ListNode)

    for (n in 0 until nodes.lastIndex) {
      nodes[n].next = nodes[n + 1]
    }

    return nodes[0]
  }
}

class ListNode(
  var value: Int,
  var next: ListNode? = null
) {
  override fun toString(): String {
    return "ListNode(value=$value, next=$next)"
  }

  override fun equals(other: Any?): Boolean {
    return if (other is ListNode) {
      value == other.value && (next?.equals(other) == true)
    } else {
      false
    }
  }

  override fun hashCode(): Int {
    return javaClass.hashCode()
  }
}