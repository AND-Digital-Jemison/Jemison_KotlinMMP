package and.jemison.kotlinmmp.android
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val mList: List<String>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //inflates card view desing that holds list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)
        return ViewHolder(view)
    }

    //binds list items to a view

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val task = mList[position]
        // Set item views based on your views and data model
        holder.textView.text = task
    }

    //returns number of items in list

    override fun getItemCount(): Int {
        return mList.size
    }

    //holds views for adding it to text

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)
    }

}