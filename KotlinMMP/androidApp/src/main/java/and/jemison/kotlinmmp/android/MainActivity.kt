package and.jemison.kotlinmmp.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import and.jemison.kotlinmmp.Greeting
import and.jemison.kotlinmmp.InMemoryRepository
import and.jemison.kotlinmmp.TaskList
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val taskListData = TaskList(InMemoryRepository())

        val btnAddTodo = findViewById<Button>(R.id.btnAddTodo)
        val taskText = findViewById<EditText>(R.id.taskText)

        btnAddTodo.setOnClickListener {
            val todoTitle = taskText.text.toString()
            if(todoTitle.isNotEmpty()) {
                taskListData.addTask(todoTitle)
                val adapter = CustomAdapter(taskListData.getAllTasks())
                recyclerView.adapter = adapter
                taskText.text.clear()
            }
        }

        if(BuildConfig.APP_CENTER_KEY_LOCAL != "noLocalKey") {
            val appCenterKey = BuildConfig.APP_CENTER_KEY_LOCAL

            AppCenter.start(
                application, appCenterKey,
                Analytics::class.java, Crashes::class.java
            )
        }
    }
}
