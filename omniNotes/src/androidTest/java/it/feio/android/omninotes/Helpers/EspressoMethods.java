package it.feio.android.omninotes.Helpers;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.view.View;
import android.widget.ListView;

import org.hamcrest.Matcher;

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
}