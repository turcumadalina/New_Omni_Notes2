package it.feio.android.omninotes.tests;

import org.junit.Test;

import it.feio.android.omninotes.helpers.EspressoTestBase;

public class ToolbarValidationTest extends EspressoTestBase {

    @Test
    public void toolbarValidation() {

        // Verify: Menu_Sort is displayed between menu_search and more option.

        // Step: Add 5 items (1 of them with title "My note").

        // Verify: In the fragment_container there are 5 items.

        // Step: On toolbar, search for the item with text "My note".

        // Verify: Item with text "My note" is displayed.

        // Step: Click return button.

        // Verify: All 5 items are displayed.

        // Step: Click on the item with text " My Note" and move it to trash (on more option click on "Trash").

        // Verify: Item with text " My Note" is not displayed.
    }
}
