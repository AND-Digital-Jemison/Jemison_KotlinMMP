package and.jemison.kotlinmmp.android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import utils.EspressoIdlingResource

class MoodOptionFragment(private val text: String, private val colour: Int) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.mood_option, container, false)
        setMoodOption(view)
        EspressoIdlingResource.increment()
        return view
    }

    override fun onResume() {
        super.onResume()
        EspressoIdlingResource.decrement()
    }

    private fun setMoodOption(view: View) {
        val moodOption: TextView? = view.findViewById(R.id.moodOption)
        moodOption?.text = this.text
        moodOption?.setBackgroundColor(colour)
    }
}