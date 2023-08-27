object Hamming {

    fun compute(leftStrand: String, rightStrand: String): Int {
        if (leftStrand.length != rightStrand.length)
            throw IllegalArgumentException("left and right strands must be of equal length")

        var sum = 0
        leftStrand.mapIndexed { index, leftChar ->
            sum += if (leftChar.equals(rightStrand[index])) 0 else 1
        }
        return sum
    }
}
