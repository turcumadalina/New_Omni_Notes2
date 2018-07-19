package it.feio.android.omninotes.screens;

import it.feio.android.omninotes.R;
import it.feio.android.omninotes.helpers.Constants;
import it.feio.android.omninotes.helpers.Mathers;
import it.feio.android.omninotes.helpers.Methods;

import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class Trash {

    public static boolean isNoteWithTitlePayTheBillsDisplayed() {
        return Methods.isUIObjectIsDisplayed(withText(Constants.PAY_THE_BILLS));
    }

    public static boolean isListViewWithOneChild() {
        return Mathers.getListViewChildCount(withId(R.id.list)) == 1;
    }

    public static void clickOnMoreOptionButton() {
        Methods.clickUIElement(withContentDescription("More options"));
    }

    public static void clickOnEmptyTrashButton() {
        Methods.clickUIElement(withText(R.string.empty_trash));
    }

    public static void clickOkButton() {
        Methods.clickUIElement(withId(R.id.buttonDefaultPositive));
    }
}
