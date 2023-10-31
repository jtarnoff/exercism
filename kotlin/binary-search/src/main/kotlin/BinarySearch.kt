object BinarySearch {
    fun search(list: List<Int>, item: Int): Int {
        if (!list.contains(item)) { throw NoSuchElementException() }
        return list.indexOf(item)
    // need to come back and finish this. key is if not found, list will eventually be empty
    }

    fun recursiveSearch(list: List<Int>, item: Int): Int {
        val middle = list[list.size / 2]

        println("list: $list")
        println("middle: $middle")

        return if (middle == item) {
            item
        } else if (middle > item) {
            search(list.subList(0, list.size / 2), item)
        } else {
            search(list.subList(list.size / 2, list.size), item)
        }
    }
}
