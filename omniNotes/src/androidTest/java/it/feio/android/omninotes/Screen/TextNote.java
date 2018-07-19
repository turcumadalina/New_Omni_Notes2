package it.feio.android.omninotes.Screen;

import it.feio.android.omninotes.Helpers.Constants;
import it.feio.android.omninotes.Helpers.HelpersMethods;
import it.feio.android.omninotes.R;

import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class TextNote {
    public static void clickAddButton() {
        HelpersMethods.clickAction(withId(R.id.fab_expand_menu_button));
    }

    public static void clickTextNoteButton() {
        HelpersMethods.clickAction(withId(R.id.fab_note));
    }

    public static void clickTitleBox() {
        HelpersMethods.clickAction(withId(R.id.detail_title));
    }

    public static void clickContentBox() {
        HelpersMethods.clickAction(withId(R.id.detail_content));
    }

    public static void clickReturnButton() {
        HelpersMethods.clickAction(withContentDescription(Constants.DRAWER_OPEN));
    }

    public static void clickMoreOptionsButton() {
        HelpersMethods.clickAction(withContentDescription(Constants.MORE_OPTIONS));
    }

    public static void clickTrashButton() {
        HelpersMethods.clickAction(withText(R.string.trash));
    }
}