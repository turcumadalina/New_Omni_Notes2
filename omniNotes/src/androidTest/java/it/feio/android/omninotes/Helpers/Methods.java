package it.feio.android.omninotes.Helpers;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.security.SecureRandom;

import it.feio.android.omninotes.R;
import it.feio.android.omninotes.Screen.TextNote;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.PositionAssertions.isLeftOf;
import static android.support.test.espresso.assertion.PositionAssertions.isRightOf;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class Methods extends Matchers {
    public static boolean isVisible(Matcher<View> matcher) {
        try {
            onView(matcher).check(matches(isDisplayed()));
            return true;
        } catch (Exception e) {
            // View is not in hierarchy
            return false;
        }
    }

    public static void clickAction(Matcher<View> matcher) {
        onView(matcher).perform(Matchers.clickActionMatcher());
    }

    public static boolean isFirstMatcherToTheLeftOfSecondMatcher(Matcher<View> matcher1, Matcher<View> matcher2) {
        try {
            onView(matcher1).check(isLeftOf(matcher2));
            return true;
        } catch (NoMatchingViewException e) {
            // View is not in hierarchy
            return false;
        }
    }

    public static boolean isFirstMatcherToTheRightOfSecondMatcher(Matcher<View> matcher1, Matcher<View> matcher2) {
        try {
            onView(matcher1).check(isRightOf(matcher2));
            return true;
        } catch (NoMatchingViewException e) {
            // View is not in hierarchy
            return false;
        }
    }

    private static String getRandomString(int newItemStringLength) {
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(newItemStringLength);

        for (int i = 0; i < newItemStringLength; i++) {
            sb.append(AB.charAt(random.nextInt(AB.length())));
        }

        return sb.toString();
    }

    private static int getChildCount(Matcher<View> matcher) {
        final int[] count = {0};
        Espresso.onView(matcher).perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return ViewMatchers.isAssignableFrom(RecyclerView.class);
            }

            @Override
            public String getDescription() {
                return Constants.childCount;
            }

            @Override
            public void perform(UiController uiController, View view) {
                RecyclerView rv = (RecyclerView) view;
                count[0] = rv.getChildCount();
            }
        });
        return count[0];
    }

    public static boolean checkTheNumberOfItems(Matcher<View> matcher, int numberOfItems) {
        if (getChildCount(matcher) == numberOfItems) {
            return true;
        } else {
            return false;
        }
    }

    public static Matcher<View> childAtPosition(final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText(Constants.childPosition + position + Constants.parent);
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    public static void deleteSpecificItem(Matcher<View> matcher, int positionOfDeletedItem) {
        onView(childAtPosition(matcher, positionOfDeletedItem)).perform(Matchers.swipeLeftMatcher());
    }

    public static void typeNewItemAction(int xItemsAdded, String specificItem, int xPositionToAddNewText) {
        for (int i = 0; i <= xItemsAdded; i++) {
            if (i == xPositionToAddNewText) {
                TextNote.clickAddButton();
                TextNote.clickTextNoteButton();
                TextNote.clickTitleBox();
                Matchers.titleMatcher.perform(typeText(specificItem));
                TextNote.clickContentBox();
                Matchers.contentMatcher.perform(typeText(getRandomString(5)));
                TextNote.clickReturnButton();
            } else {
                TextNote.clickAddButton();
                TextNote.clickTextNoteButton();
                TextNote.clickTitleBox();
                onView(withId(R.id.detail_title)).perform(typeText(getRandomString(5)));
                TextNote.clickContentBox();
                onView(withId(R.id.detail_content)).perform(typeText(getRandomString(5)));
                TextNote.clickReturnButton();
            }
        }

    }

    public static void clickTheSearchButtonAndroid(Matcher<View> matcher) {
        onView(matcher).perform(Matchers.searchButtonAndroidMatcher());
    }
}
