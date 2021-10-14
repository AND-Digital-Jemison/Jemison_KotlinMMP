package and.jemison.kotlinmmp.androidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.BuildConfig
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (BuildConfig.APP_CENTER_KEY_LOCAL != "noLocalKey") {
            val appCenterKey = BuildConfig.APP_CENTER_KEY_LOCAL

            AppCenter.start(
                application, appCenterKey,
                Analytics::class.java, Crashes::class.java
            )
        }

        setContentView(R.layout.activity_main)
        renderMoodOptionsPager()
    }

    private fun renderMoodOptionsPager() {
        val moodOptionsPager: ViewPager2 = findViewById(R.id.mood_options_view_pager)

        val moodOptionFragments: ArrayList<Fragment> = arrayListOf(
            MoodOptionFragment("Doing Great!", R.drawable.moodhappy),
            MoodOptionFragment("Not So Great!", R.drawable.moodnothappy),
        )

        val adapter = MoodOptionsAdapter(moodOptionFragments, this)
        moodOptionsPager.adapter = adapter
    }
}
