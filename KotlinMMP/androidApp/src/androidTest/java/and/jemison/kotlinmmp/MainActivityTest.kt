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

import and.jemison.kotlinmmp.android.util.EspressoIdlingResource
import android.view.View
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import org.hamcrest.Matcher

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
        onView(withText("Doing good")).check(matches(isCompletelyDisplayed()))
        onView(withText("Doing not so good")).check(doesNotExist())
        onView(withId(R.id.view_pager)).perform(swipeLeft())
        Thread.sleep(200)
        onView(withText("Doing not so good")).check(matches(isCompletelyDisplayed()))
        onView(withText("Doing good")).check(doesNotExist())
    }
}