package me.alfredobejarano.tlv.utilities

/**
 *
 * Utils class that provides methods for parsing hex values
 * to other type of values.
 *
 * @author Alfredo Bejarano
 * @since 11/10/2018 - 06:53 PM
 * @version 1.0
 **/

/**
 * Parses a String in hexadecimal to a readable string.
 */
fun String.fromHex(): String {
    val output = StringBuilder()
    var i = 0
    while (i < this.length) {
        val str = this.substring(i, i + 2)
        output.append(Integer.parseInt(str, 16).toChar())
        i += 2
    }
    return output.toString()
}