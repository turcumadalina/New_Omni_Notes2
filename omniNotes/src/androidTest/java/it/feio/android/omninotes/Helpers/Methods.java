package it.feio.android.omninotes.Helpers;

import android.support.test.espresso.AppNotIdleException;
import android.support.test.espresso.NoMatchingRootException;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import junit.framework.AssertionFailedError;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.PositionAssertions.isBelow;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;

public class Methods {

    public static void clickUIElement(Matcher<View> matcher) {
        onView(matcher).perform(click());
    }

    public static void typeItemText(Matcher<View> matcher, String textToBeTyped) {
        onView(matcher).perform(typeText(textToBeTyped));
    }

    public static boolean isUIObjectIsDisplayed(Matcher<View> matcher) {
        try {
            onView(matcher).check(matches(isCompletelyDisplayed()));
            return true;
        } catch (NoMatchingViewException | AppNotIdleException | AssertionFailedError | NoMatchingRootException e) {
            return false;
        }
    }

    public static void deleteUIItem(Matcher<View> matcher) {
        onView(matcher).perform(swipeLeft());
    }

    public static boolean isUIObjectBelowAnotherObject(Matcher<View> matcher1, Matcher<View> matcher2) {
        try {
            onView(matcher1).check(isBelow(matcher2));
            return true;
        } catch (NoMatchingViewException | AppNotIdleException | AssertionFailedError | NoMatchingRootException e) {
            return false;
        }
    }

    public static int getListViewChildCount(Matcher<View> matcher) {
        final int[] count = {0};
        onView(matcher).perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return ViewMatchers.isAssignableFrom(RecyclerView.class);
            }

            @Override
            public String getDescription() {
                return "getting child count";
            }

            @Override
            public void perform(UiController uiController, View view) {
                RecyclerView rv = (RecyclerView) view;
                count[0] = rv.getChildCount();
            }
        });
        return count[0];
    }
}
