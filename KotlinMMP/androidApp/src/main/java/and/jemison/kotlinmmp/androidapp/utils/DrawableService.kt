package and.jemison.kotlinmmp.androidapp.utils

import and.jemison.kotlinmmp.androidapp.R

class DrawableService {
    private val drawables = mapOf(
        "rocket-up" to R.drawable.rocket_up,
        "rocket-down" to R.drawable.rocket_down
    )

    fun convertImageToDrawable(image: String): Int? {
        return drawables[image]
    }
}