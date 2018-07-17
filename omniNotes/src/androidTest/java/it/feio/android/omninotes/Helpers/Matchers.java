package it.feio.android.omninotes.Helpers;

import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewInteraction;

import it.feio.android.omninotes.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class Matchers {
    public static ViewInteraction titleMatcher = onView(withId(R.id.detail_title));
    public static ViewInteraction contentMatcher = onView(withId(R.id.detail_content));
//    public static ViewInteraction addButtonMatcher = onView(withId(R.id.fab_expand_menu_button));
//    public static ViewInteraction textNoteSuggestivePictureMatcher = onView(withId(R.id.fab_note));
//    public static ViewInteraction titleBoxMatcher = onView(withId(R.id.detail_title));
//    public static ViewInteraction contentBoxMatcher = onView(withId(R.id.detail_content));
    public static ViewInteraction searchReturnButtonMatcher = onView(withContentDescription("Collapse"));
//    public static ViewInteraction myNoteTextMatcher = onView(withId(R.id.note_title));
//    public static ViewInteraction searchTextButtonMatcher = onView(withId(R.id.search_src_text));

    public static ViewAction searchButtonAndroidMatcher() {
        return pressImeActionButton();
    }

    public static ViewAction clickActionMatcher() {
        return click();
    }

    public static ViewAction swipeLeftMatcher() {
        return swipeLeft();
    }

    public static ViewAction typeRandomTextMatcher() {
        return typeText(Constants.myNoteText);
    }

//    public static ViewAssertion isRightOfMatcher() {
//        return isLeftOf();
//    }
}
