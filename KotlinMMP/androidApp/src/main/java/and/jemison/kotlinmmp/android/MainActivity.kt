package and.jemison.kotlinmmp.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val moodOptionsPage: ViewPager2 = findViewById(R.id.mood_options_view_pager)

        val moodOptionFragments: ArrayList<Fragment> = arrayListOf(
            MoodOptionFragment("Not So Great!", ContextCompat.getColor(applicationContext, R.color.red)),
            MoodOptionFragment("Doing Great!", ContextCompat.getColor(applicationContext, R.color.yellow))
        )

        val adapter = MoodOptionsAdapter(moodOptionFragments, this)
        moodOptionsPage.adapter = adapter

        if (BuildConfig.APP_CENTER_KEY_LOCAL != "noLocalKey") {
            val appCenterKey = BuildConfig.APP_CENTER_KEY_LOCAL

            AppCenter.start(
                application, appCenterKey,
                Analytics::class.java, Crashes::class.java
            )
        }
    }
}
