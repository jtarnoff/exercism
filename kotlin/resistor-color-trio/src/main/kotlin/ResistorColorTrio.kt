object ResistorColorTrio {

    fun text(vararg input: Color): String {
        val number = input.asList()
            .take(2)
            .fold("") { acc, color -> acc + color.ordinal.toString() }
        val zeroes = number.takeLastWhile { it == '0' }.length + input.asList()[2].ordinal
        val units = "${"0".repeat(zeroes % 3)} " + Unit.values()[zeroes / 3].toString().lowercase()

        return "${number.trim { it == '0' }}$units"
    }
}
