package it.feio.android.omninotes.Screens;

import it.feio.android.omninotes.Helpers.Constants;
import it.feio.android.omninotes.Helpers.Methods;
import it.feio.android.omninotes.R;

import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

public class Home {

    public static void clickAddButton() {
        Methods.clickUIElement(withId(R.id.fab_expand_menu_button));
    }

    public static void clickTextNoteButton() {
        Methods.clickUIElement(withId(R.id.fab_note));
    }

    public static void addPayTheBillsNote() {
        Methods.typeItemText(withId(R.id.detail_title), Constants.noteText);
    }

    public static void clickReturnButton() {
        Methods.clickUIElement(withContentDescription(Constants.returnButtonTextDescription));
    }

    public static void deleteNoteWithTitlePayTheBills() {
        Methods.deleteUIItem(withText(Constants.noteText));
    }

    public static void clickOnHamburgerButton() {
        Methods.clickUIElement(withContentDescription(Constants.hamburgerButtonTextDescription));
    }

    public static boolean isArchivebuttonDisplayedAndHasSiblingTheNoteButton() {
        return Methods.isUIObjectIsDisplayed(allOf(withText("Archive"), hasSibling(withText("Notes"))));
    }
}
