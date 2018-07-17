package it.feio.android.omninotes.Screen;

import it.feio.android.omninotes.Helpers.Methods;
import it.feio.android.omninotes.R;

import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class Search {
    public static void clickSearchReturn() {
        Methods.clickAction(withContentDescription("Collapse"));
    }

    public static boolean isMyNoteTextVisible() {
        return Methods.isVisible(withId(R.id.note_title));
    }
}
