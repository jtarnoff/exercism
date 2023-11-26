object RunLengthEncoding {

    fun encode(input: String): String {
        val marker = '^'
        var counter = 0

        return input
            .mapIndexed { index, ch ->
                if (input.isNextCharEqual(index)) marker else ch
            }
            .joinToString("")
            .mapIndexed { index, ch ->
                if (ch == marker) {
                    counter++
                    ch
                } else if (counter > 0) {
                    val temp = (counter + 1).toString() + ch
                    counter = 0
                    temp
                } else {
                    ch
                }
            }
            .joinToString("")
            .filter { it != marker }
    }

    fun decode(input: String): String {
        val marker = '^'
        var holder = ""
        var listHolder = emptyList<String>()

        return input
            .mapIndexed { index, ch ->
                if (ch.isDigit() && input.isNextCharANumber(index)) {
                    holder += ch
                    marker.toString()
                } else if (ch.isDigit()) {
                    val temp = holder + ch
                    holder = ""
                    temp
                } else {
                    ch.toString()
                }
            }
            .filter { it != marker.toString() }
            .also { listHolder = it }
            .mapIndexed { index, str ->
                if (str.all { it.isDigit() }) {
                    var temp = ""
                    val next = listHolder[index + 1]
                    repeat(str.toInt() - 1) { temp += next }
                    temp
                } else {
                    str
                }
            }
            .joinToString("")
    }

    private fun String.isNextCharEqual(index: Int): Boolean {
        return this.length > index + 1 && this[index + 1] == this[index]
    }

    private fun String.isNextCharANumber(index: Int): Boolean {
        return this.length > index + 1 && this[index + 1].isDigit()
    }
}
