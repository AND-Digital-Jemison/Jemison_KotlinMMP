package and.jemison.kotlinmmp.androidapp

import and.jemison.kotlinmmp.androidapp.components.mood.moodPager
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
            moodPager()
        }
    }

    @Test
    fun defaultMoodRenders() {
        composeTestRule.onNodeWithTag(GOOD_MOOD_TEST_TAG).assertIsDisplayed()
        composeTestRule.onNodeWithTag(BAD_MOOD_TEST_TAG).assertIsNotDisplayed()
    }

    @Test
    fun swipeTextBetweenMoods() {
        val goodMoodText = composeTestRule.onNodeWithTag(GOOD_MOOD_TEST_TAG)
        val goodMoodImage =  composeTestRule.onNodeWithTag(ROCKET_UP_TEST_TAG)

        val badMoodText = composeTestRule.onNodeWithTag(BAD_MOOD_TEST_TAG)
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
        private const val GOOD_MOOD_TEST_TAG = "mood0-text"
        private const val BAD_MOOD_TEST_TAG = "mood1-text"

        private const val ROCKET_UP_TEST_TAG = "mood0-image"
        private const val ROCKET_DOWN_TEST_TAG = "mood1-image"
    }
}
