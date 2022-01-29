package com.paulinasadowska.todoappcompose.tasks.ui.filters

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paulinasadowska.todoappcompose.ui.theme.Blue
import com.paulinasadowska.todoappcompose.ui.theme.TodoAppComposeTheme

@Composable
fun Filter(
        modifier: Modifier = Modifier,
        category: String,
        color: Color = Blue,
        selected: Boolean = false
) {
    Surface(
            modifier = modifier
                    .padding(all = 8.dp)
                    .wrapContentWidth(),
            color = Color.Transparent,
            shape = RoundedCornerShape(24.dp),
            border = BorderStroke(
                    width = (1.5).dp,
                    color = color
            )
    ) {
        Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                        .background(if (selected) color else Color.Transparent)
                        .padding(top = 8.dp, bottom = 8.dp, start= 16.dp, end = 16.dp),
        ) {
            Text(
                    modifier = Modifier
                            .wrapContentWidth()
                            .wrapContentHeight(),
                    text = category,
                    color = if(selected) Color.White else color
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
fun FilterPreview() {
    TodoAppComposeTheme {
        Row(
                modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {
            listOf("Personal", "Work", "Shopping list").forEachIndexed { index, it ->
                Filter(category = it, selected = index % 2 == 1)
                Spacer(modifier = Modifier.width(4.dp))
            }
        }
    }
}
