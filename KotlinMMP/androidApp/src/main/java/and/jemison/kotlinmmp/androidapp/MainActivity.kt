package and.jemison.kotlinmmp.androidapp

import and.jemison.kotlinmmp.androidapp.components.mood.MoodPager
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
import com.amplifyframework.AmplifyException
import com.amplifyframework.api.aws.AWSApiPlugin
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.AWSDataStorePlugin
import com.amplifyframework.datastore.generated.model.Mood
import android.util.Log
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

        configureAmplify()

        setContent {
            Image(
                painter = painterResource(R.drawable.mobile_background_grad_6_428x926),
                contentDescription = "Purple Background",
                contentScale = ContentScale.FillBounds,
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(20.dp)
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
                MoodPager()
                Spacer(modifier = Modifier.padding(top = 20.dp))
                Button(onClick = {
                    System.out.println("Button clicked: " )
                }, modifier = Modifier.fillMaxWidth()) {
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

    private fun configureAmplify() {
        try {
            Amplify.addPlugin(AWSApiPlugin())
            Amplify.addPlugin(AWSDataStorePlugin())
            Amplify.configure(applicationContext)
            Log.i("Amplify", "Initialized Amplify")
        } catch (e: AmplifyException) {
            Log.e("Amplify", "Could not initialize Amplify", e)
        }
    }
}
