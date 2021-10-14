package and.jemison.kotlinmmp.androidapp

import and.jemison.kotlinmmp.androidapp.R.*
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources.getDrawable

class MoodOptionFragment(private val text: String, private val moodValue: Int) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(layout.mood_option, container, false)
        setMoodOption(view)

        return view
    }

    @SuppressLint("ResourceType")
    private fun setMoodOption(view: View) {
        val moodOption: TextView? = view.findViewById(R.id.moodOption)
        moodOption?.text = this.text

        val moodImageView: ImageView? = view.findViewById(R.id.moodimage)
        val drawable = context?.let { getDrawable(it, moodValue) }
        moodImageView?.setImageDrawable(drawable)
    }

}








