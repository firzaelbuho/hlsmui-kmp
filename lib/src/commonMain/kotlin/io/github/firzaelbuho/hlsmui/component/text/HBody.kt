package io.github.firzaelbuho.hlsmui.component.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun HBody(
    text: String = "Body",
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    size: SizeCategory = SizeCategory.Medium,
)  {
    Text(
        text = text,
        color = color,
        modifier = modifier,
        style = when(size) {
            SizeCategory.Small -> MaterialTheme.typography.bodySmall
            SizeCategory.Medium -> MaterialTheme.typography.bodyMedium
            SizeCategory.Large -> MaterialTheme.typography.bodyLarge
        }
    )
}