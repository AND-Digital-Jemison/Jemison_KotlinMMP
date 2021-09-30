package and.jemison.kotlinmmp.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import and.jemison.kotlinmmp.Greeting
import android.widget.TextView
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (BuildConfig.APP_CENTER_KEY_LOCAL != "noLocalKey") {
            val appCenterKey = BuildConfig.APP_CENTER_KEY_LOCAL

            AppCenter.start(
                application, appCenterKey,
                Analytics::class.java, Crashes::class.java
            )
        }

        findViewById<TextView>(R.id.greetingsTextBox)?.setText(Greeting().greeting())
    }
}
