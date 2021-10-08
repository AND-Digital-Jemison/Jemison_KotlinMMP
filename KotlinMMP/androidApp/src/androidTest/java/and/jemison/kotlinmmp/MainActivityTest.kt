package and.jemison.kotlinmmp


import and.jemison.kotlinmmp.android.MainActivity
import and.jemison.kotlinmmp.android.R
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Before
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import utils.EspressoIdlingResource
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist

//import android.R


@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun registerIdlingResource(){
        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource)
    }

    @After
    fun unregisterIdlingResource(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.countingIdlingResource)
    }

    @Test
    fun showMoodOptions() {
        onView(withText("Not So Great!")).check(matches(isCompletelyDisplayed()))
        onView(withText("Doing Great!")).check(doesNotExist())
        onView(withId(R.id.view_pager)).perform(swipeLeft())
        onView(withText("Doing Great!")).check(matches(isCompletelyDisplayed()))
        onView(withText("Not So Great!")).check(doesNotExist())
    }
}