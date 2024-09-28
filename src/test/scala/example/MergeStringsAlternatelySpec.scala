package example

import org.scalatest.funsuite.AnyFunSuite
import example.Solution.mergeAlternately

class MergeStringsAlternately extends AnyFunSuite {

  test("example 1") {
    val word1 = "abc"
    val word2 = "pqr"
    val expected = "apbqcr"
    assert(mergeAlternately(word1, word2) == expected)
  }

// Notice that as word2 is longer, "rs" is appended to the end.
  test("example 2") {
    val word1 = "ab"
    val word2 = "pqrs"
    val expected = "apbqrs"
    assert(mergeAlternately(word1, word2) == expected)
  }

// Notice that as word1 is longer, "cd" is appended to the end.
  test("example 3") {
    val word1 = "abcd"
    val word2 = "pq"
    val expected = "apbqcd"
    assert(mergeAlternately(word1, word2) == expected)
  }

}
