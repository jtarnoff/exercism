import kotlin.experimental.and

class Allergies(private val score: Int) {
    fun getList(): List<Allergen> { return Allergen.values().asList().filter(::isAllergicTo) }
    fun isAllergicTo(allergen: Allergen): Boolean { return (score.toByte() and allergen.score.toByte()) == allergen.score.toByte() }
}
