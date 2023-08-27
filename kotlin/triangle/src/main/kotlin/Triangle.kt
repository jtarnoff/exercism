import java.lang.IllegalArgumentException

class Triangle(val a: Double, val b: Double, val c: Double) {
    constructor(a: Int, b: Int, c: Int) :
            this (a.toDouble(), b.toDouble(), c.toDouble())

    init {
        require(a > 0 && b > 0 && c > 0)
        require((a + b) > c && (a + c) > b && (b + c) > a)
    }

    val isEquilateral: Boolean = a.equals(b).and(a.equals(c))
    val isIsosceles: Boolean = a.equals(b) || b.equals(c) || a.equals(c)
    val isScalene: Boolean = !isIsosceles
}
