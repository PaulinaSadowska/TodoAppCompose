package com.paulinasadowska.todoappcompose.tasks.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paulinasadowska.todoappcompose.ui.theme.TodoAppComposeTheme

@Composable
fun TaskItem(
        modifier: Modifier = Modifier,
        task: String
) {
    val (selected, setSelected) = remember { mutableStateOf(false) }
    Card(modifier = modifier.fillMaxWidth()) {
        Row(
                modifier = Modifier.padding(all = 8.dp),
                verticalAlignment = Alignment.CenterVertically
        ) {
            TaskRadioButton(
                    selected = selected,
                    onClick = { setSelected(!selected) },
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                    text = task,
            )
        }
    }
}

@Preview(
        showBackground = true,
        widthDp = 300
)
@Preview(
        name = "Dark theme Preview",
        showBackground = true,
        widthDp = 300,
        uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun TaskItemPreview() {
    TodoAppComposeTheme {
        TaskItem(modifier = Modifier.padding(4.dp), task = "Some task")
    }
}