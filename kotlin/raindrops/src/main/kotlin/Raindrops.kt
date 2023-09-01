object Raindrops {
    fun convert(n: Int): String {
        val list = listOf(
            3 to "Pling",
            5 to "Plang",
            7 to "Plong")

        val str = list.fold("") { s, it ->
            if (n % it.first == 0) { s + it.second } else s
        }
        return str.ifEmpty { n.toString() }
    }
}
