import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond() {
    lateinit var date: LocalDateTime

    constructor(_date: LocalDate) : this() {
        date = _date.atStartOfDay().plusSeconds(1000000000)
    }
    constructor(_date: LocalDateTime) : this() {
        date = _date.plusSeconds(1000000000)
    }
}
