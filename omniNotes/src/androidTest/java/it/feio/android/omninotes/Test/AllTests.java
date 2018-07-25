package it.feio.android.omninotes.Test;

import org.junit.Test;

import it.feio.android.omninotes.Helpers.EspressoMethods;
import it.feio.android.omninotes.Helpers.HelpersMethods;
import it.feio.android.omninotes.Helpers.StartTheApplication;
import it.feio.android.omninotes.R;
import it.feio.android.omninotes.Screen.Archive;
import it.feio.android.omninotes.Screen.Home;
import it.feio.android.omninotes.Screen.Search;
import it.feio.android.omninotes.Screen.TextNote;
import it.feio.android.omninotes.Screen.TimePiker;
import it.feio.android.omninotes.Screen.Trash;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class AllTests extends StartTheApplication {
    @Test
    public void ToolbarTest() {
        // Step: Start the app

        // Expected Result: Menu_Sort is displayed between menu_search and more option.
        assertTrue("MenuSort in not displayed in the right of Search.", Home.isMenuSortInTheRightOfSearch());
        assertTrue("MenuSort is not displayed in the left of MoreOptions.", Home.isMenuSortInTheLeftOfMoreOptions());

        // Step: Add 5 items (1 of them with title "My note").
        HelpersMethods.typeNewItemAction(4, 4);

        // Step: Verify if content has bold style.
        assertTrue("Content text has NOT bold style.", Home.isTextStyleBold());

        // Expected Result: In the fragment_container there are 5 items.
        assertEquals("There are more/less then 5 items in fragment container.", 5, EspressoMethods.getChildCountFromListView(withId(R.id.list)));

        // Step:On toolbar, search for the item with text "My note".
        Home.clickSearchButton();
        Search.typeMyNoteText();
        Home.clickSearchButtonAndroid();

        // Expected Result: Item with text "My note" is displayed.
        assertTrue("My note text is not displayed.", Search.isMyNoteTextVisible());

        // Step: Click return button.
        Search.clickSearchReturn();

        // Expected Result: All 5 items are displayed.
        assertEquals("There are more/less then 5 items in fragment container.", 5, EspressoMethods.getChildCountFromListView(withId(R.id.list)));

        // Step: Click on the item with text " My Note" and move it to trash (on more option click on "Trash").
        Home.clickMyNoteItemFromTheList();
        TextNote.clickMoreOptionsButton();
        TextNote.clickTrashButton();

        // Expected Result: Item with text " My Note" is not displayed.
        assertFalse("My note text is not displayed.", Home.isMyNoteTextVisible());
    }

    @Test
    public void AppointmentDetailsValidationTest() throws InterruptedException {
        // Step 1. Start the app.

        // Expected Result: Image with "Nothing here!" is displayed and clickable.
        assertTrue("Image with \"Nothing here!\" text is not displayed.", Home.isNothingHereTextVisible());
        assertTrue("Image with \"Nothing here!\" text is not clickable.", Home.isNothingHereTextClickable());

        // Expected Result: "Add" button is displayed and clickable.
        assertTrue("Add button is not displayed.", Home.isAddButtonVisible());
        assertTrue("Add button is not clickable.", Home.isAddButtonClickable());

        // Step 2. Click "Add" button
        Home.clickAddButton();

        // Expected Result: Test "Checklist" is between 2 other texts.
        assertTrue("Text \"Checklist\" is not above Text note text.", TextNote.isChecklistTextAboveTextNoteText());
        assertTrue("Text \"Checklist\" is not below Photo Text.", TextNote.isChecklistTextBelowPhotoText());

        // Expected Result: The suggestive picture of "Photo" text is above "Checklist" suggestive picture.
        assertTrue("The suggestive picture of \"Photo\" text is NOT above \"Checklist\" suggestive picture.", Home.isSuggestivePictureOfPhotoAboveChecklistSuggestivePicture());

        // Step 3. Click "Text note" button.
        TextNote.clickTextNoteButton();

        // Expected Result: "Content" and "Add reminder" are descendent of a LinearLayout and their parents are siblings.
        assertTrue("\"Content\" is NOT a descendant of a LinearLayout.", Home.isContentBoxDescendantOfALinearLayout());
        assertTrue("\"Add reminder\" is NOT a descendant of a LinearLayout.", Home.isAddReminderDescendantOfALinearLayout());
        assertTrue("The \"Content parent and the \"Add reminder\" parent are NOT siblings.", Home.isContentParentSiblingWithAddReminder());

        // Step 4. Click "Title" container and Type "Doctor appointment".
        TextNote.clickTitleBox();
        TextNote.typeAppointmentName();

        // Step 5. Click "Content" container and type " Tuesday, 17 Jul 2018, 18:30.".
        TextNote.clickContentBox();
        TextNote.typeAppointmentContent();

        // Step 6. Click on "Add reminder" and Add a reminder for the date from "Content" container.
        TimePiker.clickOnAddReminderButton();
        TimePiker.clickOnAnyDayFromTimePiker();

        // Step 7. Click "Done" button.
        TimePiker.clickOnTimePikerDoneButton();

        // Expected Result: The "Time picker" is displayed.
        assertTrue("The \"Time picker\" is NOT displayed.", TimePiker.isTimePikerVisible());

        // Step 8. Click "Done" button.
        TimePiker.clickOnClockDoneButton();

        // Step 9. Swipe the "repeat weekly" button.
        TimePiker.swipeRightTheRepeatWeeklyButton();

        // Expected Result: The number of weeks is between 2 texts.
        assertTrue("The interval is NOT in the left of \"week\" text.", TimePiker.isIntervalInTheLeftOfWeekText());
        assertTrue("The interval is NOT in the right of \"Every\" text.", TimePiker.isIntervalInTheRightOfEveryText());

        // Step 10. Click on "Friday" button.
        TimePiker.clickOnFridayButton();

        // Step 11. Click on "Done" button.
        TimePiker.clickOnTimePikerDoneButton();

        // Step 12. Press back.
        TextNote.clickReturnButton();
        Thread.sleep(2000);

        // Expected Result: Reminder set is displayed.
        assertTrue("Reminder set is NOT displayed.", TimePiker.reminderSetIsVisible());
    }

    @Test
    public void HamburgerValidationTest() throws InterruptedException {
        // Step 1. Click on Add button
        Home.clickAddButton();

        // Step 2. Click on Text Note button
        Home.clickTextNoteButton();

        // Step 3. Add note with title "Pay the bills"
        TextNote.typePayTheBillsText();

        // Step 4. Click return button
        TextNote.clickReturnButton();

        // Step 5. Delete (swipe) the note with title "Pay the bills"
        TextNote.deleteTheNote();

        // Step 6. Click on hamburger
        TextNote.clickHamburgerButton();

        // Expected Result: The button with name Archive is displayed and has sibling the button with name Notes
        assertTrue("The button with name\"Archive\" is NOT displayed.", Home.isArchiveTextVisible());
        assertTrue("The \"Archive\" button is NOT sibling with \"Notes\" button.", Home.isArchiveButtonSiblingWithNotesButton());

        // Step 7. Click on Archive button
        Home.clickArchiveButton();

        // Expected Result: Note with title "Pay the bills" is displayed"
        assertTrue("Note with title \"Pay the bills\" is NOT displayed.", Archive.isPayTheBillsTextVisible());

        // Step 8. Delete (swipe) the note with title "Pay the bills"
        Archive.deleteTheNote();

        //Wait 2 seconds
        Thread.sleep(2000);

        // Step 9. Click on hamburger
        Archive.clickHamburgerButton();

        // Expected Result: The button with name Trash is displayed below the button with name Notes -> PASS

        // Expected Result: The button with name Archive is NOT displayed
        assertFalse(" The button with name \"Archive\" is displayed.", Home.isArchiveTextVisible());

        // Step 10. Click on Trash button
        Home.clickTrashButton();

        // Expected Result: Note with title "Pay the bills" is displayed"
        assertTrue("Note with title \"Pay the bills\" is NOT displayed.", Trash.isPayTheBillsTextVisible());

        // Expected Result: List View has one child
        assertEquals("List view has more/less then one child.", 1, EspressoMethods.getChildCountFromListView(withId(R.id.list)));

        // Step 11. Click More option
        Trash.clickMoreOptionsButton();

        // Step 12. Click Empty Trash button
        Trash.clickEmptyTrashButton();

        // Step 13. Click Button with text OK
        Trash.clickTheConfirmButton();

        // Expected Result: Note with title "Pay the bills" is NOT displayed"
        assertFalse("Note with title \"Pay the bills\" is displayed.", Trash.isPayTheBillsTextVisible());
    }
}
