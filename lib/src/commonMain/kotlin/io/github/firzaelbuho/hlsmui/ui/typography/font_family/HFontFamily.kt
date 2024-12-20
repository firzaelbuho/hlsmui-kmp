package io.github.firzaelbuho.hlsmui.ui.typography.font_family

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import compose_multiplatform_library_template.lib.generated.resources.Res
import compose_multiplatform_library_template.lib.generated.resources.quicksand_regular
import org.jetbrains.compose.resources.Font

object HFontFamily {
    @Composable
    fun QuickSand() = FontFamily(Font(Res.font.quicksand_regular))
}


