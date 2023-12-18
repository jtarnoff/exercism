object RunLengthEncoding {

    fun encode(input: String): String {
        var counter = 0

        return input
            .mapIndexed { index, ch ->
                if (input.isNextCharEqual(index)) {
                    counter++
                    ""
                } else if (counter > 0) {
                    "${counter + 1}$ch".also { counter = 0 }
                } else {
                    ch
                }
            }
            .joinToString("")
    }

    fun decode(input: String): String {
        val marker = '^'
        var holder = ""
        var listHolder = emptyList<String>()

        return input
            .mapIndexed { index, ch ->
                if (ch.isDigit() && input.isNextCharANumber(index)) {
                    holder += ch
                    ""
                } else if (ch.isDigit()) {
                    (holder + ch).also { holder = "" }
                } else {
                    ch.toString()
                }
            }
            .also { listHolder = it }
            .mapIndexed { index, str ->
                if (str.all { it.isDigit() } && str.isNotEmpty()) {
                    str.replaceNumWithChars(listHolder[index + 1].first())
                } else {
                    str
                }
            }
            .joinToString("")
    }

    private fun String.replaceNumWithChars(newChar: Char): String =
        (1 until this.toInt()).map { newChar }.joinToString("")

    private fun String.isNextCharEqual(index: Int): Boolean =
        this.length > index + 1 && this[index + 1] == this[index]

    private fun String.isNextCharANumber(index: Int): Boolean =
        this.length > index + 1 && this[index + 1].isDigit()
}
