package and.jemison.kotlinmmp.shared

class MoodService {

    private val moods = arrayOf(
        MoodInfo("Doing Great!", "#FFFFFF", "rocket-up", "Rocket flying up"),
        MoodInfo("Not So Great", "#FFFFFF", "rocket-down", "Rocket crashing down")
    )

    fun getMood(id: Int): MoodInfo {
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
