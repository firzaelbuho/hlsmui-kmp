package app

import androidx.lifecycle.ViewModel
import io.github.firzaelbuho.hlsmui.ui.mode.HMode
import io.github.firzaelbuho.hlsmui.ui.scheme.HColorScheme
import io.github.firzaelbuho.hlsmui.ui.scheme.HColorSchemeCategory
import io.github.firzaelbuho.hlsmui.ui.shape.HShapes
import io.github.firzaelbuho.hlsmui.ui.typography.font.HFont
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class AppUiState(

    val name:String = "app",
    val colorSchemeCategory: HColorSchemeCategory = HColorSchemeCategory.All,
    val colorScheme: HColorScheme = HColorScheme.Default,
    val font: HFont = HFont.Default,
    val shapes: HShapes = HShapes.Default,
    val mode:HMode = HMode.Light,
    val navBarMenu: NavbarMenu = NavbarMenu.Home,
)

class AppViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(AppUiState())
    val uiState: StateFlow<AppUiState> = _uiState.asStateFlow()

    fun updateNavbarMenu(navbarMenu: NavbarMenu){
        _uiState.value = _uiState.value.copy(
            navBarMenu = navbarMenu
        )
    }

    fun updateColorSchemeCategory(colorSchemeCategory: HColorSchemeCategory){
        _uiState.value = _uiState.value.copy(colorSchemeCategory = colorSchemeCategory)
    }

    fun updateMode(mode: HMode){
        _uiState.value = _uiState.value.copy(mode = mode)
    }

    fun updateColorScheme(colorScheme: HColorScheme){
        _uiState.value = _uiState.value.copy(colorScheme = colorScheme)
    }
    fun updateFont(font: HFont){
        _uiState.value = _uiState.value.copy(font = font)
    }
    fun updateShapes(shapes: HShapes){
        _uiState.value = _uiState.value.copy(shapes = shapes)
    }


    fun getThemeCode(isCustom:Boolean):String{

       if(isCustom){
           return """
    val theme = HTheme(
        colorScheme = HColorScheme.${uiState.value.colorScheme.name},
        font = HFont.${uiState.value.font.name},
        shapes = HShapes.${uiState.value.shapes.name}
    )

    HAppTheme(
        theme = theme, 
        mode = HMode.${uiState.value.mode.name}
    ){
        Column() {
            HPhoneWireframe()
        }
    }
           """.trimIndent()
       } else {
          return """
    HAppTheme(
        colorScheme = HColorScheme.${uiState.value.colorScheme.name}, 
        mode = HMode.${uiState.value.mode.name}
    ){
        Column() {
            HPhoneWireframe()
        }
    }
          """.trimIndent()
       }
    }

}