class PhoneNumber(var number: String) {
    init {
        number = number.filter { it.isDigit() }
        if (number[0] == '1') number = number.drop(1)
        require(number.length == 10)
        require((2..9).contains(number[0].digitToInt()))
        require((2..9).contains(number[3].digitToInt()))
        returnStr(number)
    }
    private fun returnStr(str: String): String { return str }
}
