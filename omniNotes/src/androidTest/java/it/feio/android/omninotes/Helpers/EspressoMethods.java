package it.feio.android.omninotes.Helpers;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class EspressoMethods {

    public static int getChildCountFromListView(Matcher<View> matcher) {
        final int[] count = {0};
        Espresso.onView(matcher).perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return ViewMatchers.isAssignableFrom(ListView.class);
            }

            @Override
            public String getDescription() {
                return Constants.GETTING_CHILD_COUNT;
            }

            @Override
            public void perform(UiController uiController, View view) {
                ListView lv = (ListView) view;
                count[0] = lv.getChildCount();
            }
        });
        return count[0];
    }

    public static Matcher<View> hasBoldText() {
        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("has bold text");
            }

            @Override
            public boolean matchesSafely(View view) {
                if (view instanceof TextView) {
                    TextView tv = (TextView) view;
                    return tv.getTypeface().isBold();
                }
                return false;
            }
        };
    }
}