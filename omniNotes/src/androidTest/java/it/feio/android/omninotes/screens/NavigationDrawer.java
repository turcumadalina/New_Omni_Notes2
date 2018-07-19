package it.feio.android.omninotes.screens;

import android.widget.LinearLayout;

import it.feio.android.omninotes.R;
import it.feio.android.omninotes.helpers.Methods;

import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;

public class NavigationDrawer {

    public static boolean isArchiveButtonDisplayedAndHasSiblingTheNoteButton() {
        return Methods.isUIObjectIsDisplayed(allOf(withId(R.id.navigation_drawer),
                hasDescendant(allOf(instanceOf(LinearLayout.class), hasDescendant(allOf(withText(R.string.archive), withId(R.id.title))),
                        hasSibling(allOf(instanceOf(LinearLayout.class), hasDescendant(allOf(withText(R.string.title_item_list), withId(R.id.title)))))))));
    }

    public static void clickOnArchiveButton() {
        Methods.clickUIElement(withText(R.string.archive));
    }

//    public static boolean isButtonWithNameTrashDisplayedBelowTheButtonWithNameNotes() {
//        Matcher<View> trashMatcher = allOf(withId(R.id.drawer_nav_list), allOf(withChild(withId(R.id.title)), withText(R.string.trash_action))) ;
//        Matcher<View> notesMatcher = allOf(withId(R.id.drawer_nav_list), allOf(withChild(withId(R.id.title)), withText(R.string.title_item_list)));
//        return Methods.isUIObjectBelowAnotherObject(trashMatcher, notesMatcher);
//        return Methods.isUIObjectBelowAnotherObject(withText("Trash"), withText("Notes"));
//    }

//    public static boolean isArchiveButtonOnNavigationDrawer() {
//        return Methods.isUIObjectIsDisplayed(withText(R.string.archive));
//    }

    public static void clickOnTrashButton() {
        Methods.clickUIElement(withText(R.string.trash));
    }
}
