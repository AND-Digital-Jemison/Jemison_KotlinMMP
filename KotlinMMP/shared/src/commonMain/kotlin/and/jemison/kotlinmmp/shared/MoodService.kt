package and.jemison.kotlinmmp.shared

class MoodService {

    val moodName = "GOOD_MOOD"

    private val moods = arrayOf(
        Mood("Doing Great", "#FFFFFF", "rocket-up"),
        Mood("Not So Great", "#FFFFFF", "rocket-down" )
    )

    fun getMood(id: Int): Mood {
        return moods[id]
    }

    companion object {
        const val GOOD_MOOD = 0
        const val BAD_MOOD  = 1
    }
}
