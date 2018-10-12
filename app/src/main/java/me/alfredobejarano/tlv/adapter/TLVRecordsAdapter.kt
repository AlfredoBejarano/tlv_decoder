package me.alfredobejarano.tlv.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import me.alfredobejarano.tlv.R
import me.alfredobejarano.tlv.data.TLV
import me.alfredobejarano.tlv.utilities.fromHex

/**
 *
 * Adapter that displays a list of [TLV] objects in a RecyclerView.
 *
 * @author Alfredo Bejarano
 * @since 11/10/2018 - 09:59 PM
 * @version 1.0
 **/
class TLVRecordsAdapter(private var records: List<TLV>?) :
    RecyclerView.Adapter<TLVRecordsAdapter.TLVRecordViewHolder>() {

    /**
     * Creates a [TLVRecordViewHolder] object to be added to the RecyclerView.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TLVRecordViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_tlv, parent, false)
        )

    /**
     * Retrieves the amount of records that the RecyclerView is going to display.
     */
    override fun getItemCount() = records?.size ?: 0

    /**
     * Assign values to the ViewHolder views.
     */
    override fun onBindViewHolder(holder: TLVRecordViewHolder, position: Int) {
        val tag = records?.get(position)?.tag ?: R.string.unknown_tag
        holder.tagView.hint = holder.itemView.context.getString(tag)
        holder.valueView.setText(records?.get(position)?.value ?: "")
    }

    fun setResults(results: List<TLV>) {
        records = results
        notifyDataSetChanged()
    }

    /**
     * ViewHolder subclass that defines how a TLV record is going to be drawn.
     */
    class TLVRecordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val valueView: TextInputEditText = itemView.findViewById(R.id.tlv_value)
        val tagView: TextInputLayout = itemView.findViewById(R.id.textInputLayout)
    }
}