package com.splanes.kotlin.leetcode.exercises.strings

import com.splanes.kotlin.leetcode.util.log

fun main() {
  val zigZagConversion = ZigZagConversion()

  val input = "PAYPALISHIRING"
  var numRows = 3
  var expected = "PAHNAPLSIIGYIR"
  var actual = zigZagConversion.convert(input, numRows)
  log(
    case = 1,
    input = "$input, numRows = $numRows",
    expected = expected,
    actual = actual
  )

  numRows = 4
  expected = "PINALSIGYAHRPI"
  actual = zigZagConversion.convert(input, numRows)
  log(
    case = 2,
    input = "$input, numRows = $numRows",
    expected = expected,
    actual = actual
  )
}

/**
 * ## ZigZagConversion
 * ### Code: 6
 *
 * Given a string s and an integer numRows, this class provides a method to rearrange
 * the string in a zigzag pattern on a given number of rows and then read it row by row.
 *
 * The string is written in a zigzag pattern as specified by the number of rows.
 * After arranging the string in the zigzag format, the result is obtained by reading
 * the characters row-wise.
 *
 * ### Parameters
 * - s: The input string to be transformed.
 * - numRows: The number of rows to use for the zigzag pattern.
 *
 * ### Returns
 * A string representing the zigzag-converted output.
 *
 * ### Constraints
 * - If the input string has only one character or if numRows is equal to 1, the original string is returned.
 *
 * ### Example
 * Input: s = "PAYPALISHIRING", numRows = 3
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * Output: "PAHNAPLSIIGYIR"
 */
class ZigZagConversion {

  /**
   * My solution
   */
  fun convert(s: String, numRows: Int): String {
    val chars = s.toCharArray()
    val result = mutableMapOf<Int, MutableList<Char>>()
    var row = 0
    var col = 0

    if (s.count() == 1 || numRows == 1) return s

    for (c in chars) {
      if (col % (numRows - 1) == 0) {
        result[row] = result.getOrDefault(row, mutableListOf()).apply { add(c) }
        row++
        if (row == numRows) {
          row = 0
          col++
        }
      } else {
        val auxCol = if (col > (numRows - 1)) {
          col % (numRows - 1)
        } else {
          col
        }

        val expectedRow = (numRows - 1) - auxCol
        result[expectedRow] = result.getOrDefault(expectedRow, mutableListOf()).apply { add(c) }
        row = 0
        col++
      }
    }
    return result.values.flatten().joinToString("")
  }

  fun aiSolution(s: String, numRows: Int): String {
    if (numRows == 1 || s.length <= numRows) return s

    val rows = Array(numRows) { StringBuilder() }
    var currentRow = 0
    var goingDown = false

    for (char in s) {
      rows[currentRow].append(char)
      if (currentRow == 0 || currentRow == numRows - 1) goingDown = !goingDown
      currentRow += if (goingDown) 1 else -1
    }

    return rows.joinToString("") { it.toString() }
  }
}