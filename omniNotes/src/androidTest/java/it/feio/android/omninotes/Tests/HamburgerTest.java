package it.feio.android.omninotes.Tests;

import org.junit.Test;

import it.feio.android.omninotes.Helpers.Constants;
import it.feio.android.omninotes.Helpers.EspressoTestBase;
import it.feio.android.omninotes.Screens.Home;

import static junit.framework.Assert.assertTrue;

public class HamburgerTest extends EspressoTestBase {

    @Test
    public void testHamburgerValidation() throws InterruptedException {
        // Step: Click Add button
        Home.clickAddButton();

        // Step: Click Text Note button
        Home.clickTextNoteButton();

        // Step: Add note with title "Pay the bills"
        Home.addPayTheBillsNote();

        // Step: Click return button
        Home.clickReturnButton();

        // Step: Delete the note with title "Pay the bills"
        Home.deleteNoteWithTitlePayTheBills();

        // Wait 2 seconds
        Thread.sleep(2000);

        // Step: Click on hamburger button
        Home.clickOnHamburgerButton();

        // Wait 2 seconds
        Thread.sleep(2000);

        // Verify: The button with name Archive is displayed and has sibling the button with name Notes
        assertTrue(Constants.archiveButtonVisibilityMessage, Home.isArchivebuttonDisplayedAndHasSiblingTheNoteButton());
    }
}
