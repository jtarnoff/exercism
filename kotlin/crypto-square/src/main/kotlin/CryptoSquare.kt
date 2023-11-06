import kotlin.math.roundToInt
import kotlin.math.sqrt

object CryptoSquare {

    fun ciphertext(plaintext: String): String {
        val stripped = plaintext.filter { it.isLetter() || it.isDigit() }
        val size = stripped.length

        // determine number of rows/cols
        // x*r + y*c = stripped.length
        // c >= r
        // c - r >= 1

        val r = sqrt(size.toDouble()).roundToInt() - 1
        val c = sqrt(size.toDouble()).roundToInt()
        println("size: $size")
        println("r: $r")
        println("c: $c")

        val chunkedList = stripped.chunked(c)
        println("chunkedList: $chunkedList")

        val invertedList = chunkedList.mapIndexed { index, _ ->
            chunkedList.fold("") { acc, s -> acc + s[index].lowercase() }
        }
        println("invertedList: $invertedList")

//        (1..invertedList.size).forEachIndexed { index, str ->
//            invertedList.mapIndexed()
//        }

//        val newList = invertedList.mapIndexed { index, str ->
//            invertedList.fold("") { acc, str ->
//                 acc + str[index]
//            }
//        }

        return invertedList.joinToString(" ")
    }

}
