package com.paulinasadowska.todoappcompose

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paulinasadowska.todoappcompose.tasks.ui.TaskItem
import com.paulinasadowska.todoappcompose.ui.theme.TodoAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoAppComposeTheme {
                Surface(
                        color = MaterialTheme.colors.background,
                        modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                ) {
                    LazyColumn(
                            modifier = Modifier.padding(8.dp)
                    ) {
                        items(listOf("Lorem", "Ipsum", "Dolorem", "...")) { element ->
                            TaskItem(modifier = Modifier.padding(8.dp), task = element)
                        }
                    }
                }
            }
        }
    }
}

@Preview(widthDp = 300)
@Preview(
        name = "Dark theme Preview",
        widthDp = 300,
        uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun DefaultPreview() {
    TodoAppComposeTheme {
        LazyColumn {
            items(listOf("Lorem", "Ipsum", "Dolorem", "...")) { element ->
                TaskItem(modifier = Modifier.padding(8.dp), task = element)
            }
        }
    }
}