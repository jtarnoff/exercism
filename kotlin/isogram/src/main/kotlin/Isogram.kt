object Isogram {

    fun isIsogram(input: String): Boolean {
        return ('a'..'z').all { c -> c.isLetterOrDigit() && input.count { it.lowercaseChar() == c } < 2}
    }
}
