package it.feio.android.omninotes.screens;

import it.feio.android.omninotes.R;
import it.feio.android.omninotes.helpers.Constants;
import it.feio.android.omninotes.helpers.HelpersMethods;

import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class Home {

    public static void clickAddButton() {
        HelpersMethods.clickUIElement(withId(R.id.fab_expand_menu_button));
    }

    public static void clickTextNoteButton() {
        HelpersMethods.clickUIElement(withId(R.id.fab_note));
    }

    public static void addPayTheBillsNote() {
        HelpersMethods.typeItemText(withId(R.id.detail_title), Constants.PAY_THE_BILLS);
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
}