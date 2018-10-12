package me.alfredobejarano.tlv.viewmodel

import androidx.annotation.StringRes
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.payneteasy.tlv.BerTlvParser
import com.payneteasy.tlv.HexUtil
import me.alfredobejarano.tlv.R
import me.alfredobejarano.tlv.data.TLV
import me.alfredobejarano.tlv.utilities.DOUBLE_BYTE_TAGS
import me.alfredobejarano.tlv.utilities.SINGLE_BYTE_TAGS
import me.alfredobejarano.tlv.utilities.fromHex
import java.util.concurrent.Executors

/**
 *
 * Simple [ViewModel] subclass that handles parsing of a TLV value.
 *
 * @author Alfredo Bejarano
 * @since 11/10/2018 - 08:55 PM
 * @version 1.0
 **/
class TLVViewModel : ViewModel() {
    val results = MutableLiveData<List<TLV>>()

    /**
     * Parses a Hex TLV string into a List of [TLV] objects.
     * @param tlv The Hex string containing the TLV data.
     */
    fun parse(tlv: String) = Executors.newSingleThreadExecutor().execute {
        try {
            // Parse the TLV string as a Hex string.
            val tlvBytes = HexUtil.parseHex(tlv)
            // Retrieve all the TLV values from the Hex string.
            val parseResults = BerTlvParser().parse(tlvBytes)
            // Create an empty list containing the results.
            val records = mutableListOf<TLV>()
            // Use the null-safe operator (?) to iterate through the results only if those are not null.
            parseResults?.list?.forEach {
                val tag = it?.tag?.toString()?.replace("- ", "")
                val value = it?.hexValue?.fromHex() ?: ""
                // Create a new TLV object using the extracted results.
                records.add(TLV(getTagName(tag), value.length, value))
            }
            // Return the found results.
            results.postValue(records)
        } catch (e: Exception) {
            // If something wrong happens, return an empty list.
            results.postValue(mutableListOf())
        }
    }

    /**
     * Looks into the Tag names HashMap and retrieves the String resource
     * for the tag code name.
     * @param tag The tag from the TLV entry.
     * @return Integer value of the String resource id.
     */
    @StringRes
    private fun getTagName(tag: String?): Int = when {
        // Check if the id is in the single byte tags.
        SINGLE_BYTE_TAGS.contains(tag) -> SINGLE_BYTE_TAGS[tag] ?: R.string.unknown_tag
        // Check if the id is in the double byte tags.
        DOUBLE_BYTE_TAGS.contains(tag) -> DOUBLE_BYTE_TAGS[tag] ?: R.string.unknown_tag
        // If it is not found, return an unknown name.
        else -> R.string.unknown_tag
    }
}