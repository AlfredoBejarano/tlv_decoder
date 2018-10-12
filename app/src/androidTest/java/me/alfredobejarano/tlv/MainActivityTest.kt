package me.alfredobejarano.tlv

import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.google.android.material.R.id.snackbar_text
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * UI test for the MainActivity.
 *
 * @author Alfredo Bejarano
 * @version 1.0
 * @since 11/10/2018 - 10:20 PM
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get: Rule
    val mainActivity =
        ActivityTestRule<MainActivity>(MainActivity::class.java)

    /**
     * Types a TLV text and then proceeds to decode the view and scroll the results list.
     */
    @Test
    fun typeTLVText_scrollResultsList() {
        // Type a valid TLV text.
        onView(withId(R.id.tlv_input))
            .perform(clearText())
            .perform(typeText("9F0705AC00211367"))
        // Close the soft keyboard.
        closeSoftKeyboard()
        // Click the decode button.
        onView(withId(R.id.decode_button))
            .perform(click())
        // Swipe on the list.
        onView(withId(R.id.tlv_list))
            .perform(swipeDown())
            .perform(swipeUp())
    }

    /**
     * Types a TLV text and then proceeds to decode the view and scroll the results list.
     */
    @Test
    fun typeInvalidTLVText_checkSnackBar() {
        // Type a valid TLV text.
        onView(withId(R.id.tlv_input))
            .perform(clearText())
            .perform(typeText("Espresso Rocks!"))
        // Close the soft keyboard.
        closeSoftKeyboard()
        // Click the decode button.
        onView(withId(R.id.decode_button))
            .perform(click())
        // Check that the SnackBar displayed with the correct message.
        onView(withId(snackbar_text))
            .check(matches(withText(R.string.no_values_found)))
    }
}