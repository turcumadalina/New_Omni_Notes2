package it.feio.android.omninotes.Screen;

import it.feio.android.omninotes.Helpers.Constants;
import it.feio.android.omninotes.Helpers.HelpersMethods;
import it.feio.android.omninotes.R;

import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

public class Home {
    public static boolean isMenuSortInTheRightOfSearch() {
        return HelpersMethods.isFirstMatcherToTheRightOfSecondMatcher(withId(R.id.menu_sort), withId(R.id.menu_search));
    }

    public static boolean isMenuSortInTheLeftOfMoreOptions() {
        return HelpersMethods.isFirstMatcherToTheLeftOfSecondMatcher(withId(R.id.menu_sort), withContentDescription(Constants.MORE_OPTIONS));
    }

    public static void clickSearchButtonAndSearch() {
        HelpersMethods.clickAction(withId(R.id.menu_search));
    }

    public static boolean isMyNoteTextVisible() {
        return HelpersMethods.isVisible(allOf(withId(R.id.note_title), withText(Constants.MY_NOTE), isCompletelyDisplayed()));
    }

    public static void clickMyNoteItemFromTheList() {
        HelpersMethods.clickAction(withText(Constants.MY_NOTE));
    }

    public static void clickSearchButtonAndroid() {
        HelpersMethods.clickTheSearchButtonAndroid(withId(R.id.search_src_text));
    }
}






