package it.feio.android.omninotes.Test;

import org.junit.Test;

import it.feio.android.omninotes.Helpers.StartTheApplication;
import it.feio.android.omninotes.Screen.Archive;
import it.feio.android.omninotes.Screen.Home;
import it.feio.android.omninotes.Screen.TextNote;
import it.feio.android.omninotes.Screen.Trash;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class HamburgerTest extends StartTheApplication {
    @Test
    public void HamburgerValidationTest() {
        // Step 1. Click on Add button
        Home.clickAddButton();

        // Step 2. Click on Text Note button
        TextNote.clickTextNoteButton();

        // Step 3. Add note with title "Pay the bills"
        TextNote.typePayTheBillsText();

        // Step 4. Click return button
        TextNote.clickReturnButton();

        // Step 5. Delete (swipe) the note with title "Pay the bills"
        TextNote.deleteTheNote();

        // Step 6. Click on hamburger
        TextNote.clickOnHamburgerButton();

        // Expected Result: The button with name Archive is displayed and has sibling the button with name Notes
        assertTrue("The button with name\"Archive\" is NOT displayed.", Home.isArchiveTextVisible());

        // Step 7. Click on Archive button
        Home.clickOnArchiveButton();

        // Expected Result: Note with title "Pay the bills" is displayed"
        assertTrue("Note with title \"Pay the bills\" is NOT displayed.", Archive.isPayTheBillsVisible());

        // Step 8. Delete (swipe) the note with title "Pay the bills"
        TextNote.deleteTheNote();

        // Step 9. Click on hamburger
        TextNote.clickOnHamburgerButton();

        // Expected Result: The button with name Trash is displayed below the button with name Notes -> PASS

        // Expected Result: The button with name Archive is NOT displayed
        assertFalse(" The button with name \"Archive\" is displayed.", Home.isArchiveTextVisible());

        // Step 10. Click on Trash button
        Home.clickOnTrashButton();

        // Expected Result: Note with title "Pay the bills" is displayed"
        assertFalse("Note with title \"Pay the bills\" is NOT displayed.", Trash.isPayTheBillsVisible());

        // Expected Result: List View has one child

        // Step 11. Click More option
        Trash.clickMoreOptionsButton();

        // Step 12. Click Empty Trash button
        Trash.clickEmptyTrashButton();

        // Step 13. Click Button with text OK
        Trash.clickTheConfirmButton();

        // Expected Result: Note with title "Pay the bills" is NOT displayed"
        assertFalse("Note with title \"Pay the bills\" is displayed.", Trash.isPayTheBillsVisible());
    }
}
