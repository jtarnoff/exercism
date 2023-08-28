object HandshakeCalculator {
    fun calculateHandshake(number: Int): List<Signal> {
        if (number < 1 || number > 32) return emptyList()

        val list = mutableListOf<Signal>()
        if (number % 2 == 1)
            list.add(Signal.WINK)  // 00011   00010
        if (number % 4 in (2..3) ) // 00011    // 00010
            list.add(Signal.DOUBLE_BLINK)
        if (number % 8 in (4..7))
            list.add(Signal.CLOSE_YOUR_EYES)
        if (number % 16 in (8..15))
            list.add(Signal.JUMP)
        if (number >= 16) {
            list.reverse()
        }
        return list
    }
}