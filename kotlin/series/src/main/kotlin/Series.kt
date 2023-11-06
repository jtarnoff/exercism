object Series {

    fun slices(n: Int, s: String): List<List<Int>> {
        require(n in 0..s.length)
        return s.windowed(n, 1).map { str ->
            str.map { it.digitToInt() }
        }
    }
}
