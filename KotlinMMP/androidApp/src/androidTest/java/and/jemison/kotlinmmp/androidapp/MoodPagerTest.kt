package and.jemison.kotlinmmp.androidapp

import and.jemison.kotlinmmp.androidapp.components.moodpager.MoodPager
import and.jemison.kotlinmmp.androidapp.components.moodpager.dataclasses.MoodImageMetadata
import and.jemison.kotlinmmp.androidapp.components.moodpager.dataclasses.MoodOption
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
            MoodOption(
                R.string.doingGreat,
                MoodImageMetadata(
                    R.drawable.undraw_maker_launch_crhe_v3_up,
                    ROCKET_UP_TEST_TAG,
                    "Rocket flying up"
                )
            ),
            MoodOption(
                R.string.notSoGreat,
                MoodImageMetadata(
                    R.drawable.undraw_maker_launch_crhe_v3_down,
                    ROCKET_DOWN_TEST_TAG,
                    "Rocket crashing down"
                )
            )
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

        private const val ROCKET_UP_TEST_TAG = "rocketUp"
        private const val ROCKET_DOWN_TEST_TAG = "rocketDown"
    }
}
