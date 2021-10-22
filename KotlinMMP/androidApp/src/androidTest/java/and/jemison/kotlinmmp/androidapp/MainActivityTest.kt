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
    fun pageRenders() {
        composeTestRule.onNodeWithText(HOW_ARE_YOU_TEXT).assertIsDisplayed()
        composeTestRule.onNodeWithText(SWIPE_HELP_TEXT).assertIsDisplayed()
//
//        val defaultMoodText = composeTestRule.onNodeWithText(GOOD_MOOD_TEXT)
//        defaultMoodText.assertIsDisplayed()
//        composeTestRule.onNodeWithText(BAD_MOOD_TEXT).assertIsNotDisplayed()
//
//        composeTestRule.onNodeWithText(SUBMIT_TEXT).assertIsDisplayed()
//        composeTestRule.onNodeWithText(DISCLAIMER_TEXT).assertIsDisplayed()
    }
//
    companion object {
        private const val HOW_ARE_YOU_TEXT = "How are you feeling today?"
        private const val SWIPE_HELP_TEXT = "(Swipe to change mood)"
//        private const val SUBMIT_TEXT = "Submit"
//        private const val DISCLAIMER_TEXT = "This is completely anonymous."
//        private const val GOOD_MOOD_TEXT = "Doing Great!"
//        private const val BAD_MOOD_TEXT = "Not So Great"
    }
}