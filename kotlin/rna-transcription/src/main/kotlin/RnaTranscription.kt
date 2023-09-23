fun transcribeToRna(dna: String): String {
    val charMap = mapOf(
        'G' to 'C',
        'C' to 'G',
        'T' to 'A',
        'A' to 'U'
    )
    return dna.map { charMap[it] }.joinToString("")
}
