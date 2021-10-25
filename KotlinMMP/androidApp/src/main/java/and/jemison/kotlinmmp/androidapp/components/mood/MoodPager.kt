package and.jemison.kotlinmmp.androidapp.components.mood

import and.jemison.kotlinmmp.shared.MoodService
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager

@ExperimentalPagerApi
@Composable
fun MoodPager() {
    val moodService = MoodService()
    HorizontalPager(
        count = moodService.getMoodCount(),
        modifier = Modifier.height(375.dp)
    ) { page ->
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            MoodSwipeOption(page)
        }
    }
}