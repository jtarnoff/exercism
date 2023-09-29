object BeerSong {
    fun verses(startBottles: Int, takeDown: Int): String {
        return (startBottles downTo takeDown).fold("") { acc, index ->
            acc + when (index) {
                0 -> "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
                1 -> "$index bottle of beer on the wall, $index bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n${if (takeDown != index) "\n" else ""}"
                2 -> "$index bottles of beer on the wall, $index bottles of beer.\nTake one down and pass it around, ${index - 1} bottle of beer on the wall.\n${if (takeDown != index) "\n" else ""}"
                else -> "$index bottles of beer on the wall, $index bottles of beer.\nTake one down and pass it around, ${index - 1} bottles of beer on the wall.\n${if (takeDown != index) "\n" else ""}"
            }
        }
    }
}
