package and.jemison.kotlinmmp.androidapp

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun defaultMoodRenders() {
        composeTestRule.onNodeWithText(GOOD_MOOD_TEXT).assertIsDisplayed()
        composeTestRule.onNodeWithText(BAD_MOOD_TEXT).assertIsNotDisplayed()
    }

    @Test
    fun swipeBetweenMoods() {
        val goodMood = composeTestRule.onNodeWithText(GOOD_MOOD_TEXT)
        val badMood = composeTestRule.onNodeWithText(BAD_MOOD_TEXT)

        goodMood.performGesture { swipeLeft() }

        badMood.assertIsDisplayed()
        goodMood.assertIsNotDisplayed()

        badMood.performGesture { swipeRight() }

        goodMood.assertIsDisplayed()
        badMood.assertIsNotDisplayed()
    }

    companion object {
        private const val GOOD_MOOD_TEXT = "Doing Great!"
        private const val BAD_MOOD_TEXT = "Not So Great"
    }
}