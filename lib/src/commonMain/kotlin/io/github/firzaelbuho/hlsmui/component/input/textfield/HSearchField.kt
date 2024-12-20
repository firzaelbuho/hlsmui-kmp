package io.github.firzaelbuho.hlsmui.component.input.textfield

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Eye
import compose.icons.fontawesomeicons.solid.EyeSlash
import compose.icons.fontawesomeicons.solid.Search
import io.github.firzaelbuho.hlsmui.component.text.HLabel


@Composable
fun HSearchField(
    value: String = "",
    onSearchValueChange: (String) -> Unit = {},
    modifier: Modifier = Modifier.fillMaxWidth(),
    inputType: InputType = InputType.Text,
    label: @Composable () -> Unit = {HLabel("")},
    placeholder : @Composable () -> Unit = {Text("Search")},
    colors : TextFieldColors = TextFieldDefaults.colors(
        unfocusedLabelColor = MaterialTheme.colorScheme.onBackground,
        focusedLabelColor = MaterialTheme.colorScheme.onBackground,
        focusedContainerColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent

    )
) {
    var showPassword by remember { mutableStateOf(false) }
    var number by remember { mutableStateOf(value.toIntOrNull() ?: 0) }
    var textValue by remember { mutableStateOf(value) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Icon(
            imageVector = FontAwesomeIcons.Solid.Search,
            contentDescription = "Search",
            modifier = Modifier
                .scale(scaleX = -1f, scaleY = 1f)
                .height(16.dp)
        )
        TextField(
            colors = colors,
            placeholder = placeholder,
            value = when (inputType) {
                InputType.Number -> number.toString()
                else -> textValue
            },
            onValueChange = { newValue ->
                when (inputType) {
                    InputType.Number -> {
                        val newNumber = newValue.toIntOrNull()
                        if (newNumber != null) { // Hanya ubah jika input valid
                            number = newNumber
                            onSearchValueChange(number.toString())
                        }
                    }
                    else -> {
                        textValue = newValue
                        onSearchValueChange(newValue)
                    }
                }
            },
            label = label,
            modifier = modifier,
            visualTransformation = when (inputType) {
                InputType.Password ->
                    if (showPassword) VisualTransformation.None else PasswordVisualTransformation()
                else -> VisualTransformation.None
            },
            trailingIcon = {
                when (inputType) {
                    InputType.Password -> {
                        IconButton(
                            modifier = Modifier.scale(0.5f),
                            onClick = { showPassword = !showPassword }) {
                            Icon(

                                imageVector = if (showPassword) FontAwesomeIcons.Solid.Eye else FontAwesomeIcons.Solid.EyeSlash,
                                contentDescription = if (showPassword) "Sembunyikan password" else "Tampilkan password"
                            )
                        }
                    }
                    InputType.Number  -> {

                    }
                    else -> null
                }
            }
        )
    }

}