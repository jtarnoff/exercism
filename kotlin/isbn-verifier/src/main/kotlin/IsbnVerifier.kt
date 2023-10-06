class IsbnVerifier {
    fun isValid(number: String): Boolean {
        if (number.filter { it != '-' }.length != 10) return false

        return number.filter { it != '-' }.foldIndexed(0) { index, acc, chr ->
            when (chr) {
                'X' -> if (index != 9) return false else 10
                in '0'..'9' -> chr.digitToInt()
                else -> return false
            } * (10 - index)  + acc
        } % 11 == 0
    }
}
