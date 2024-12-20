package app.screen.about

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.brands.Github
import io.github.firzaelbuho.hlsmui.component.text.HLabel
import io.github.firzaelbuho.hlsmui.component.text.HTitle
import openUrl

@Composable
fun AboutScreen() {
    Column(
        modifier = Modifier.fillMaxWidth(0.5f),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        IconButton(
            onClick = {openUrl("https://github.com/firzaelbuho/hlsmui")}
        ){
           Icon(
               imageVector = FontAwesomeIcons.Brands.Github,
               contentDescription = "Github",
//               modifier = Modifier.padding(16.dp)
           )
        }
        VersionHistory()

    }

}

private data class Version(
    val versionNumber:String,
    val releaseDate:String,
    val platformSupport:String,
    val changes:String
)

@Composable
fun VersionHistory() {

    val versions = listOf(
        Version(
            "0.1.0-alpha02",
            releaseDate = "19-12-2024",
            platformSupport = "Android, iOS, Desktop/JVM, JS",
            changes = "first release",
        )
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        HTitle("Version History")
        Column(
        ) {
            val labels = listOf("Version Number", "Release Date", "Platform Support", "Changes"  )
            Row(
                modifier = Modifier
                    .border(width = 1.dp, color = MaterialTheme.colorScheme.onBackground)
                    .background(MaterialTheme.colorScheme.primaryContainer)
            ) {
                labels.forEach {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .weight(1f)
                            .padding(16.dp)
                    ){
                        Text(it)
                    }
                }
            }
            versions.forEach { version ->
                val labels = listOf(
                    version.versionNumber,
                    version.releaseDate,
                    version.platformSupport,
                    version.changes
                )
                Row (
                    modifier = Modifier
                        .border(width = 1.dp, color = MaterialTheme.colorScheme.onBackground)
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                ){
                    labels.forEach {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .weight(1f)
                                .padding(16.dp)
                        ){
                            HLabel(it)
                        }
                    }
                }

            }

        }
    }
}
