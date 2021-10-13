package and.jemison.kotlinmmp.androidapp

import and.jemison.kotlinmmp.androidapp.testutils.ViewPager2IdlingResource
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.action.ViewActions.swipeRight
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    private lateinit var viewPager2IdlingResource: ViewPager2IdlingResource

    @Before
    fun setUp() {
        activityRule.scenario.onActivity {
            viewPager2IdlingResource =
                ViewPager2IdlingResource(
                    it.findViewById(R.id.mood_options_view_pager),
                    "viewPagerIdlingResource"
                )
            IdlingRegistry.getInstance().register(viewPager2IdlingResource)
        }
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(viewPager2IdlingResource)
    }

    @Test
    fun showMoodOptions() {
        checkGoodMoodDisplayed()

        onView(withId(R.id.mood_options_view_pager)).perform(swipeLeft())

        checkBadMoodDisplayed()

        onView(withId(R.id.mood_options_view_pager)).perform(swipeRight())

        checkGoodMoodDisplayed()
    }

    private fun checkGoodMoodDisplayed() {
        onView(withText(GOOD_MOOD_TEXT)).check(matches(isCompletelyDisplayed()))
        onView(withText(BAD_MOOD_TEXT)).check(doesNotExist())
    }

    private fun checkBadMoodDisplayed() {
        onView(withText(BAD_MOOD_TEXT)).check(matches(isCompletelyDisplayed()))
        onView(withText(GOOD_MOOD_TEXT)).check(doesNotExist())
    }

    companion object {
        private const val GOOD_MOOD_TEXT = "Doing Great"
        private const val BAD_MOOD_TEXT = "Not So Great"
    }
}