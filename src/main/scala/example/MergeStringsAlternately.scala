package example

import scala.collection.View.Empty

/*
You are given two strings word1 and word2.
Merge the strings by adding letters in alternating order, starting with word1.
If a string is longer than the other, append the additional letters onto the end of the merged string.
Return the merged string.

Constraints:
1 <= word1.length, word2.length <= 100
word1 and word2 consist of lowercase English letters.
 */

// La solucion utilizando recursion es ampliamente mas performante
object Solution {
  def mergeAlternately(word1: String, word2: String): String = {

    def recur(word1: String, word2: String, res: String): String = {
      if (word1.isEmpty || word2.isEmpty) res + word1 + word2
      else recur(word1.tail, word2.tail, res + word1.head + word2.head)
    }
    recur(word1, word2, "")
  }
}

// Recursion + StringBuilder and Appends
object SolutionB {
  def mergeAlternately(word1: String, word2: String): String = {

    def recur(
        word1: String,
        word2: String,
        res: StringBuilder
    ): StringBuilder = {
      if (word1.isEmpty) {
        res.append(word2) // Append remaining word2 if word1 is empty
      } else if (word2.isEmpty) {
        res.append(word1) // Append remaining word1 if word2 is empty
      } else {
        res.append(word1.head) // Append the head of word1
        res.append(word2.head) // Append the head of word2
        recur(
          word1.tail,
          word2.tail,
          res
        ) // Tail call with the tails of the words
      }
    }

    recur(word1, word2, new StringBuilder)
      .toString() // Convert StringBuilder to String
  }
}

/*
Uses of:
- StringBuilder -> proporciona métodos convenientes como append, insert, delete, y replace
- StringBuilder -> permite modificar su contenido sin crear nuevos objetos
- SubString -> egins with the character at the specified index and extends to the end
    of this string
- Drop -> The rest of the string without its n first chars.
 */
object SolutionC {

  def mergeAlternatelyNormal(word1: String, word2: String): String = {

    val result = new StringBuilder

    // Recorremos todos los caracteres de word1
    for (i <- 0 until word1.length) {
      result.append(word1(i)) // Agrega caracter de word1
      if (i < word2.length)
        result.append(word2(i)) // Agrega caracter de word2 si existe
    }

    // Si word1 termina, agrega el resto de word2
    if (word1.length < word2.length) {

      result.append(word2.substring(word1.length))
    }

    result.toString()
  }
}
