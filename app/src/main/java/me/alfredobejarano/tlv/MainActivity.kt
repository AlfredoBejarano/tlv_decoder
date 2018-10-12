package me.alfredobejarano.tlv

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import me.alfredobejarano.tlv.adapter.TLVRecordsAdapter
import me.alfredobejarano.tlv.viewmodel.TLVViewModel

/**
 * Simple [AppCompatActivity] subclass that acts as the UI controller for decoding a TLV string.
 * @author Alfredo Bejarano
 * @since October 11th, 2018 - 10:10 PM
 * @version 1.0
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the activity layout.
        setContentView(R.layout.activity_main)
        // Retrieve a TLVViewModel object for this activity.
        val viewModel = ViewModelProviders.of(this)[TLVViewModel::class.java]
        // Reference the RecyclerView list and assign a layout manager and adapter.
        val list = tlv_list?.also {
            it.layoutManager = LinearLayoutManager(this)
            it.adapter = TLVRecordsAdapter(null)
        }
        // Observe the results from the ViewModel.
        viewModel.results.observe(this, Observer {
            // If the list is empty, notify to the user that no results were found.
            if (it?.isNotEmpty() == true) {
                Snackbar.make(root, R.string.no_values_found, Snackbar.LENGTH_LONG).show()
            }
            // Set the results in the adapter.
            (list?.adapter as TLVRecordsAdapter?)?.setResults(it)
        })
        // Listen when the user press ok in the TLV input view.
        decode_button?.setOnClickListener {
            viewModel.parse(tlv_input?.text?.toString() ?: "")
        }
    }
}
