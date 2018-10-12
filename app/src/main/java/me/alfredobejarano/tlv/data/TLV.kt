package me.alfredobejarano.tlv.data

import androidx.annotation.StringRes

/**
 *
 * Simple data class representing the data of a **T**ag-**L**ength-**V**alue,
 * this class serves as a model class.
 *
 * @author Alfredo Bejarano
 * @since 11/10/2018 - 07:20 PM
 * @version 1.0
 **/
data class TLV(@StringRes val tag: Int, val length: Int, val value: String)