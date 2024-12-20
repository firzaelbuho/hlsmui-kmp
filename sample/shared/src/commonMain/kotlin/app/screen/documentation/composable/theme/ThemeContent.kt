package app.screen.documentation.composable.theme


import addSpaceToUpperCamelCase
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import app.AppViewModel
import app.ContentSwitcher
import io.github.firzaelbuho.hlsmui.component.HSpacer
import io.github.firzaelbuho.hlsmui.component.container.HCode
import io.github.firzaelbuho.hlsmui.component.input.HSelect
import io.github.firzaelbuho.hlsmui.component.input.HSwitch
import io.github.firzaelbuho.hlsmui.component.text.HLabel
import io.github.firzaelbuho.hlsmui.component.text.HTitle
import io.github.firzaelbuho.hlsmui.component.text.SizeCategory
import io.github.firzaelbuho.hlsmui.component.wireframe.HPhoneWireFrame
import io.github.firzaelbuho.hlsmui.ui.mode.HMode
import io.github.firzaelbuho.hlsmui.ui.scheme.HColorScheme
import io.github.firzaelbuho.hlsmui.ui.scheme.HColorSchemeCategory
import io.github.firzaelbuho.hlsmui.ui.shape.HShapes
import io.github.firzaelbuho.hlsmui.ui.typography.font.HFont
import org.koin.compose.viewmodel.koinViewModel
import io.github.firzaelbuho.hlsmui.component.input.HSelectWithSearch


@Composable
fun ThemeContent(
    appViewModel: AppViewModel = koinViewModel(),
    themeViewModel: ThemeViewModel = koinViewModel()
){

    val themeUiState = themeViewModel.uiState.collectAsState()

    Selector()
    HSpacer(32.dp)
    ContentSwitcher(
        switchOnText = "preview",
        switchOffText = "code",
        switchOnContent = { ThemePreview() },
        switchOffContent = { HCode(appViewModel.getThemeCode(themeUiState.value.isCustom)) }
    )
}




@Composable
private fun ThemePreview(){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Box(modifier = Modifier.fillMaxWidth(0.5f)){  HPhoneWireFrame()}

    }
}

@Composable
private fun Selector(viewModel: ThemeViewModel = koinViewModel()){

    val uiState = viewModel.uiState.collectAsState()

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {

        HTitle("themes/ HAppTheme", size = SizeCategory.Large,)




        HSwitch(
            isChecked = uiState.value.isCustom,
            onCheckedChange = { viewModel.updateIsCustom(it) },
            switchOnLabel = { HLabel("Custom Theme") },
            switchOffLabel = { HLabel("Color Scheme") },
            modifier = Modifier.scale(0.5f)

        )

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(32.dp)){
            Box(modifier = Modifier.weight(1f)){ ColorSchemeCategorySelector() }
            Box(modifier = Modifier.weight(1f)){ ColorSchemeSelector() }
            Box(modifier = Modifier.weight(1f)){ ModeSelector()  }
        }
        if(uiState.value.isCustom){
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(32.dp)){
                Box(modifier = Modifier.weight(1f)){ FontSelector() }
                Box(modifier = Modifier.weight(1f)){ ShapeSelector()  }
                Spacer(modifier = Modifier.weight(1f))


            }
        }

    }


}

@Composable
private fun ColorSchemeSelector(viewModel: AppViewModel = koinViewModel()){
    val sortedColorSchemeList = HColorScheme.entries.sortedBy { it.name }
    Column {
        HLabel("Color Scheme")
        Spacer(modifier = Modifier.height(8.dp))
        val uiState = viewModel.uiState.collectAsState()
        val colorSchemeList = if(uiState.value.colorSchemeCategory == HColorSchemeCategory.All) {
           sortedColorSchemeList
        } else {
            sortedColorSchemeList.filter { it.categories.contains(uiState.value.colorSchemeCategory) }
        }

        var searchValue by remember { mutableStateOf("") }

        HSelectWithSearch(
            searchValue = searchValue,
            onSearchValueChange = {searchValue = it},
            selectedOption = uiState.value.colorScheme,
            options = colorSchemeList.filter { it.name.contains(searchValue, ignoreCase = true) },
            onOptionSelected = {viewModel.updateColorScheme(it)},
            selectedOptionLabel = {HLabel(it.name.addSpaceToUpperCamelCase())},
            optionLabel = { colorSchemeOptionLabel(it) }
        )
    }
}


@Composable
private fun colorSchemeOptionLabel(colorScheme: HColorScheme, appViewModel: AppViewModel = koinViewModel()){

    val uiState = appViewModel.uiState.collectAsState()

    val scheme = if(uiState.value.mode == HMode.Dark) colorScheme.dark else colorScheme.light

    val colors = listOf(
        scheme.primary,
        scheme.secondary,
        scheme.tertiary,

        scheme.background,
        scheme.surfaceVariant,

        scheme.primaryContainer,
        scheme.secondaryContainer,
        scheme.tertiaryContainer,
    )

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        HTitle(colorScheme.name.addSpaceToUpperCamelCase(), size = SizeCategory.Small)
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            colors.forEach {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .clip(MaterialTheme.shapes.small)
                        .background(it)
                )

            }
        }
    }
}

@Composable
private fun ColorSchemeCategorySelector(viewModel: AppViewModel = koinViewModel()){
    Column {
        HLabel("Category : ")
        Spacer(modifier = Modifier.height(8.dp))
        val uiState = viewModel.uiState.collectAsState()
        HSelect(
            selectedOption = uiState.value.colorSchemeCategory,
            options = HColorSchemeCategory.entries,
            onOptionSelected = {viewModel.updateColorSchemeCategory(it)},
            selectedOptionLabel = {HLabel(it.name)},
            optionLabel = {HLabel(it.name)}
        )
    }
}

@Composable
private fun FontSelector(viewModel: AppViewModel = koinViewModel()){
    Column {
        HLabel("Font :")
        Spacer(modifier = Modifier.height(8.dp))
        val uiState = viewModel.uiState.collectAsState()
        HSelect(
            selectedOption = uiState.value.font,
            options = HFont.entries,
            onOptionSelected = {viewModel.updateFont(it)},
            selectedOptionLabel = {HLabel(it.name)},
            optionLabel = {HLabel(it.name)}
        )
    }
}

@Composable
private fun ShapeSelector(viewModel: AppViewModel = koinViewModel()){
    Column {
        HLabel("Shape :")
        Spacer(modifier = Modifier.height(8.dp))
        val uiState = viewModel.uiState.collectAsState()
        HSelect(
            selectedOption = uiState.value.shapes,
            options = HShapes.entries,
            onOptionSelected = {viewModel.updateShapes(it)},
            selectedOptionLabel = {HLabel(it.name)},
            optionLabel = {HLabel(it.name)}
        )
    }
}

@Composable
private fun ModeSelector(viewModel: AppViewModel = koinViewModel()){
    Column {
        HLabel("Mode :")
        Spacer(modifier = Modifier.height(8.dp))
        val uiState = viewModel.uiState.collectAsState()
        HSelect(
            selectedOption = uiState.value.mode,
            options = HMode.entries,
            onOptionSelected = {viewModel.updateMode(it)},
            selectedOptionLabel = {HLabel(it.name)},
            optionLabel = {HLabel(it.name)}
        )
    }
}

