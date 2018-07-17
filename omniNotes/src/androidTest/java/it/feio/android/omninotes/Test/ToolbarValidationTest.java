package it.feio.android.omninotes.Test;


import org.junit.Test;

import it.feio.android.omninotes.Helpers.Constants;
import it.feio.android.omninotes.Helpers.Methods;
import it.feio.android.omninotes.Helpers.StartTheApplication;
import it.feio.android.omninotes.Screen.Home;
import it.feio.android.omninotes.Screen.Search;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class ToolbarValidationTest extends StartTheApplication {
    @Test
    public void ToolbarTest() {
        // Step: Start the app

        // Expected Result: Menu_Sort is displayed between menu_search and more option.
        assertTrue(Constants.myNoteTextNotVisibleRight, Home.isMenuSortInTheRightOfSearch());
        assertTrue(Constants.myNoteTextNotVisibleLeft, Home.isMenuSortInTheLeftOfMoreOptions());

        // Step: Add 5 items (1 of them with title "My note").
        Methods.typeNewItemAction(4, Constants.myNoteText, 4);

        // Expected Result: In the fragment_container there are 5 items.
        Home.isTheCorrectNumberOfNotesInTheBox();

        // Step:On toolbar, search for the item with text "My note".
        Home.clickSearchButtonAndSearch();
        Home.clickSearchButtonAndroid();

        // Expected Result: Item with text "My note" is displayed.
        assertTrue(Constants.myNoteTextNotVisible, Search.isMyNoteTextVisible());

        // Step: Click return button.
        Search.clickSearchReturn();

        // Expected Result: All 5 items are displayed.
        Home.isTheCorrectNumberOfNotesInTheBox();

        // Step: Click on the item with text " My Note" and move it to trash (on more option click on "Trash").
        Home.clickMyNoteItemFromTheList();
        Home.deleteSpecificItem();

        // Expected Result: Item with text " My Note" is not displayed.
        assertFalse("", Home.isMyNoteTextVisible());
    }
}
