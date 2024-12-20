package io.github.firzaelbuho.hlsmui

import java.awt.Toolkit
import java.awt.datatransfer.Clipboard
import java.awt.datatransfer.StringSelection


actual fun copyTextToClipBoard(text: String) {
    val clipboard: Clipboard = Toolkit.getDefaultToolkit().systemClipboard
    val selection = StringSelection(text)
    clipboard.setContents(selection, selection)
}