package and.jemison.kotlinmmp.androidapp.components.mood

import and.jemison.kotlinmmp.androidapp.moodTypography
import and.jemison.kotlinmmp.androidapp.utils.DrawableService
import and.jemison.kotlinmmp.shared.MoodService
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun MoodSwipeOption(moodId: Int) {
    val mood = MoodService().getMood(moodId)
    Image(
        painter = painterResource(DrawableService().convertImageToDrawable(mood.image)!!),
        contentDescription = mood.contentDescription,
        modifier = Modifier
            .height(250.dp)
            .testTag("mood$moodId-image")
    )
    Text(
        text = mood.text,
        style = moodTypography.h2,
        modifier = Modifier.testTag("mood$moodId-text")
    )
}