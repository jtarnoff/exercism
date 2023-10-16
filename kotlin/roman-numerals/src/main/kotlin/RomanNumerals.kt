object RomanNumerals {

    fun value(n: Int): String {
        return n.toString().mapIndexed { index: Int, c: Char ->
            val indexFromRight = n.toString().length - index - 1
            convertNumToNumeral(
                c.digitToInt(),
                getCharacter(indexFromRight).first,
                getCharacter(indexFromRight).second,
                getCharacter(indexFromRight + 1).first
            )
        }.joinToString("")
    }

    private fun convertNumToNumeral(num: Int, charOne: Char, charFive: Char, charTen: Char): String {
        return when (num) {
            1 -> charOne.toString()
            2 -> charOne.toString() + charOne
            3 -> charOne.toString() + charOne + charOne
            4 -> charOne.toString() + charFive
            5 -> charFive.toString()
            6 -> charFive.toString() + charOne
            7 -> charFive.toString() + charOne + charOne
            8 -> charFive.toString() + charOne + charOne + charOne
            9 -> charOne.toString() + charTen
            else -> ""
        }
    }

    private fun getCharacter(indexFromRight: Int): Pair<Char, Char> {
        require(indexFromRight in 0..4)
        return when (indexFromRight) {
            0 -> Pair('I', 'V')
            1 -> Pair('X', 'L')
            2 -> Pair('C', 'D')
            3 -> Pair('M', '?')
            else -> Pair('?', '?')
        }
    }
}