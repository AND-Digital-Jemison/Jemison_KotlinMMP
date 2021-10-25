package and.jemison.kotlinmmp.androidapp

import and.jemison.kotlinmmp.androidapp.components.mood.MoodHeader
import and.jemison.kotlinmmp.androidapp.components.mood.MoodPager
import and.jemison.kotlinmmp.androidapp.components.mood.MoodSubmit
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
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

        setContent {
            Image(
                painter = painterResource(R.drawable.background),
                contentDescription = "Purple Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
            ) {
                MoodHeader()
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxHeight()
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Spacer(modifier = Modifier.padding(top = 50.dp))
                    MoodPager()
                }
            }
            Row(
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier.fillMaxHeight()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(20.dp)
                ) {
                    MoodSubmit()
                }
            }
        }
    }
}