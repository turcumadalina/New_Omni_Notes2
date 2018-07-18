package it.feio.android.omninotes.helpers;

import android.view.View;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.PositionAssertions.isAbove;
import static android.support.test.espresso.assertion.PositionAssertions.isBelow;
import static android.support.test.espresso.assertion.PositionAssertions.isLeftOf;
import static android.support.test.espresso.assertion.PositionAssertions.isRightOf;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;

public class Methods {

    public static boolean isObjectDisplayed(Matcher<View> matcher) {
        try {
            onView(matcher).check(matches(isDisplayed()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isObjectClickable(Matcher<View> matcher) {
        try {
            onView(matcher).check(matches(isClickable()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isFirstObjectAboveSecondObject(Matcher<View> matcher, Matcher<View> matcher2) {
        try {
            onView(matcher).check(isAbove(matcher2));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isFirstObjectBelowSecondObject(Matcher<View> matcher, Matcher<View> matcher2) {
        try {
            onView(matcher).check(isBelow(matcher2));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isFirstObjectRightOfSecondObject(Matcher<View> matcher, Matcher<View> matcher2) {
        try {
            onView(matcher).check(isRightOf(matcher2));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isFirstObjectLeftOfSecondObject(Matcher<View> matcher, Matcher<View> matcher2) {
        try {
            onView(matcher).check(isLeftOf(matcher2));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void performClick(Matcher<View> matcher) {
        onView(matcher).perform(click());
    }

    public static void typeSomeText(Matcher<View> matcher, String textInput) {
        onView(matcher).perform(typeText(textInput));
    }
}
