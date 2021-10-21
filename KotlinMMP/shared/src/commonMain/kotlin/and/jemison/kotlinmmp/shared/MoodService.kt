package and.jemison.kotlinmmp.shared

class MoodService {

    private val moods = arrayOf(
        Mood("Doing Great!", "#FFFFFF", "rocket-up", "Rocket flying up"),
        Mood("Not So Great", "#FFFFFF", "rocket-down", "Rocket crashing down")
    )

    fun getMood(id: Int): Mood {
        return moods[id]
    }

    fun getMoodCount(): Int {
        return moods.size
    }

    companion object {
        const val GOOD_MOOD = 0
        const val BAD_MOOD  = 1
    }
}
