object Acronym {
    fun generate(phrase: String) : String {
        return phrase.split(' ','-').fold("") { str, it ->
            val c = it.firstOrNull { it.isLetter() }?.uppercase()
            if (c == null) { str } else str + c
        }
    }
}
