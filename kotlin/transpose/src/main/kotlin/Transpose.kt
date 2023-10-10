import java.sql.Array

object Transpose {

    fun transpose(input: List<String>): List<String> {
        if (input.isEmpty()) return listOf()
        val numRows = input.maxOf {
            println("it: $it")
            println("it.length: ${it.length}")
            it.length
        }
        println("numRows: $numRows")

        val output = Array(numRows) { _ -> "" }

        for (i in 0 until numRows) {
            output[i] = input.fold("") { acc, str -> acc + str.elementAtOrElse(i) { _ -> ' ' } }.take(input.size).trimEnd()
        }

        println("output: $output")
        return output.asList()
    }
}
