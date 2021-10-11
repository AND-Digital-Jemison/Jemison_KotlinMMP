package and.jemison.kotlinmmp

import ViewPager2IdlingResource
import and.jemison.kotlinmmp.android.MainActivity
import and.jemison.kotlinmmp.android.R
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
                ViewPager2IdlingResource(it.findViewById(R.id.mood_options_view_pager), "viewPagerIdlingResource")
            IdlingRegistry.getInstance().register(viewPager2IdlingResource)
        }
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(viewPager2IdlingResource)
    }

    @Test
    fun showMoodOptions() {
        onView(withText("Not So Great!")).check(matches(isCompletelyDisplayed()))
        onView(withText("Doing Great!")).check(doesNotExist())

        onView(withId(R.id.mood_options_view_pager)).perform(swipeLeft())

        onView(withText("Doing Great!")).check(matches(isCompletelyDisplayed()))
        onView(withText("Not So Great!")).check(doesNotExist())

        onView(withId(R.id.mood_options_view_pager)).perform(swipeRight())

        onView(withText("Not So Great!")).check(matches(isCompletelyDisplayed()))
        onView(withText("Doing Great!")).check(doesNotExist())
    }
}