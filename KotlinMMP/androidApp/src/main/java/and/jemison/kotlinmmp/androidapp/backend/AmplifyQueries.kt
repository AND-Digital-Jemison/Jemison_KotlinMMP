package and.jemison.kotlinmmp.androidapp.backend

import android.content.Context
import android.util.Log
import com.amplifyframework.AmplifyException
import com.amplifyframework.api.aws.AWSApiPlugin
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.AWSDataStorePlugin
import com.amplifyframework.datastore.generated.model.Mood

class AmplifyQueries {
    fun configureAmplify(applicationContext: Context) {
        try {
            Amplify.addPlugin(AWSApiPlugin())
            Amplify.addPlugin(AWSDataStorePlugin())
            Amplify.configure(applicationContext)
            Log.i("Amplify", "Initialized Amplify")
        } catch (e: AmplifyException) {
            Log.e("Amplify", "Could not initialize Amplify", e)
        }
    }

    fun saveToMood(moodText: String, onMessageChange: (String) -> Unit ) {
        val mood = Mood.builder()
            .text(moodText)
            .build()

        Amplify.DataStore.save(mood,
            {
                onMessageChange("Mood Submitted!")
                Log.i("MyAmplifyApp", "Saved a mood")
            },
            {
                onMessageChange("Failed to submit mood")
                Log.e("MyAmplifyApp", "Save failed", it)
            }
        )
    }
}