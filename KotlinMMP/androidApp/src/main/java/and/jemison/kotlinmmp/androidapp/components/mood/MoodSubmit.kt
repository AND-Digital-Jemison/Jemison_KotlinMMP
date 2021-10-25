package and.jemison.kotlinmmp.androidapp.components.mood

import and.jemison.kotlinmmp.androidapp.R
import and.jemison.kotlinmmp.androidapp.moodTypography
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun MoodSubmit() {
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