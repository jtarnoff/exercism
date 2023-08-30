class Deque<Int> {
    val list: MutableList<Node> = listOf()

    fun push(value: Int) {
        if (list.isEmpty()) {
            list.add(Node(value, null))
        }

    }

    fun pop(): Int? {
        TODO("Implement this function to complete the task")
    }

    fun unshift(value: Int) {
        TODO("Implement this function to complete the task")
    }

    fun shift(): Int? {
        TODO("Implement this function to complete the task")
    }

    data class Node(
        val data: Int,
        val next: Node?
    )
}

