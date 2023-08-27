object Flattener {
    @Suppress("UNCHECKED_CAST")
    fun flatten(source: Collection<Any?>): List<Any> {
        var list = ArrayList<Int>()
        source.forEach {
            when(it) {
                is Int -> list.add(it)
                is List<*> -> {
                    list.addAll(flatten(it) as List<Int>)
                }
                else -> {}
            }
        }
        return list
    }
}
