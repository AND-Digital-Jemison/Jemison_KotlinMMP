package and.jemison.kotlinmmp


import and.jemison.kotlinmmp.android.MainActivity
import and.jemison.kotlinmmp.android.R
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun showMoodOptions() {
        onView(withText("Doing good")).check(matches(isCompletelyDisplayed()))
        onView(withText("Doing not so good")).check(doesNotExist())
        onView(withId(R.id.view_pager)).perform(swipeLeft())
        onView(withText("Doing not so good")).check(matches(isCompletelyDisplayed()))
        onView(withText("Doing good")).check(doesNotExist())
    }
}