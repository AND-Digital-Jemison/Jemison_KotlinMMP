package and.jemison.kotlinmmp.shared

class MoodService {

    private val moods = arrayOf(
        Mood("Doing Great!", "#2196F3"),
        Mood("Not So Great!", "#FFEB3B")
    )

    fun getMood(id: Int): Mood {
        return moods[id]
    }

    companion object {
        const val GOOD_MOOD = 0
        const val BAD_MOOD  = 1
    }
}
