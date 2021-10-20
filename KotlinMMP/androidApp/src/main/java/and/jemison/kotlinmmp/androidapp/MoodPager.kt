package and.jemison.kotlinmmp.androidapp

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

class MoodPager(private val moodOptions: List<MoodOption>) {
    @ExperimentalPagerApi
    @Composable
    fun createPager() {
        HorizontalPager(
            count = moodOptions.size,
            modifier = Modifier.height(PAGER_HEIGHT)
        ) { page ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                MoodSwipeOption(moodOptions[page])
            }
        }
    }

    @Composable
    private fun MoodSwipeOption(moodOption: MoodOption) {
        Image(
            painter = painterResource(moodOption.imageMetadata.imageId),
            contentDescription = moodOption.imageMetadata.contentDescription,
            modifier = Modifier.height(MOOD_IMAGE_HEIGHT).testTag(moodOption.imageMetadata.testId)
        )
        Text(
            text = stringResource(moodOption.moodDescriptionId),
            style = moodTypography.h2,
        )
    }

    companion object {
        val PAGER_HEIGHT = 350.dp
        val MOOD_IMAGE_HEIGHT = 275.dp
    }
}


