object Bob {
    fun hey(input: String): String {
        return when {
            input.isEmpty() -> "Fine. Be that way!"
            input.isQuestion() && input.isYelling() -> "Calm down, I know what I'm doing!"
            input.isQuestion() -> "Sure."
            input.isYelling() -> "Whoa, chill out!"
            input.isSilence() -> "Fine. Be that way!"
            else -> "Whatever."
        }
    }

    private fun String.isQuestion(): Boolean = if (this.trimEnd().isEmpty()) false else this.trimEnd().last() == '?'
    private fun String.isYelling(): Boolean = this.filter { it.isLetter() }.all { it.isUpperCase() }
            && this.any { it.isUpperCase() }
    private fun String.isSilence(): Boolean = this.isEmpty() || this.all { it.isWhitespace() }
}
