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
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

@ExperimentalPagerApi
@Composable
fun moodPager(): Int {
    val moodService = MoodService()
    val pagerState = rememberPagerState()

    HorizontalPager(
        count = moodService.getMoodCount(),
        modifier = Modifier.height(350.dp),
        state = pagerState
    ) { page ->
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            MoodSwipeOption(page)
        }
    }
    return pagerState.currentPage
}
