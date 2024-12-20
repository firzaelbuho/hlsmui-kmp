package io.github.firzaelbuho.hlsmui.ui.scheme.schemes.nature


import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color


// Light Color Scheme for Honey
internal val HoneyLightColorScheme = lightColorScheme(
    primary = Color(0xFFE6CBAC), // Pantone 15-1225 TPG, Vanilla Custard, warna madu yang sedikit lebih gelap
    onPrimary = Color(0xFF381800), // Coklat tua, kontras tinggi dengan primary
    primaryContainer = Color(0xFFFFDCC4), // Pantone 14-1012 TPG, Peach Nectar
    onPrimaryContainer = Color(0xFF381800), //  Coklat tua, kontras dengan primaryContainer
    secondary = Color(0xFFFFE1C1), // Pantone 13-0908 TPG, Cornsilk
    onSecondary = Color(0xFF381800), // Coklat tua, kontras tinggi dengan secondary
    secondaryContainer = Color(0xFFFFF3E0), // Pantone 12-0738 TPG, Champagne Beige
    onSecondaryContainer = Color(0xFF210E00), //  Coklat tua, kontras dengan secondaryContainer
    tertiary = Color(0xFF7D5B39), // Pantone 17-1340 TPG, Hazel, warna coklat keemasan yang elegan
    onTertiary = Color(0xFFFFFFFF), // Putih, kontras tinggi dengan tertiary
    tertiaryContainer = Color(0xFFF9DFC0), // Pantone 14-1122 TPG, Apricot Ice
    onTertiaryContainer = Color(0xFF2C1800), // Coklat tua, kontras dengan tertiaryContainer
    error = Color(0xFFBA1A1A),
    errorContainer = Color(0xFFFFDAD6),
    onError = Color(0xFFFFFFFF),
    onErrorContainer = Color(0xFF410002),
    background = Color(0xFFFFFBFF), // Pantone 11-0602 TPG,  Cloud Dancer
    onBackground = Color(0xFF210E00),
    surface = Color(0xFFFFFBFF),
    onSurface = Color(0xFF210E00),
    surfaceVariant = Color(0xFFF4E0D5), // Pantone 14-1313 TPG, Sweet Corn
    onSurfaceVariant = Color(0xFF534339),
    outline = Color(0xFF857368),
    inverseOnSurface = Color(0xFFFBEEED),
    inverseSurface = Color(0xFF362F2B),
    inversePrimary = Color(0xFF783A23)
)

// Dark Color Scheme for Honey
internal val HoneyDarkColorScheme = darkColorScheme(
    primary = Color(0xFFD7B89C), // Pantone 16-1324 TPG,  Golden Yellow, warna madu yang lebih gelap
    onPrimary = Color(0xFF512712), // Coklat tua, kontras dengan primary
    primaryContainer = Color(0xFF6A3E26), // Pantone 18-1445 TPG,  Brown Sugar
    onPrimaryContainer = Color(0xFFD7B89C), // Pantone 16-1324 TPG,  Golden Yellow
    secondary = Color(0xFFFFB59B), // Pantone 16-1333 TPG,  Peach Pink
    onSecondary = Color(0xFF512712), // Coklat tua, kontras dengan secondary
    secondaryContainer = Color(0xFF783A23), // Pantone 18-1442 TPG,  Brandy
    onSecondaryContainer = Color(0xFFFFB59B), // Pantone 16-1333 TPG,  Peach Pink
    tertiary = Color(0xFFE6CBAC), // Pantone 15-1225 TPG, Vanilla Custard
    onTertiary = Color(0xFF492E17), // Coklat tua, kontras dengan tertiary
    tertiaryContainer = Color(0xFF63442C), // Pantone 19-1329 TPG,  Mocha Mousse
    onTertiaryContainer = Color(0xFFE6CBAC), // Pantone 15-1225 TPG, Vanilla Custard
    error = Color(0xFFFFB4AB),
    errorContainer = Color(0xFF93000A),
    onError = Color(0xFF690005),
    onErrorContainer = Color(0xFFFFB4AB),
    background = Color(0xFF210E00), // Coklat tua
    onBackground = Color(0xFFE6CBAC), // Pantone 15-1225 TPG, Vanilla Custard
    surface = Color(0xFF210E00),
    onSurface = Color(0xFFE6CBAC),
    surfaceVariant = Color(0xFF534339),
    onSurfaceVariant = Color(0xFFD7B89C), // Pantone 16-1324 TPG,  Golden Yellow
    outline = Color(0xFFA08C7A),
    inverseOnSurface = Color(0xFF210E00),
    inverseSurface = Color(0xFFE6CBAC), // Pantone 15-1225 TPG, Vanilla Custard
    inversePrimary = Color(0xFF783A23)
)