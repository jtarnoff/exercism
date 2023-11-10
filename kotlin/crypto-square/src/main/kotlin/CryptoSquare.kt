import kotlin.math.roundToInt
import kotlin.math.sqrt

object CryptoSquare {

    fun ciphertext(plaintext: String): String {
        val stripped = plaintext.filter { it.isLetter() || it.isDigit() }.lowercase()
        val size = stripped.length

        if (stripped.isEmpty()) return ""

        val r = sqrt(size.toDouble()).roundToInt()
        var c = r
        if (r * r < stripped.length) {
            c += 1
        }

        val chunkedList = stripped.chunked(c)
        return (0 until chunkedList.maxOf { it.length }).joinToString(" ") { index ->
            chunkedList.fold("") { acc, s ->
                if (index < s.length) {
                    acc + s[index]
                } else {
                    acc + ' '
                }
            }
        }
    }

}
