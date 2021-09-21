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
import com.amplifyframework.AmplifyException
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.AWSDataStorePlugin
import com.amplifyframework.api.aws.AWSApiPlugin
import com.amplifyframework.datastore.generated.model.TASK
import android.util.Log
import com.google.android.play.core.tasks.Tasks


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configureAmplify()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val btnAddTodo = findViewById<Button>(R.id.btnAddTodo)
        val taskText = findViewById<EditText>(R.id.taskText)

        Amplify.DataStore.query(TASK::class.java,
            { tasks ->
                val list: MutableList<String> = ArrayList()

                while (tasks.hasNext()) {
                    val task = tasks.next()
                    list.add(task.name)
                    Log.i("MyAmplifyApp", "Title: ${task.name}")
                }
                val adapter = CustomAdapter(list)
                recyclerView.adapter = adapter
            },
            { Log.e("MyAmplifyApp", "Query failed", it) }
        )

        btnAddTodo.setOnClickListener {
            val todoTitle = taskText.text.toString()
            if(todoTitle.isNotEmpty()) {
                val task = TASK.builder()
                    .name(todoTitle)
                    .build()
                Amplify.DataStore.save(task,
                    { Log.i("MyAmplifyApp", "Saved a post") },
                    { Log.e("MyAmplifyApp", "Save failed", it) }
                )

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

    private fun configureAmplify() {
        try {
            Amplify.addPlugin(AWSApiPlugin())
            Amplify.addPlugin(AWSDataStorePlugin())
            Amplify.configure(applicationContext)
            Log.i("Amplify", "Initialized Amplify")
        } catch (e: AmplifyException) {
            Log.e("Amplify", "Could not initialize Amplify", e)
        }
    }
}
