package and.jemison.kotlinmmp.androidapp.components.mood

import and.jemison.kotlinmmp.androidapp.backend.AmplifyQueries
import and.jemison.kotlinmmp.shared.MoodService
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun MoodScreen(amplify: AmplifyQueries) {
    val moodService = MoodService()

    var mood by remember { mutableStateOf(moodService.getMood(0).moodValue) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(modifier = Modifier.padding(20.dp)) {
            MoodHeader()
        }
        MoodPager(moodService, onMoodChange = { mood = it})
        Box(modifier = Modifier.padding(20.dp)) {
            MoodSubmit(amplify, mood)
        }
    }
}