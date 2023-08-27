class Matrix(private val matrixAsString: String) {
    fun column(colNr: Int): List<Int> {
        val rows = matrixAsString.split('\n')
        return rows.map { row ->
            row.split(' ')[colNr - 1].toInt()
        }
    }

    fun row(rowNr: Int): List<Int> {
        val row = matrixAsString.split('\n')[rowNr - 1]
        return row.split(' ').map { it.toInt() }
    }
}
