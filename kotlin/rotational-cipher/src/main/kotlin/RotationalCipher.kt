class RotationalCipher(val shift: Int) {
    fun encode(text: String): String {
        return text.map(this::rotate).joinToString("")
    }

    private fun rotate(c: Char): Char {
        return when {
            c.isLowerCase() -> Char((c.code - 97 + shift) % 26 + 97)
            c.isUpperCase() -> Char((c.code - 65 + shift) % 26 + 65)
            else -> c
        }
    }
}