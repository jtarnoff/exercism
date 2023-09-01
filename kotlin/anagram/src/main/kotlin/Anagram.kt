class Anagram(val input: String) {

    fun match(anagrams: Collection<String>): Set<String> {
        return anagrams.filter { str ->
            str.isAnagramOf(input)
        }.toSet()
    }

    fun String.isAnagramOf(input: String): Boolean {
        return (this.lowercase() != input.lowercase())
                && ('a'..'z').all {c ->
            this.lowercase().count { it == c } == input.lowercase().count{ it == c }
        }
    }
}
