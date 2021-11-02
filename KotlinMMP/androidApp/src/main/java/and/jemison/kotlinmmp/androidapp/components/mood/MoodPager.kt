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
import com.google.accompanist.pager.rememberPagerState

@ExperimentalPagerApi
@Composable
fun MoodPager(moodService: MoodService, onMoodChange: (String) -> Unit) {
    val pagerState = rememberPagerState()
    HorizontalPager(
        count = moodService.getMoodCount(),
        modifier = Modifier.height(350.dp),
        state = pagerState
    ) { page ->
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            MoodSwipeOption(page)
            onMoodChange(moodService.getMood(pagerState.currentPage).moodValue)
        }
    }
}