package and.jemison.kotlinmmp.shared

import kotlin.test.Test
import kotlin.test.assertTrue

class MoodInfoServiceTest {

    @Test
    fun getMoodFromId0() {
        val mood = MoodService().getMood(MoodService.GOOD_MOOD)
        assertTrue(mood.text == "Doing Great!")
        assertTrue(mood.textColour == "#FFFFFF")
        assertTrue { mood.image == "rocket-up" }
        assertTrue(mood.contentDescription == "Rocket flying up")
        assertTrue(mood.moodValue == "great")
    }

    @Test
    fun getMoodFromId1() {
        val mood = MoodService().getMood(MoodService.BAD_MOOD)
        assertTrue(mood.text == "Not So Great")
        assertTrue(mood.textColour == "#FFFFFF")
        assertTrue { mood.image == "rocket-down" }
        assertTrue(mood.contentDescription == "Rocket crashing down")
        assertTrue(mood.moodValue == "not-great")
    }
}