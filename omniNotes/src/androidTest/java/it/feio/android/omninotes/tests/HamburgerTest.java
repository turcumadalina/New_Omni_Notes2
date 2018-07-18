package it.feio.android.omninotes.tests;

import org.junit.Test;

import it.feio.android.omninotes.helpers.EspressoTestBase;
import it.feio.android.omninotes.screens.Archives;
import it.feio.android.omninotes.screens.Home;
import it.feio.android.omninotes.screens.NavigationDrawer;
import it.feio.android.omninotes.screens.Trash;

import static junit.framework.Assert.assertFalse;
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
        assertTrue("Archive button is not displayed", NavigationDrawer.isArchiveButtonDisplayedAndHasSiblingTheNoteButton());

        // Step: Click on Archive button
        NavigationDrawer.clickOnArchiveButton();

        // Verify: Note with title "Pay the bills" is displayed"
        assertTrue("Note whit text Pay the bills is not displayed", Archives.isNoteWithTextPayTheBilsDisplayed());

        // Step: Delete the note with title "Pay the bills" from archives
        Archives.removeNoteWithTitlePayTheBills();

        // Wait 2 seconds
        Thread.sleep(2000);

        // Step: Click on hamburger button
        Home.clickOnHamburgerButton();

        // Wait 2 seconds
        Thread.sleep(3000);

        // Verify: The button with name Trash is displayed below the button with name Notes
//        assertTrue("Trash button is not below Notes button", NavigationDrawer.isButtonWithNameTrashDisplayedBelowTheButtonWithNameNotes());

        // Verify: The button with name Archive is NOT displayed on navigation drawer
//        assertFalse("Archive button is still displayed on mavigation drawer", NavigationDrawer.isArchiveButtonOnNavigationDrawer());

        // Step: Click on trash button
        NavigationDrawer.clickOnTrashButton();

        // Verify: Note with title Pay the bills is displayed on Trash
        assertTrue("Note with title Pay the bills is displayed on Trash is not displayed", Trash.isNoteWithTitlePayTheBillsDisplayed());

        // Verify: List View has one child
        assertTrue("List View has more then one child", Trash.isListViewWithOneChild());
    }
}
