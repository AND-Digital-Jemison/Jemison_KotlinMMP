package and.jemison.kotlinmmp.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configureAmplify()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)

        val btnAddTodo = findViewById<Button>(R.id.btnAddTodo)
        val taskText = findViewById<EditText>(R.id.taskText)

        val list: MutableList<String> = ArrayList()

        val adapter = CustomAdapter(list)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        Amplify.DataStore.query(TASK::class.java,
            { tasks ->
                while (tasks.hasNext()) {
                    val task = tasks.next()
                    list.add(0, task.name)
                    adapter.notifyItemInserted(0)
                    Log.i("MyAmplifyApp", "Task Name: ${task.name}")
                }

            },
            { Log.e("MyAmplifyApp", "Query failed", it) }
        )

        btnAddTodo.setOnClickListener {
            val todoTitle = taskText.text.toString()
            if(todoTitle.isNotEmpty()) {
                list.add(0, todoTitle)

                val task = TASK.builder()
                    .name(todoTitle)
                    .build()
                Amplify.DataStore.save(task,
                    { Log.i("MyAmplifyApp", "Saved a post") },
                    { Log.e("MyAmplifyApp", "Save failed", it) }
                )

                adapter.notifyItemInserted(0)
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
