package and.jemison.kotlinmmp.androidapp.components.moodpager

import and.jemison.kotlinmmp.androidapp.moodTypography
import and.jemison.kotlinmmp.androidapp.utils.DrawableService
import and.jemison.kotlinmmp.shared.Mood
import and.jemison.kotlinmmp.shared.MoodService
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager

class MoodPager() {
    private val moodService = MoodService()

    @ExperimentalPagerApi
    @Composable
    fun createPager() {
        HorizontalPager(
            count = moodService.getMoodCount(),
            modifier = Modifier.height(PAGER_HEIGHT)
        ) { page ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                moodSwipeOption(page)
            }
        }
    }

    @Composable
    private fun moodSwipeOption(moodId: Int) {
        val mood = moodService.getMood(moodId)
        Image(
            painter = painterResource(DrawableService().convertImageToDrawable(mood.image)!!),
            contentDescription = mood.contentDescription,
            modifier = Modifier
                .height(MOOD_IMAGE_HEIGHT)
                .testTag("mood$moodId-image")
        )
        Text(
            text = mood.text,
            style = moodTypography.h2,
        )
    }

    companion object {
        val PAGER_HEIGHT = 350.dp
        val MOOD_IMAGE_HEIGHT = 275.dp
    }
}


