package it.feio.android.omninotes.tests;

import org.junit.Test;

import it.feio.android.omninotes.helpers.EspressoTestBase;
import it.feio.android.omninotes.screens.Home;

import static junit.framework.Assert.assertTrue;

public class AppointmentDetailsTest extends EspressoTestBase {

    @Test
    public void testAppointmentDetails() {
        // Verify: Image with "Nothing here!" is displayed and clickable.
        assertTrue("Image with nothing here text is not visible", Home.isImageWithNothingHereTextDisplayed());
    }
}
