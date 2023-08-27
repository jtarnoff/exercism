object ScrabbleScore {

    fun scoreLetter(c: Char): Int {
        return when (c.lowercaseChar()) {
            'q','z' -> 10
            'j','x' -> 8
            'k' -> 5
            'f', 'h', 'v', 'w', 'y' -> 4
            'b', 'c', 'm', 'p' -> 3
            'd', 'g' -> 2
            else -> 1
        }
    }

    fun scoreWord(word: String): Int {
        var score = 0
        for (c in word) {
            score = score + scoreLetter(c)
        }
        return score
    }
}