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

        val defaultMoodText = composeTestRule.onNodeWithTag(GOOD_MOOD_TEST_TAG)
        defaultMoodText.assertIsDisplayed()
        composeTestRule.onNodeWithTag(BAD_MOOD_TEST_TAG).assertIsNotDisplayed()

        composeTestRule.onNodeWithText(SUBMIT_TEXT).assertIsDisplayed()
        composeTestRule.onNodeWithText(DISCLAIMER_TEXT).assertIsDisplayed()
    }

    @Test
    fun onSubmitSnackbarDisplay() {
        val submitButton = composeTestRule.onNodeWithTag(MOOD_SUBMIT_TEST_TAG)
        submitButton.assertIsDisplayed()
        submitButton.performClick()
        val snackbar = composeTestRule.onNodeWithTag(SNACKBAR)
        snackbar.assertIsDisplayed()
    }
    
    companion object {
        private const val HOW_ARE_YOU_TEXT = "How are you feeling today?"
        private const val SWIPE_HELP_TEXT = "(Swipe to change mood)"
        private const val GOOD_MOOD_TEST_TAG = "mood0-text"
        private const val BAD_MOOD_TEST_TAG = "mood1-text"
        private const val SUBMIT_TEXT = "Submit"
        private const val DISCLAIMER_TEXT = "This is completely anonymous."
        private const val MOOD_SUBMIT_TEST_TAG = "mood-submit"
        private const val SNACKBAR = "snackbar"
    }
}