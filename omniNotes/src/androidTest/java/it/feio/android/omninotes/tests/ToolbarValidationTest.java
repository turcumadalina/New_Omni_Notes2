package it.feio.android.omninotes.tests;

import org.junit.Test;

import it.feio.android.omninotes.helpers.EspressoTestBase;
import it.feio.android.omninotes.screens.AddTextNote;
import it.feio.android.omninotes.screens.Home;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class ToolbarValidationTest extends EspressoTestBase {

    @Test
    public void toolbarValidation() throws InterruptedException {

        // Verify: Menu_Sort is displayed between menu_search and more option.
        assertTrue("Menu_Sort is displayed between menu_search and more option.", Home.isMenuSortLeftOfMoreOptions() && Home.isMenuSortRightOfSearch());

        // Step: Add 5 items (1 of them with title "My note").
        Home.add5ItemsOneIsASpecialItem();

        // Verify: In the list there are 5 items.
        assertEquals("In the list there are not 5 items", 5, Home.getListNoOfChildren());

        // Step: On toolbar, search for the item with text "My note".
        AddTextNote.searchForMyNote();

        // Verify: Item with text "My note" is displayed.
        assertTrue("Item with text \"My note\" is displayed.", AddTextNote.isMyNoteDisplayed());

        // Step: Click return button.
        AddTextNote.clickCollapseButton();

        // Verify: All 5 items are displayed.


        // Step: Click on the item with text " My Note" and move it to trash (on more option click on "Trash").
        AddTextNote.clickOnMyNote();
        AddTextNote.clickMoreOptions();
        AddTextNote.clickTrash();

        // Verify: Item with text " My Note" is not displayed.
        assertFalse("Item with text \"My note\" is displayed.", AddTextNote.isMyNoteDisplayed());
    }
}
