package and.jemison.kotlinmmp.androidapp

import and.jemison.kotlinmmp.androidapp.databinding.MoodOptionBinding
import and.jemison.kotlinmmp.shared.Mood
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MoodOptionFragment(private val mood: Mood) : Fragment() {

    private var _binding: MoodOptionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MoodOptionBinding.inflate(inflater, container, false)
        binding.mood = mood
        return binding.root
    }
}