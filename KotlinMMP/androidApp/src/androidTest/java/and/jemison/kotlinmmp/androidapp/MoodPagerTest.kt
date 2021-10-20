package and.jemison.kotlinmmp.androidapp

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.google.accompanist.pager.ExperimentalPagerApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MoodPagerTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @ExperimentalPagerApi
    @Before
    fun setUp() {
        val testMoodOptions: List<MoodOption> = listOf(
            MoodOption(R.drawable.undraw_maker_launch_crhe_v3_up, R.string.doingGreat),
            MoodOption(R.drawable.undraw_maker_launch_crhe_v3_down, R.string.notSoGreat),
        )

        composeTestRule.setContent {
            MoodPager(testMoodOptions).createPager()
        }
    }

    @Test
    fun defaultMoodRenders() {
        composeTestRule.onNodeWithText(GOOD_MOOD_TEXT).assertIsDisplayed()
        composeTestRule.onNodeWithText(BAD_MOOD_TEXT).assertIsNotDisplayed()
    }

    @Test
    fun swipeTextBetweenMoods() {
        val goodMoodText = composeTestRule.onNodeWithText(GOOD_MOOD_TEXT)
        val badMoodText = composeTestRule.onNodeWithText(BAD_MOOD_TEXT)

        testSwipe(goodMoodText, badMoodText)
    }

    @Test
    fun swipeImageBetweenMoods() {
        val goodMoodImage = composeTestRule.onAllNodesWithContentDescription(GOOD_MOOD_TEXT)[0]
        val badMoodImage = composeTestRule.onAllNodesWithContentDescription(BAD_MOOD_TEXT)[0]

        testSwipe(goodMoodImage, badMoodImage)
    }

    private fun testSwipe(
        initialNode: SemanticsNodeInteraction,
        nextNode: SemanticsNodeInteraction
    ) {
        initialNode.performGesture { swipeLeft() }

        nextNode.assertIsDisplayed()
        initialNode.assertIsNotDisplayed()

        nextNode.performGesture { swipeRight() }

        initialNode.assertIsDisplayed()
        nextNode.assertIsNotDisplayed()
    }

    companion object {
        private const val GOOD_MOOD_TEXT = "Doing Great!"
        private const val BAD_MOOD_TEXT = "Not So Great"
    }
}
