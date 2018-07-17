package it.feio.android.omninotes.Screen;

import it.feio.android.omninotes.Helpers.Constants;
import it.feio.android.omninotes.Helpers.Methods;
import it.feio.android.omninotes.R;

import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class TextNote {

    public static void clickAddButton() {
        Methods.clickAction(withId(R.id.fab_expand_menu_button));
//        Matchers.clickActionMatcher();
    }

    public static void clickTextNoteButton() {
        Methods.clickAction(withId(R.id.fab_note));
    }

    public static void clickTitleBox() {
        Methods.clickAction(withId(R.id.detail_title));
    }

    public static void clickContentBox() {
        Methods.clickAction(withId(R.id.detail_content));
    }

    public static void clickReturnButton() {
        Methods.clickAction(withContentDescription(Constants.returnContentDescription));
    }
}
