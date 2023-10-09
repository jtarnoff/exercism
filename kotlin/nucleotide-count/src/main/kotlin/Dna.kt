class Dna(val input: String) {

    init {
        require(Regex("""[AGCT]*""").matches(input))
    }

    val nucleotideCounts: Map<Char, Int>
        get() {
            return listOf('A', 'C', 'G', 'T').map {
                it to input.count { chr -> it == chr }
            }.toMap()
        }
}
