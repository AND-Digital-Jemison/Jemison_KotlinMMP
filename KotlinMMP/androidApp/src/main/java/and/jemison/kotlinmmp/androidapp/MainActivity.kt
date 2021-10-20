package and.jemison.kotlinmmp.androidapp

import and.jemison.kotlinmmp.androidapp.components.moodpager.MoodPager
import and.jemison.kotlinmmp.androidapp.components.moodpager.dataclasses.MoodImageMetadata
import and.jemison.kotlinmmp.androidapp.components.moodpager.dataclasses.MoodOption
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
                painter = painterResource(R.drawable.mobile_background_grad_6_428x926),
                contentDescription = "Mood Background",
                contentScale = ContentScale.FillBounds
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(40.dp)
            ) {
                Text(
                    text = stringResource(R.string.howAreYou),
                    style = moodTypography.h1,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = stringResource(R.string.swipeHelp),
                    style = moodTypography.body1,
                )
                MoodPager(listOf(
                    MoodOption(
                        R.string.doingGreat,
                        MoodImageMetadata(
                            R.drawable.undraw_maker_launch_crhe_v3_up,
                            "rocketUp",
                            "Rocket flying up"
                        )
                    ),
                    MoodOption(
                        R.string.notSoGreat,
                        MoodImageMetadata(
                            R.drawable.undraw_maker_launch_crhe_v3_down,
                            "rocketDown",
                            "Rocket crashing down"
                        )
                    )
                )).createPager()
                Spacer(modifier = Modifier.padding(top = 10.dp))
                Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = stringResource(R.string.submitButton),
                        style = moodTypography.body1
                    )
                }
                Spacer(modifier = Modifier.padding(top = 10.dp))
                Text(
                    text = stringResource(R.string.submitDisclaimer),
                    style = moodTypography.body1,
                )
            }
        }
    }
}
