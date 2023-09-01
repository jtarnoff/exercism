object ResistorColorDuo {
    fun value(vararg colors: Color): Int {
        return colors.take(2)
            .fold("") { str, it ->
                str.plus(it.ordinal.toString())
            }.toInt()
    }
}
