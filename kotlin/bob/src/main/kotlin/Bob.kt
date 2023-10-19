object Bob {
    fun hey(input: String): String {
        println("input.isQuestion: ${input.isQuestion()}")
        println("input.isYelling: ${input.isYelling()}")
        println("input.isSilence: ${input.isSilence()}")
        return when {
            input.isQuestion() && input.isYelling() -> "Calm down, I know what I'm doing!"
            input.isQuestion() -> "Sure."
            input.isYelling() -> "Whoa, chill out!"
            input.isSilence() -> "Fine, be that way!"
            else -> "Whatever."
        }
    }

    private fun String.isQuestion(): Boolean = this.last() == '?'
    private fun String.isYelling(): Boolean = this.filter { it.isLetter() }.all { it.isUpperCase() }
            && this.any { it.isUpperCase() }

    private fun String.isSilence(): Boolean = this.isEmpty() || this.all { it.isWhitespace() }

}
