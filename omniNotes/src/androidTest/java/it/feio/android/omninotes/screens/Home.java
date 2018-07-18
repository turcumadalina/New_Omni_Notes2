package it.feio.android.omninotes.screens;

import it.feio.android.omninotes.R;
import it.feio.android.omninotes.helpers.Constants;
import it.feio.android.omninotes.helpers.Methods;

import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class Home {

    public static void clickAddButton() {
        Methods.clickUIElement(withId(R.id.fab_expand_menu_button));
    }

    public static void clickTextNoteButton() {
        Methods.clickUIElement(withId(R.id.fab_note));
    }

    public static void addPayTheBillsNote() {
        Methods.typeItemText(withId(R.id.detail_title), Constants.PAY_THE_BILLS);
    }

    public static void clickReturnButton() {
        Methods.clickUIElement(withContentDescription(Constants.DRAWER_OPEN));
    }

    public static void deleteNoteWithTitlePayTheBills() {
        Methods.deleteUIItem(withText(Constants.PAY_THE_BILLS));
    }

    public static void clickOnHamburgerButton() {
        Methods.clickUIElement(withContentDescription(Constants.DRAWER_OPEN));
    }
}