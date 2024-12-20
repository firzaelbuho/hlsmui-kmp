package io.github.firzaelbuho.hlsmui.ui.scheme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import io.github.firzaelbuho.hlsmui.ui.scheme.schemes.astronomy.*
import io.github.firzaelbuho.hlsmui.ui.scheme.schemes.nature.*
import io.github.firzaelbuho.hlsmui.ui.scheme.schemes.neutral.*
import io.github.firzaelbuho.hlsmui.ui.scheme.schemes.classic.*
import io.github.firzaelbuho.hlsmui.ui.scheme.schemes.brand.*
import io.github.firzaelbuho.hlsmui.ui.scheme.schemes.colorful.*


enum class HColorScheme(
    val light:ColorScheme,
    val dark:ColorScheme,
    val categories:List<HColorSchemeCategory>
){
    Default(lightColorScheme(), darkColorScheme(), listOf(HColorSchemeCategory.Default)),

    //Brand
    JakartaBus(JakartaBusLightColorScheme, JakartaBusDarkColorScheme, listOf(HColorSchemeCategory.Brand)),
    LangitBiru(LangitBiruLightColorScheme, LangitBiruDarkColorScheme, listOf(HColorSchemeCategory.Brand)),
    RedGroup(RedGroupLightColorScheme, RedGroupDarkColorScheme, listOf(HColorSchemeCategory.Brand)),
    SearchEngine(SearchEngineLightColorScheme, SearchEngineDarkColorScheme, listOf(HColorSchemeCategory.Brand)),

    // Nature
    Wood(WoodLightColorScheme, WoodDarkColorScheme, listOf(HColorSchemeCategory.Nature)),
    Lavender(LavenderLightColorScheme, LavenderDarkColorScheme, listOf(HColorSchemeCategory.Nature)),
    Sakura(SakuraLightColorScheme, SakuraDarkColorScheme, listOf(HColorSchemeCategory.Nature)),
    Snow(SnowLightColorScheme, SnowDarkColorScheme, listOf(HColorSchemeCategory.Nature)),
    Emerald(EmeraldLightColorScheme, EmeraldDarkColorScheme, listOf(HColorSchemeCategory.Nature)),
    Ocean(OceanLightColorScheme, OceanDarkColorScheme, listOf(HColorSchemeCategory.Nature)),
    Forest(ForestLightColorScheme, ForestDarkColorScheme, listOf(HColorSchemeCategory.Nature)),
    Watermelon(WatermelonLightColorScheme, WatermelonDarkColorScheme, listOf(HColorSchemeCategory.Nature)),
    Honey(HoneyLightColorScheme, HoneyDarkColorScheme, listOf(HColorSchemeCategory.Nature)),

    // Astronomy
    Blackhole(BlackHoleLightColorScheme, BlackHoleDarkColorScheme, listOf(HColorSchemeCategory.Astronomy)),
    Eclipse(EclipseLightColorScheme, EclipseDarkColorScheme, listOf(HColorSchemeCategory.Astronomy)),
    Galaxy(GalaxyLightColorScheme, GalaxyDarkColorScheme, listOf(HColorSchemeCategory.Astronomy)),
    Moonlight(MoonlightLightColorScheme, MoonlightDarkColorScheme, listOf(HColorSchemeCategory.Astronomy)),
    Sky(SkyLightColorScheme, SkyDarkColorScheme, listOf(HColorSchemeCategory.Astronomy)),
    Sunset(SunsetLightColorScheme, SunsetDarkColorScheme, listOf(HColorSchemeCategory.Astronomy)),
    Sunrise(SunriseLightColorScheme, SunriseDarkColorScheme, listOf(HColorSchemeCategory.Astronomy)),

    // Neutral
    Elegant(ElegantLightColorScheme, ElegantDarkColorScheme, listOf(HColorSchemeCategory.Neutral)),
    Luxury(LuxuryLightColorScheme, LuxuryDarkColorScheme, listOf(HColorSchemeCategory.Neutral)),
    GoldenLuxury(GoldenLuxuryLightColorScheme, GoldenLuxuryDarkColorScheme, listOf(HColorSchemeCategory.Neutral)),

    Candy(CandyLightColorScheme, CandyDarkColorScheme, listOf(HColorSchemeCategory.Colorful)),
    Chocolate(ChocolateLightColorScheme, ChocolateDarkColorScheme, listOf(HColorSchemeCategory.Colorful)),
    Pastel(PastelLightColorScheme, PastelDarkColorScheme, listOf(HColorSchemeCategory.Colorful)),
    Lolipop(LolipopLightColorScheme, LolipopDarkColorScheme, listOf(HColorSchemeCategory.Colorful)),
    Cupcake(CupcakeLightColorScheme, CupcakeDarkColorScheme, listOf(HColorSchemeCategory.Colorful)),

    // Classic
    Vintage(VintageLightColorScheme, VintageDarkColorScheme, listOf(HColorSchemeCategory.Classic)),
    Monochrome(MonochromeLightColorScheme, MonochromeDarkColorScheme, listOf(HColorSchemeCategory.Classic)),
}


