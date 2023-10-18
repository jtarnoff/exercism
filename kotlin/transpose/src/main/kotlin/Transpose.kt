object Transpose {

    fun transpose(input: List<String>): List<String> {
        if (input.isEmpty()) return listOf()
        val numRows = input.maxOf { it.length }

        val output = Array(numRows) { _ -> "" }
        for (i in 0 until numRows) {
            output[i] = input.map { it.replace(' ', '%') }
                .fold("") { acc, str -> acc + str.elementAtOrElse(i) { _ -> ' ' } }
                .take(input.size)
                .trimEnd()
                .replace('%', ' ')
        }
        return output.asList()
    }
}
