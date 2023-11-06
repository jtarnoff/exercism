class CustomSet(vararg ints: Int) {

    private var list = mutableListOf<Int>()

    constructor(inputList: List<Int>) : this() {
        list = inputList.toMutableList()
    }

    init {
        ints.forEach {
            list.add(it)
        }
    }

    fun isEmpty(): Boolean {
        return list.isEmpty()
    }

    fun isSubset(other: CustomSet): Boolean {
        return list.all {
            other.contains(it)
        }
    }

    fun isDisjoint(other: CustomSet): Boolean {
        return !list.any {
            other.list.contains(it)
        }
    }

    fun contains(other: Int): Boolean {
        return list.contains(other)
    }

    fun intersection(other: CustomSet): CustomSet {
        return CustomSet(list.filter {
            other.list.contains(it)
        })
    }

    fun add(other: Int) {
        list.add(other)
    }

    override fun equals(other: Any?): Boolean {
        if (other is CustomSet) {
            return this.isSubset(other) && other.isSubset(this)
        }
        return false
    }

    operator fun plus(other: CustomSet): CustomSet {
        other.list.forEach {
            list.add(it)
        }
        return this
    }

    operator fun minus(other: CustomSet): CustomSet {
        return CustomSet(list.filter {
            !other.list.contains(it)
        })
    }
}
