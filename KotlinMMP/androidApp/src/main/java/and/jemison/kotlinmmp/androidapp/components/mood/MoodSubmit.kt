package and.jemison.kotlinmmp.androidapp.components.mood

import and.jemison.kotlinmmp.androidapp.R
import and.jemison.kotlinmmp.androidapp.backend.AmplifyQueries
import and.jemison.kotlinmmp.androidapp.moodTypography
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun MoodSubmit(amplify: AmplifyQueries, moodValue: String) {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    var snackBarMessage by remember { mutableStateOf("") }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                coroutineScope.launch {
                    amplify.saveToMood(moodValue, onMessageChange = {snackBarMessage = it});
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(
                            message = snackBarMessage,
                            actionLabel = "Hide",
                            duration = SnackbarDuration.Short

                        )
                    }
                }

             },
            modifier = Modifier.fillMaxWidth().testTag("mood-submit")
        ) {
            Text(
                text = stringResource(R.string.submitButton),
                style = moodTypography.body1
            )
        }
        Spacer(modifier = Modifier.padding(top = 10.dp))
        Text(
            text = stringResource(R.string.submitDisclaimer),
            style = moodTypography.body1,
        )

        SnackbarHost(
            modifier = Modifier.padding(top = 10.dp).testTag("snackbar"),
            hostState = snackbarHostState,
            snackbar = {
                Snackbar(
                    action = {
                        TextButton(onClick = {
                            snackbarHostState.currentSnackbarData?.dismiss()
                        }) {
                            Text(
                                text = "Hide",
                            )
                        }
                    }
                ){
                    Text(snackBarMessage)
                }
            }
        )

    }

}