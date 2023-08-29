data class MatrixCoordinate(val row: Int, val col: Int)

class Matrix(val rows: List<List<Int>>) {
    val saddlePoints: MutableSet<MatrixCoordinate> = mutableSetOf()

    init {
        rows.forEachIndexed { row, cols -> // 1, [1,2,3]
            cols.forEachIndexed { col, value ->
                if (isHighestInRow(rows[row], col) && isLowestInColumn(rows.map { it[col] }, row)) {
                    saddlePoints.add(MatrixCoordinate(row + 1, col + 1))
                }
            }
        }
    }

    fun isHighestInRow(row: List<Int>, index: Int): Boolean {
        return row.maxOrNull()!! == row[index]
    }

    fun isLowestInColumn(col: List<Int>, index: Int): Boolean {
        return col.minOrNull()!! == col[index]
    }
}