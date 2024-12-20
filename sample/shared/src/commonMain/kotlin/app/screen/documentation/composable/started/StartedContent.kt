package app.screen.documentation.composable.started

import Lib_Version
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.firzaelbuho.hlsmui.component.HSpacer
import io.github.firzaelbuho.hlsmui.component.container.HCode
import io.github.firzaelbuho.hlsmui.component.text.HBody
import io.github.firzaelbuho.hlsmui.component.text.HTitle
import io.github.firzaelbuho.hlsmui.component.text.SizeCategory

private  val instruction1 = "1. set up the KMP project"
private  val instruction3 = "3. sync the gradle project"
private  val instruction2 = "2. add the dependency into your build.gradle shared module"
private  val code2 = """
    commonMain.dependencies {
        implementation("io.github.aozora01:hlsmui:${Lib_Version}")
    }
""".trimIndent()

@Composable
fun StartedContent(){
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ){
        HTitle("get started", size = SizeCategory.Large,)
        HBody(instruction1, size = SizeCategory.Medium)
        TutorialContent(instruction2, code2)
        HBody(instruction3, size = SizeCategory.Medium)

    }
}

@Composable
private fun TutorialContent(instruction:String, code:String){
    Column(
        modifier = Modifier
    ){
        HBody(instruction, size = SizeCategory.Medium)
        HSpacer(16.dp)
        HCode(code)
    }
}