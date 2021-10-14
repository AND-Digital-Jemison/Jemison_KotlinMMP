package and.jemison.kotlinmmp.androidapp

import and.jemison.kotlinmmp.androidapp.databinding.MoodOptionBinding
import and.jemison.kotlinmmp.shared.Mood
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

class MoodOptionFragment(private val mood: Mood, private val moodValue: Int) : Fragment() {


    private var _binding: MoodOptionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MoodOptionBinding.inflate(inflater, container, false)
        binding.mood = mood
        setMoodOption(binding.root)
        return binding.root
    }

    @SuppressLint("ResourceType")
    private fun setMoodOption(view: View) {
        val moodImageView: ImageView? = view.findViewById(R.id.moodimage)
        val drawable = context?.let { getDrawable(it, moodValue) }
        moodImageView?.setImageDrawable(drawable)
    }
}