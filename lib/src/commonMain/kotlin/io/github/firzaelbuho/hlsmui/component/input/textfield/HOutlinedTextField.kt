package io.github.firzaelbuho.hlsmui.component.input.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Eye
import compose.icons.fontawesomeicons.solid.EyeSlash
import io.github.firzaelbuho.hlsmui.component.text.HLabel


@Composable
fun HOutlinedTextField(
    value: String = "value",
    onValueChange: (String) -> Unit = {},
    modifier: Modifier = Modifier
        .fillMaxWidth(),
    inputType: InputType = InputType.Text,
    label: @Composable () -> Unit = {HLabel("Input")},
    placeholder : @Composable () -> Unit = {HLabel("")},
    colors : TextFieldColors = OutlinedTextFieldDefaults.colors()
) {
    var showPassword by remember { mutableStateOf(false) }
    var number by remember { mutableStateOf(value.toIntOrNull() ?: 0) }
    var textValue by remember { mutableStateOf(value) }

    OutlinedTextField(
        placeholder = placeholder,
        colors = colors,
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
                        onValueChange(number.toString())
                    }
                }
                else -> {
                    textValue = newValue
                    onValueChange(newValue)
                }
            }
        },
        label = label,
        modifier = modifier,
//        keyboardOptions = KeyboardOptions(keyboardType = inputType),
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
//                    Row(
//                        modifier = Modifier.scale(0.3f),
//                        verticalAlignment = Alignment.CenterVertically,
//                        horizontalArrangement = Arrangement.End
//                    ) {
//                        IconButton(
//                            onClick = { number-- }
//                        ) {
//                            Icon(
//                                FontAwesomeIcons.Solid.Minus,
//                                contentDescription = "Kurangi",
//                            )
//                        }
//                        IconButton(
//                            modifier = Modifier.padding(8.dp),
//                            onClick = { number++ }
//                        ) {
//                            Icon(
//                                FontAwesomeIcons.Solid.Plus,
//                                contentDescription = "Tambah",
//                            )
//                        }
//
//                    }
                }
                else -> null
            }
        }
    )
}