class Scale(private val tonic: String) {

    fun chromatic(): List<String> {
        var retList = mutableListOf<String>()
        var stop = false
        var lastNote = tonic.mapIndexed { index, c -> if (index == 0) c.uppercase() else c }.joinToString("")
        val usesSharps = usesSharps(tonic)
        var index = Note.fromNote(lastNote, usesSharps).index
        retList.add(lastNote)
        while (!stop) {
            val newNote = Note.fromIndex((++index) % 12)
            val newStr = if (usesSharps) newNote.sharp else newNote.flat
            if (newStr != retList[0]) retList.add(newStr) else stop = true
        }
        return retList
    }

    fun interval(intervals: String): List<String> {
        var lastNote = tonic.mapIndexed { index, c -> if (index == 0) c.uppercase() else c }.joinToString("")
        val list = mutableListOf(lastNote)
        val usesSharps = usesSharps(tonic)

        getStepList(intervals).forEach { step ->
            var note = Note.fromNote(lastNote, usesSharps)
            val tempNote = when (step) {
                Step.MINOR -> Note.fromIndex((note.index + 1) % 12)
                Step.MAJOR -> Note.fromIndex((note.index + 2) % 12)
                Step.AUGMENTED -> Note.fromIndex((note.index + 3) % 12)
            }
            lastNote = if (usesSharps) tempNote.sharp else tempNote.flat
            if (lastNote != list[0]) list.add(lastNote.mapIndexed { index, c -> if (index == 0) c.uppercase() else c }.joinToString(""))
        }
        return list
    }

    fun usesSharps(tonic: String): Boolean {
        return tonic in listOf("G", "D", "A", "E", "B", "F#", "e", "b", "f#", "c#", "g#", "d#")
    }

    fun getStepList(intervals: String): List<Step> {
        return intervals.map {
            Step.fromCode(it)
        }
    }

    enum class Step(val code: Char, val value: Int) {
        MINOR(code = 'm', value = 1),
        MAJOR(code = 'M', value = 2),
        AUGMENTED(code = 'A', value = 3);

        companion object {
            fun fromCode(c: Char): Step {
                return Step.values().first { it.code == c }
            }
        }
    }

    enum class Note(val index: Int, val sharp: String, val flat: String, isMajor: Boolean = true) {
        A(0, "A", "A"),
        A_SHARP(1, "A#", "Bb"),
        B(2, "B", "B"),
        C(3, "C", "C"),
        C_SHARP(4, "C#", "Db"),
        D(5, "D", "D"),
        D_SHARP(6, "D#", "Eb"),
        E(7, "E", "E"),
        F(8, "F", "F"),
        F_SHARP(9, "F#", "Gb"),
        G(10, "G", "G"),
        G_SHARP(11, "G#", "Ab");

        companion object {
            fun fromNote(note: String, usesSharps: Boolean): Note {
                return if (usesSharps) {
                    Note.values().first { it.sharp == note }
                } else {
                    Note.values().first { it.flat.equals(note, true) }
                }
            }

            fun fromIndex(index: Int): Note {
                return Note.values().first { it.index == index }
            }

            fun usesSharps(tonic: String): Boolean {
                return tonic in listOf("G", "D", "A", "E", "B", "F#", "e", "b", "f#", "c#", "g#", "d#")
            }
        }
    }
}
