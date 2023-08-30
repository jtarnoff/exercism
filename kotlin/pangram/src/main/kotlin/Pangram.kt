object Pangram {
    val letterMap: MutableMap<Char, Int> = mutableMapOf()

    fun isPangram(input: String): Boolean {
        input.forEach {
            letterMap.put(it, letterMap[it]?.plus(1) ?: 1)
        }
        for(c in 'a'..'z') {
            if (letterMap[c] == null || letterMap[c]!!.equals(0)) {
                return false
            }
        }
        return true
    }
}
