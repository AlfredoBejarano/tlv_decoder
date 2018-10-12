package me.alfredobejarano.tlv.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Test case class for the TLVViewModel class.
 *
 * @author Alfredo Bejarano
 * @version 1.0
 * @since 11/10/2018 - 09:01 PM
 */
@RunWith(JUnit4::class)
class TLVViewModelTest {
    /**
     * Rule that tells to the LiveData objects to report results immediately in the current thread.
     * The JUnit tests exist in a single thread as the JVM doesn't support multi-threaded operations.
     */
    @get: Rule
    var rule: TestRule = InstantTaskExecutorRule()

    /**
     * Reference to a ViewModel to test.
     */
    private val testViewModel = TLVViewModel()

    /**
     * Test case that receives a single record TLV string
     * and checks if the result only contains one element.
     */
    @Test
    fun parse_successfulResult() {
        testViewModel.results.observeForever {
            assertEquals(1, it?.size)
        }
        testViewModel.parse("4F04AABB")
    }

    /**
     * Test case that receives a string, the results must be empty.
     */
    @Test
    fun parse_invalidTLVInput() {
        testViewModel.results.observeForever {
            assertEquals(0, it?.size)
        }
        testViewModel.parse("Hello world!")
    }
}