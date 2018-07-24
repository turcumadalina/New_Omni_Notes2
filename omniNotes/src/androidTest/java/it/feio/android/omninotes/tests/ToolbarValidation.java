package it.feio.android.omninotes.tests;

import org.junit.Test;

import it.feio.android.omninotes.helpers.EspressoTestBase;
import it.feio.android.omninotes.screens.Home;
import it.feio.android.omninotes.screens.TextNote;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class ToolbarValidation extends EspressoTestBase {

    @Test
    public void testToolbarValidation() {
        // Verify: Menu_Sort is displayed between menu_search and more option.
        assertTrue("Sort button is not on the right of the Search button", Home.isSortButtonOnTheRightOfSearchButton());
        assertTrue("Sort button is not on the left of the More options button", Home.isSortButtonOnTheLeftOfMoreOptionButton());

        // Step: Add 5 items (1 of them with title "My note").
        Home.add5Items();

        // Verify: In the list there are 5 items.
        assertEquals("ListView has more/less then 5 items", 5, Home.isListViewWith5Items());

        // Step: On toolbar, search for the item with text "My note".
        Home.searchTheNoteWithMyNoteTitle();

        // Verify: Item with text "My note" is displayed.
        assertTrue("Note with title My note is not displayed", Home.isNoteWithTitleMyNoteDisplayed());

        // Step: Click return button.
        Home.clickBackButton();

        // Verify: All 5 items are displayed.


        // Step: Click on the item with text " My Note" and move it to trash (on more option click on "Trash").


        // Verify: Item with text " My Note" is not displayed.

    }
}