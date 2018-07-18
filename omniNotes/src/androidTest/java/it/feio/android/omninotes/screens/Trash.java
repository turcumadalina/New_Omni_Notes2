package it.feio.android.omninotes.screens;

import it.feio.android.omninotes.R;
import it.feio.android.omninotes.helpers.Constants;
import it.feio.android.omninotes.helpers.Mathers;
import it.feio.android.omninotes.helpers.Methods;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class Trash {

    public static boolean isNoteWithTitlePayTheBillsDisplayed() {
        return Methods.isUIObjectIsDisplayed(withText(Constants.PAY_THE_BILLS));
    }

    public static boolean isListViewWithOneChild() {
        return Mathers.getListViewChildCount(withId(R.id.list)) == 1;
    }
}
