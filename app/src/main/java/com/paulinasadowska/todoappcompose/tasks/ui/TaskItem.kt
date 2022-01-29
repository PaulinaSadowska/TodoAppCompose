package com.paulinasadowska.todoappcompose.tasks.ui

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paulinasadowska.todoappcompose.ui.theme.TodoAppComposeTheme

@Composable
fun TaskItem(
        modifier: Modifier = Modifier,
        task: String,
        categoryColor: Color = MaterialTheme.colors.primary
) {
    val (selected, setSelected) = remember { mutableStateOf(false) }
    Card(
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            elevation = 0.dp
    ) {
        Row(
                verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                    modifier = Modifier
                            .width(12.dp)
                            .height(60.dp)
                            .background(categoryColor)
            )
            Row(
                    modifier = Modifier
                            .padding(top = 12.dp, bottom = 12.dp, end = 12.dp, start = 4.dp),
                    verticalAlignment = Alignment.CenterVertically,
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