import kotlin.math.pow

object ArmstrongNumber {
    fun check(input: Int): Boolean {
        val str = input.toString()
        return input == str.fold(0) { sum, element -> sum + element.digitToInt().toDouble().pow(str.length).toInt() }
    }
}
