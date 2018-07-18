package it.feio.android.omninotes.screens;

import it.feio.android.omninotes.helpers.Constants;
import it.feio.android.omninotes.helpers.Methods;

import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class Archives {

    public static boolean isNoteWithTextPayTheBilsDisplayed() {
        return Methods.isUIObjectIsDisplayed(withText(Constants.PAY_THE_BILLS));
    }

    public static void removeNoteWithTitlePayTheBills() {
        Methods.deleteUIItem(withText(Constants.PAY_THE_BILLS));
    }
}
