import java.time.DayOfWeek
import java.time.LocalDate

class Meetup(val month: Int, val year: Int) {
    init {
        require(month in 1..12)
    }

    fun day(dayOfWeek: DayOfWeek, schedule: MeetupSchedule): LocalDate{
        val firstDayOfWeek = calculateFirstDayOfWeek(
            LocalDate.of(year, month, 1).dayOfWeek.value,
            dayOfWeek.value)

        return when (schedule) {
            MeetupSchedule.FIRST -> firstDayOfWeek
            MeetupSchedule.SECOND -> firstDayOfWeek.plusWeeks(1)
            MeetupSchedule.THIRD -> firstDayOfWeek.plusWeeks(2)
            MeetupSchedule.FOURTH -> firstDayOfWeek.plusWeeks(3)
            MeetupSchedule.LAST -> firstDayOfWeek.lastOfMonth()
            MeetupSchedule.TEENTH -> firstDayOfWeek.teenth()
        }
    }

    private fun calculateFirstDayOfWeek(start: Int, end: Int): LocalDate {
        var diff = end - start
        if (diff < 0) {
            diff += 7
        }
        return LocalDate.of(year, month, diff + 1)
    }

    private fun LocalDate.teenth(): LocalDate {
        var date = this.plusWeeks(1)
        if (date.dayOfMonth !in 13..19) {
            return date.plusWeeks(1)
        }
        return date
    }

    private fun LocalDate.lastOfMonth(): LocalDate {
        var date = this.plusWeeks(3)
        while (date.dayOfMonth + 7 <= date.month.length(date.isLeapYear)) {
            date = date.plusWeeks(1)
        }
        return date
    }
}
