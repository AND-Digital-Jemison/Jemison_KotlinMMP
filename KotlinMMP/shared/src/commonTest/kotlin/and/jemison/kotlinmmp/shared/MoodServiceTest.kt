package and.jemison.kotlinmmp.shared

import kotlin.test.Test
import kotlin.test.assertTrue

class MoodServiceTest {

    @Test
    fun getMoodFromId0() {
        val mood = MoodService().getMood(MoodService.GOOD_MOOD)
        assertTrue(mood.text == "Doing Great")
        assertTrue(mood.colour == "#2196F3")
    }

    @Test
    fun getMoodFromId1() {
        val mood = MoodService().getMood(MoodService.BAD_MOOD)
        assertTrue(mood.text == "Not So Great")
        assertTrue(mood.colour == "#FFEB3B")
    }
}