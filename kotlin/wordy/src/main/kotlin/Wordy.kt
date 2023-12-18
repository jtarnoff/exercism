object Wordy {

    fun answer(input: String): Int {
        val regex = """What is [-]*[\d]+( (plus|minus|multiplied by|divided by) [-]*[\d]+)*\?""".toRegex()
        val matched = regex.matchEntire(input)

        if (matched == null) {
            println("unmatched")
        } else {
            println("matched: $matched")
            println("matched.groupValues: ${matched.groupValues}")
        }

        return 0
    }
}
