import kotlin.math.absoluteValue

class Squares(val size: Int) {
    val list: List<Int> = (1 .. size).toList()

    fun sumOfSquares() : Int {
        return list.sumOf { it * it }
    }

    fun squareOfSum() : Int {
        val sum = list.sum()
        return sum * sum
    }

    fun difference() : Int {
        return (sumOfSquares() - squareOfSum()).absoluteValue
    }
}
