package app.screen.documentation.composable.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import app.screen.documentation.section.ComponentParam
import app.screen.documentation.section.ComponentParamsTable
import app.screen.documentation.section.Extras
import io.github.firzaelbuho.hlsmui.component.dump.HDumpColorScheme
import io.github.firzaelbuho.hlsmui.component.dump.HDumpFontWeight
import io.github.firzaelbuho.hlsmui.component.dump.HDumpShapes
import io.github.firzaelbuho.hlsmui.component.dump.HDumpText
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun ThemeExtra(viewModel: ThemeViewModel = koinViewModel()){

    val uiState = viewModel.uiState.collectAsState()



    val componentParas = when(uiState.value.isCustom){
        true -> listOf(
            ComponentParam("theme", "HTheme", "-", true,"define theme with constructed HTheme object that contains : color scheme, font, and shape"),
            ComponentParam("mode", "HMode", "HMode.Auto", false,"define mode : Auto, Light, or Dark"),
        )
        false -> listOf(
            ComponentParam("colorScheme", "HColorScheme", "-", true,""),
            ComponentParam("mode", "HMode", "HMode.Auto", false,"define mode : Auto, Light, or Dark"),
            ComponentParam("typography", "Typography", "Typography()", false,""),
            ComponentParam("shapes", "Shapes", "Shapes()", false,""),
        )
    }



    Column(modifier = Modifier.fillMaxWidth()){
        Extras("Parameters", true, { ComponentParamsTable(componentParas)})
        Extras("Color Scheme",false, { HDumpColorScheme() })

        if(uiState.value.isCustom){
            Extras("Typography",false, { HDumpText() })
            Extras("Font Weight",false, { HDumpFontWeight() })
            Extras("Shapes",false, {HDumpShapes()})
        }
    }
}




