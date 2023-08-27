object WordCount {
    fun phrase(phrase: String): Map<String, Int> {
        val map = mutableMapOf<String, Int>()
        val sentences = phrase.split('.', '?', '!', ',', '@', '$', '%', '^', '&', '*', ':')
        val words = sentences.flatMap { it.split('\n', '\t', ' ') }
        words.filter(String::isNotEmpty)
                .map { it.lowercase() }
                .map { it.trim('\'', '\"')}
                .forEach {
            if (map.containsKey(it)) {
                var value = map[it]
                if (value == null) {
                    map[it] = 1
                } else {
                    map[it] = value.plus(1)
                }
            } else {
                map[it] = 1
            }
        }
        return map
    }
}
