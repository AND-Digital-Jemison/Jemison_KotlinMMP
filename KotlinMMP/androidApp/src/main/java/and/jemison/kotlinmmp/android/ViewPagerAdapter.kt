package and.jemison.kotlinmmp.android

import and.jemison.kotlinmmp.android.util.EspressoIdlingResource
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter


class ViewPagerAdapter (
    private val items: ArrayList<Fragment>,
    activity: AppCompatActivity
): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        //EspressoIdlingResource.increment()
        return items.size
    }

    override fun createFragment(position: Int): Fragment {
        return items[position]
    }
}