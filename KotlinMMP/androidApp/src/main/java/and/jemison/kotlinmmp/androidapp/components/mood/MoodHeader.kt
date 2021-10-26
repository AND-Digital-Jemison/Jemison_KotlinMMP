package and.jemison.kotlinmmp.androidapp.components.mood

import and.jemison.kotlinmmp.androidapp.R
import and.jemison.kotlinmmp.androidapp.moodTypography
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign

@Composable
fun MoodHeader() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
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
    }
}