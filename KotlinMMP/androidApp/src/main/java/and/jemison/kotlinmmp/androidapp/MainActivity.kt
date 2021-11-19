package and.jemison.kotlinmmp.androidapp

import and.jemison.kotlinmmp.androidapp.backend.AmplifyQueries
import and.jemison.kotlinmmp.androidapp.components.mood.MoodScreen
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.google.accompanist.pager.ExperimentalPagerApi
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes


class MainActivity : AppCompatActivity() {

    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (BuildConfig.APP_CENTER_KEY_LOCAL != "noLocalKey") {
            val appCenterKey = BuildConfig.APP_CENTER_KEY_LOCAL

            AppCenter.start(
                application, appCenterKey,
                Analytics::class.java, Crashes::class.java
            )
        }

        val amplify = AmplifyQueries()
        amplify.configureAmplify(applicationContext)

        setContent {
            Image(
                painter = painterResource(R.drawable.purple_background),
                contentDescription = "Purple Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            MoodScreen(amplify)
        }
    }
}