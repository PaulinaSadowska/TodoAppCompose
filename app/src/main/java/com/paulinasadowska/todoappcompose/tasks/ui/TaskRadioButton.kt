package com.paulinasadowska.todoappcompose.tasks.ui

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Icon
import androidx.compose.material.RadioButtonColors
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RadioButtonUnchecked
import androidx.compose.material.icons.filled.TaskAlt
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun TaskRadioButton(
        selected: Boolean,
        onClick: (() -> Unit)?,
        modifier: Modifier = Modifier,
        buttonSize: Dp = DefaultRadioButtonSize,
        enabled: Boolean = true,
        interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
        colors: RadioButtonColors = RadioButtonDefaults.colors()
) {
    val radioColor by colors.radioColor(enabled, selected)
    val selectableModifier =
            if (onClick != null) {
                Modifier.selectable(
                        selected = selected,
                        onClick = onClick,
                        enabled = enabled,
                        role = Role.RadioButton,
                        interactionSource = interactionSource,
                        indication = rememberRipple(
                                bounded = false,
                                radius = buttonSize + 2.dp
                        )
                )
            } else {
                Modifier
            }
    Box(
            modifier
                    .then(selectableModifier)
                    .wrapContentSize(Alignment.Center)
                    .padding(RadioButtonPadding)
                    .requiredSize(buttonSize)
    ) {
        Icon(
                imageVector = if (selected) {
                    Icons.Default.TaskAlt
                } else {
                    Icons.Default.RadioButtonUnchecked
                },
                contentDescription = "radio button",
                tint = radioColor,
                modifier = Modifier.size(buttonSize)
        )
    }
}

private val RadioButtonPadding = 2.dp
private val DefaultRadioButtonSize = 32.dp
