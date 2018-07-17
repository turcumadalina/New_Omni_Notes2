package it.feio.android.omninotes.Screen;

import it.feio.android.omninotes.Helpers.Constants;
import it.feio.android.omninotes.Helpers.Matchers;
import it.feio.android.omninotes.Helpers.Methods;
import it.feio.android.omninotes.R;

import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static it.feio.android.omninotes.Helpers.Matchers.typeRandomTextMatcher;
import static org.hamcrest.Matchers.allOf;

public class Home {
    public static boolean isMenuSortInTheRightOfSearch() {
        return Methods.isFirstMatcherToTheRightOfSecondMatcher(withId(R.id.menu_sort), withId(R.id.menu_search));
    }

    public static boolean isMenuSortInTheLeftOfMoreOptions() {
        return Methods.isFirstMatcherToTheLeftOfSecondMatcher(withId(R.id.menu_sort), withContentDescription("More options"));
    }

    public static boolean isTheCorrectNumberOfNotesInTheBox() {
        return Methods.checkTheNumberOfItems(withId(R.id.fragment_container), 5);
    }

    public static void clickSearchButtonAndSearch() {
        Methods.clickAction(withId(R.id.menu_search));
        Matchers.searchReturnButtonMatcher.perform(typeRandomTextMatcher());
    }

    public static boolean isMyNoteTextVisible() {
        return Methods.isVisible(allOf(withId(R.id.note_title), withText(Constants.myNoteText), isCompletelyDisplayed()));
    }

    public static void clickMyNoteItemFromTheList() {
        Methods.clickAction(withText(Constants.myNoteText));
    }

    public static void deleteSpecificItem() {
        Methods.deleteSpecificItem(withText(Constants.myNoteText), 4);
    }

    public static void clickSearchButtonAndroid() {
        Methods.clickTheSearchButtonAndroid(withId(R.id.search_src_text));
    }
}






