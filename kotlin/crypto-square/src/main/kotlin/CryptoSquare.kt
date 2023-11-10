import kotlin.math.roundToInt
import kotlin.math.sqrt

object CryptoSquare {

    fun ciphertext(plaintext: String): String {
        val stripped = plaintext.filter { it.isLetter() || it.isDigit() }.lowercase()
        val size = stripped.length

        if (stripped.isEmpty()) return ""

        // determine number of rows/cols
        // x*r + y*c = stripped.length
        // c >= r
        // c - r >= 1

        val r = sqrt(size.toDouble()).roundToInt()
        val c = sqrt(size.toDouble()).roundToInt() + 1
        println("size: $size")
        println("r: $r")
        println("c: $c")

        val chunkedList = stripped.chunked(c)
        println("chunkedList: $chunkedList")

//        val invertedList = chunkedList.mapIndexed { index, _ ->
        val invertedList = (0..chunkedList.maxOf { it.length }).map { index ->
            chunkedList.fold("") { acc, s ->
                if (index < s.length) {
                    acc + s[index]
                } else {
                    acc + ' '
                }
            }
        }

        println("invertedList: $invertedList")

        return invertedList.joinToString(" ")
    }

}
