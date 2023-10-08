object Luhn {

    fun isValid(candidate: String): Boolean {
        val filtered = candidate.filter { it != ' ' }
        if (filtered.isEmpty()
            || filtered.any { !it.isDigit() }
            || filtered == "0")
            return false

        return filtered.reversed().mapIndexed { index, chr ->
            (chr.digitToInt())
                .let { if (index % 2 == 1) it * 2 else it }
                .let { if (it >= 10) it - 9 else it }
        }.sum() % 10 == 0
    }
}
