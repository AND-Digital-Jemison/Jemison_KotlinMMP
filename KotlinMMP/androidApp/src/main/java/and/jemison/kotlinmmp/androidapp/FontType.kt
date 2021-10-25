package and.jemison.kotlinmmp.androidapp

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val tahu = FontFamily(
    Font(R.font.tahu, FontWeight.W400)
)

private val poppins = FontFamily(
    Font(R.font.poppins_extra_light, FontWeight.W200),
    Font(R.font.poppins_bold, FontWeight.W600)
)

val moodTypography = Typography(
    h1 = TextStyle(
        fontFamily = poppins,
        fontWeight = FontWeight.Bold,
        fontSize = 38.sp,
        color = Color.White
    ),
    h2 = TextStyle(
        fontFamily = tahu,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        fontSize = 35.sp
    ),
    body1 = TextStyle(
        fontFamily = poppins,
        fontSize = 16.sp,
        color = Color.White
    )
)