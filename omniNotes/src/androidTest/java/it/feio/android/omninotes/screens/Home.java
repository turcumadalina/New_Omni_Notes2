package it.feio.android.omninotes.screens;

import it.feio.android.omninotes.R;
import it.feio.android.omninotes.helpers.Constants;
import it.feio.android.omninotes.helpers.EspressoMatchers;
import it.feio.android.omninotes.helpers.HelpersMethods;

import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

public class Home {

    // This is for Hamburger functionality test
    public static void clickAddButton() {
        HelpersMethods.clickUIElement(withId(R.id.fab_expand_menu_button));
    }

    public static void clickTextNoteButton() {
        HelpersMethods.clickUIElement(withId(R.id.fab_note));
    }

    public static void addPayTheBillsNoteTitle() {
        HelpersMethods.typeItemText(withId(R.id.detail_title), Constants.PAY_THE_BILLS);
    }

    public static void addPayBillsNoteContent() {
        HelpersMethods.addItemsContent(withId(R.id.detail_content), 4);
    }

    public static void clickReturnButton() {
        HelpersMethods.clickUIElement(withContentDescription(Constants.DRAWER_OPEN));
    }

    public static void deleteNoteWithTitlePayTheBills() {
        HelpersMethods.deleteUIItem(withText(Constants.PAY_THE_BILLS));
    }

    public static void clickOnHamburgerButton() {
        HelpersMethods.clickUIElement(withContentDescription(Constants.DRAWER_OPEN));
    }

    public static boolean isNoteContentTextLines() {
        return HelpersMethods.isUIObjectDisplayed(allOf(withId(R.id.note_content), EspressoMatchers.withNumberOfTextLines(2)));
    }

    public static int getNoOfTextLines() {
        return EspressoMatchers.getNoOfTextLines(withId(R.id.note_content));
    }

    // This is for Appointement details test
    public static boolean isImageWithNothingHereTextDisplayed() {
        return HelpersMethods.isUIObjectDisplayed(withId(R.id.empty_list));
    }
}