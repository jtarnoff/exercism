class Series(val input: String) {
    init { require(input.all { it.isDigit() }) }

    fun getLargestProduct(span: Int): Long {
        require(span > 0)
        require(span <= input.length)

        return input.substring(0, input.length - span + 1).mapIndexed { index, _ ->
            input.substring(index, index + span)
        }.maxOf {
            it.fold(1) { acc, chr -> acc * chr.digitToInt() }
        }.toLong()
    }
}
