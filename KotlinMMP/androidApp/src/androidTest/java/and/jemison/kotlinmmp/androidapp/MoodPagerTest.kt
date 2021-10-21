package and.jemison.kotlinmmp.androidapp

import and.jemison.kotlinmmp.androidapp.components.mood.MoodPager
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
        composeTestRule.setContent {
            MoodPager()
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
        val goodMoodImage =  composeTestRule.onNodeWithTag(ROCKET_UP_TEST_TAG)

        val badMoodText = composeTestRule.onNodeWithText(BAD_MOOD_TEXT)
        val badMoodImage = composeTestRule.onNodeWithTag(ROCKET_DOWN_TEST_TAG)

        goodMoodText.performGesture { swipeLeft() }

        badMoodText.assertIsDisplayed()
        badMoodImage.assertIsDisplayed()
        goodMoodText.assertIsNotDisplayed()
        goodMoodImage.assertIsNotDisplayed()

        badMoodText.performGesture { swipeRight() }

        goodMoodText.assertIsDisplayed()
        goodMoodImage.assertIsDisplayed()
        badMoodText.assertIsNotDisplayed()
        badMoodImage.assertIsNotDisplayed()
    }

    companion object {
        private const val GOOD_MOOD_TEXT = "Doing Great!"
        private const val BAD_MOOD_TEXT = "Not So Great"

        private const val ROCKET_UP_TEST_TAG = "mood0-image"
        private const val ROCKET_DOWN_TEST_TAG = "mood1-image"
    }
}
