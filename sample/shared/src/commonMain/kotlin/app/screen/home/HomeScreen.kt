package app.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import app.AppViewModel
import app.NavbarMenu
import io.github.firzaelbuho.hlsmui.component.text.HBody
import io.github.firzaelbuho.hlsmui.component.text.HHeadline
import io.github.firzaelbuho.hlsmui.component.text.SizeCategory
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = koinViewModel()) {
    val uiState = viewModel.uiState

    Row(
        horizontalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        Box(modifier = Modifier.weight(1f)){ LeftSection() }

        Box(modifier = Modifier.weight(1f)){ RightSection(uiState)}
    }

}

@Composable
private fun LeftSection(){

    Row(
         modifier = Modifier
             .fillMaxWidth()
             .aspectRatio(1.5f)
             .clip(MaterialTheme.shapes.large)
             .background(MaterialTheme.colorScheme.primaryContainer)
     ){
        val colors = listOf(
            MaterialTheme.colorScheme.primary,
            MaterialTheme.colorScheme.primaryContainer,
            MaterialTheme.colorScheme.secondary,
            MaterialTheme.colorScheme.secondaryContainer,
            MaterialTheme.colorScheme.tertiary,
            MaterialTheme.colorScheme.tertiaryContainer,
        )
        colors.forEachIndexed { index, color ->
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight((colors.size * 2 - index).toFloat() )
                    .background(color)

            )
        }
    }

}

@Composable
private fun RightSection(uiState: HomeUiState, appViewModel: AppViewModel = koinViewModel()){

    Column(
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        HHeadline(uiState.textAcronym, size = SizeCategory.Large)
        HBody(uiState.textDescription, size = SizeCategory.Large)
        Button(
            onClick = {appViewModel.updateNavbarMenu(NavbarMenu.Documentation)}
        ){
            Text("Get Started")
        }
    }
}