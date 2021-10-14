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
import android.graphics.Bitmap

import android.graphics.drawable.Drawable
//import jdk.tools.jlink.internal.ImageFileCreator.resourceName
import and.jemison.kotlinmmp.androidapp.testutils.DrawableMatcher
import android.view.View
import org.hamcrest.Matcher


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
        onView(withText("Doing Great!")).check(matches(isCompletelyDisplayed()))

        onView(withId(R.id.moodimage)).check(matches(withDrawable(R.drawable.moodhappy)))

        onView(withId(R.id.mood_options_view_pager)).perform(swipeLeft())

        onView(withText("Not So Great!")).check(matches(isCompletelyDisplayed()))

        onView(withId(R.id.moodimage)).check(matches(withDrawable(R.drawable.moodnothappy)))

        onView(withId(R.id.mood_options_view_pager)).perform(swipeRight())

        onView(withText("Doing Great!")).check(matches(isCompletelyDisplayed()))

        onView(withId(R.id.moodimage)).check(matches(withDrawable(R.drawable.moodhappy)))

    }

    private fun withDrawable(resourceId: Int): Matcher<View?> {
        return DrawableMatcher(resourceId)
    }

    fun noDrawable(): Matcher<View?> {
        return DrawableMatcher(-1)
    }


}