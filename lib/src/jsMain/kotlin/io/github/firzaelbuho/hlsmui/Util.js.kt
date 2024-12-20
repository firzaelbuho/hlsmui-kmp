package io.github.firzaelbuho.hlsmui

import kotlinx.browser.window

actual fun copyTextToClipBoard(text: String) {
    window.navigator.clipboard.writeText(text)
}