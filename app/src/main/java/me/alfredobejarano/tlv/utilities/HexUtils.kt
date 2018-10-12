package me.alfredobejarano.tlv.utilities

import java.nio.charset.Charset

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
fun String.fromHex() = String(this.toByteArray(), Charset.forName("UTF-8"))