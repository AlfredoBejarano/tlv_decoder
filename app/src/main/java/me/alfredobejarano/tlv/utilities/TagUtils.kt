package me.alfredobejarano.tlv.utilities

import me.alfredobejarano.tlv.R

/**
 *
 * Utils class that provides helper data for tags.
 *
 * @author Alfredo Bejarano
 * @since 11/10/2018 - 06:54 PM
 * @version 1.0
 **/

/**
 * HashMap that contains possible values for a single byte tag.
 */
val SINGLE_BYTE_TAGS = HashMap<String, Int>().also {
    it["4F"] = R.string.aid_tag
    it["9A"] = R.string.transaction_date_tag
    it["5A"] = R.string.pan_tag
    it["57"] = R.string.track_2_data_tag
    it["82"] = R.string.app_interchange_profile_tag
    it["8E"] = R.string.cvm_list_tag
    it["9C"] = R.string.transaction_type_tag
    it["95"] = R.string.verification_results_tag
    it["9B"] = R.string.transaction_status_info_tag
    it["84"] = R.string.df_name_tag
    it["8A"] = R.string.auth_response_code_tag
    it["50"] = R.string.app_label_tag
}

val DOUBLE_BYTE_TAGS = HashMap<String, Int>().also {
    it["5F20"] = R.string.cardholder_name_tag
    it["5F24"] = R.string.expiration_date_tag
    it["9F16"] = R.string.merchant_id_tag
    it["9F21"] = R.string.transaction_date_tag
    it["9F02"] = R.string.amount_auth_tag
    it["9F03"] = R.string.amount_other_tag
    it["9F34"] = R.string.cvm_results_tag
    it["9F12"] = R.string.app_preferred_name_tag
    it["9F06"] = R.string.aid_terminal_tag
    it["5F30"] = R.string.service_code_tag
    it["9F4E"] = R.string.merchant_name_loc_tag
    it["9F10"] = R.string.issuer_app_data_tag
    it["5F25"] = R.string.app_efective_date_tag
    it["9F07"] = R.string.app_usage_tag
    it["9F0D"] = R.string.issuer_default_tag
    it["9F0E"] = R.string.issuer_denial_tag
    it["9F0F"] = R.string.issuer_online_tag
    it["9F26"] = R.string.app_crypto_tag
    it["9F27"] = R.string.app_crypto_info_tag
    it["9F36"] = R.string.atc_tag
    it["9F33"] = R.string.unpredictable_number_tag
    it["9F39"] = R.string.pos_entry_tag
    it["9F40"] = R.string.add_terminal_tag
    it["5F2A"] = R.string.transaction_currency_code_tag
    it["5F34"] = R.string.app_primary_tag
    it["9F09"] = R.string.app_version_number_tag
    it["9F1A"] = R.string.terminal_country_code_tag
    it["9F1E"] = R.string.ifd_tag
    it["9F35"] = R.string.terminal_type_tag
    it["9F41"] = R.string.transaction_sequence_tag
    it["5F28"] = R.string.issuer_country_code_tag
    it["9F08"] = R.string.app_version_number_tag
}