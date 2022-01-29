package com.paulinasadowska.todoappcompose

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paulinasadowska.todoappcompose.tasks.ui.TaskItem
import com.paulinasadowska.todoappcompose.tasks.ui.filters.Filter
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
                    TodoListScreen()
                }
            }
        }
    }
}

@Composable
fun TodoListScreen() {
    Column(
            modifier = Modifier
                    .padding(top = 8.dp)
                    .padding(8.dp)
    ) {
        Row(
                modifier = Modifier
                        .horizontalScroll(rememberScrollState())
                        .padding(bottom = 4.dp)
        ) {
            listOf("All", "Personal", "Work", "Shopping list", "Other").forEachIndexed { index, it ->
                Filter(category = it, selected = index % 2 == 1)
                Spacer(modifier = Modifier.width(4.dp))
            }
        }
        LazyColumn(
                modifier = Modifier.padding(top = 4.dp)
        ) {
            items(listOf("Lorem", "Ipsum", "Dolorem", "...")) { element ->
                TaskItem(modifier = Modifier.padding(8.dp), task = element)
            }
        }
    }
}

@Preview(
        widthDp = 300,
        showBackground = true
)
@Preview(
        name = "Dark theme Preview",
        widthDp = 300,
        uiMode = UI_MODE_NIGHT_YES,
        showBackground = true
)
@Composable
fun DefaultPreview() {
    TodoAppComposeTheme {
        TodoListScreen()
    }
}