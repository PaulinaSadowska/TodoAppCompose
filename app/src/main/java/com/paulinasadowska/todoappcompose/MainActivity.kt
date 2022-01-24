package com.paulinasadowska.todoappcompose

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.paulinasadowska.todoappcompose.ui.theme.TodoAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoAppComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Preview(
        name = "Dark theme Preview",
        showBackground = true,
        uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun DefaultPreview() {
    TodoAppComposeTheme {
        Surface(color = MaterialTheme.colors.background) {
            Greeting("Android")
        }
    }
}