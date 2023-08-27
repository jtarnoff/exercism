class Robot {
    val tag = "ROBOT"

    companion object {
        val nameList: MutableList<String> = mutableListOf()
    }

    var name: String = getNewName()

    fun reset() {
        name = getNewName()
    }

    fun getNewName(): String {
        var proposedName = generateName()
        var isUnique = false
        while (!isUnique)
            if (nameList.contains(proposedName)) {
//                println("checked list for proposed name: $proposedName")
                proposedName = generateName()
            } else {
//                println("found a unique name")
                isUnique = true
            }

        nameList.add(proposedName)
        println("name added to list: ${nameList.size}")
        return proposedName
    }

    fun generateName(): String {
        return listOf(
            ('A'..'Z').random(),
            ('A'..'Z').random(),
            (0..9).random(),
            (0..9).random(),
            (0..9).random()
        ).joinToString("")
    }
}
