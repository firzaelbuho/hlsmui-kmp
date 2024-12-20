package io.github.firzaelbuho.hlsmui.ui.shape

import androidx.compose.material3.Shapes
import io.github.firzaelbuho.hlsmui.ui.shape.shapes.*

enum class HShapes(val shapes: Shapes) {
    Default(defaultShapes),
    Rounded(roundedShapes),
    CutCorner(cutCornerShapes),
    SmoothRounded(smoothRoundedShapes),
    NoRounded(noRoundedShapes),
    SlightRounded(slightRoundedShapes),
    ExtremeRounded(extremeRoundedShapes);
}