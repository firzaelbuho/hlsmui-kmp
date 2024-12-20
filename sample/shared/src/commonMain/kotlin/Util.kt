//expect fun copyToClipBoard(text:String):Unit

expect fun openUrl(url:String):Unit

fun String.addSpaceToUpperCamelCase(): String {
    val result = StringBuilder()
    for (i in this.indices) {
        val char = this[i]
        if (i > 0 && char.isUpperCase()) {
            result.append(" ")
        }
        result.append(char)
    }
    return result.toString()
}

val Lib_Version:String = "0.1.0-alpha02"
