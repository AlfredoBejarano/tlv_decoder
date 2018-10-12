package me.alfredobejarano.tlv.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

/**
 * Test case class for the TLVViewModel class.
 *
 * @author Alfredo Bejarano
 * @version 1.0
 * @since 11/10/2018 - 09:01 PM
 */
class TLVViewModelTest {
    /**
     * Rule that forces LiveData to report changes in the main thread.
     */
    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    /**
     * Reference to the view model class that is being tested.
     */
    private val viewModel = TLVViewModel()

    /**
     * Parses a single record TLV string and checks that
     * it returns a single result list.
     */
    @Test
    fun parseTest_withValidTLV() {
        viewModel.parse("4F020102")
        assertEquals(1, viewModel.results.value?.size)
    }

    /**
     * Parses an invalid TLV string and checks that
     * it returns an empty list.
     */
    @Test
    fun parseTest_withInvalidTLV() {
        viewModel.parse("JUnit")
        assertEquals(0, viewModel.results.value?.size)
    }
}