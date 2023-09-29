class DiamondPrinter {
    fun printToList(c: Char): List<String> {
        val level = c - 'A'
        val results = mutableListOf<String>()

        for(index in 0 until level + 1) {
            val charArray = " ".repeat(level + 1).toCharArray()
            charArray[level - index] = ('A' + index)
            val reversed = charArray.take(charArray.size - 1).reversed()
            results.add(charArray.joinToString("") + reversed.joinToString(""))
        }

        results.addAll(results.take(results.size - 1).reversed())
        return results
    }
}
