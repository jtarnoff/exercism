object PigLatin {
    fun translate(phrase: String): String {
        return phrase.split(" ").fold("") { acc, s ->
            acc.plus(checkWord(s)).plus(" ")
        }.trim()
    }

    fun checkWord(word: String): String {
        return when {
            word.checkRuleFive() -> word.applyRuleFive()
            word.checkRuleThree() -> word.applyRuleThree()
            word.checkRuleOne() -> word.applyRuleOne()
            word.checkRuleTwo() -> word.applyRuleTwo()
            word.checkRuleFour() -> word.applyRuleFour()
            else -> word
        }
    }

    fun String.checkRuleOne(): Boolean {
        val prefix = listOf("a", "e", "i", "o", "u", "xr", "yt").firstOrNull() {
            this.startsWith(it, true)
        }
        return prefix != null
    }

    fun String.applyRuleOne() : String {
        return this + "ay"
    }

    fun String.checkRuleTwo(): Boolean {
        return this.indexOfFirst { listOf('a', 'e', 'i', 'o', 'u').contains(it.lowercaseChar()) } > 0
    }

    fun String.applyRuleTwo(): String {
        val index = this.indexOfFirst { listOf('a', 'e', 'i', 'o', 'u').contains(it.lowercaseChar()) }
        return this.substring(index).plus(this.take(index)).plus("ay")
    }

    fun String.checkRuleThree(): Boolean {
        return Regex("""^[^aeiou](qu).*""").matches(this)
    }

    fun String.applyRuleThree(): String {
        val index = if (this.first() == 'q') 2 else 3
        return this.substring(index).plus(this.take(index)).plus("ay")
    }

    fun String.checkRuleFour(): Boolean {
        return Regex(""".y""").matches(this) ||
                Regex("""[^aeiou]+y.*""").matches(this)
    }

    fun String.applyRuleFour(): String {
        val index = this.indexOf('y', ignoreCase = true)
        return this.substring(index).plus(this.take(index)).plus("ay")
    }

    fun String.checkRuleFive(): Boolean {
        return Regex("""^(qu).*""").matches(this)
    }

    fun String.applyRuleFive(): String {
        return this.substring(2).plus(this.take(2)).plus("ay")
    }
}
