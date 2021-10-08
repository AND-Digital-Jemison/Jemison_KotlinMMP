package and.jemison.kotlinmmp.android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MoodOption(private val text: String, private val color: String) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.mood_option, container, false)
        val textView: TextView? = view?.findViewById(R.id.notGreat)
        textView?.setText(this.text)
        return view
    }
}