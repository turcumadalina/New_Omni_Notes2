package it.feio.android.omninotes.helpers;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.CoordinatesProvider;
import android.support.test.espresso.action.GeneralClickAction;
import android.support.test.espresso.action.Press;
import android.support.test.espresso.action.Tap;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import it.feio.android.omninotes.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class EspressoMatchers {

    public static Matcher<View> nthChildOf(final Matcher<View> parentMatcher, final int childPosition) {
        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText(Constants.WITH + " " + childPosition + " " + Constants.CHILD_VIEW_OF_TYPE_PARENTMATCHER);
            }

            @Override
            public boolean matchesSafely(View view) {
                if (!(view.getParent() instanceof ViewGroup)) {
                    return parentMatcher.matches(view.getParent());
                }
                ViewGroup group = (ViewGroup) view.getParent();
                return parentMatcher.matches(view.getParent()) && group.getChildAt(childPosition).equals(view);
            }
        };
    }

    public static void clickXYCoordinates(int x, int y) {
        onView(EspressoMatchers.nthChildOf((EspressoMatchers.nthChildOf(withId(R.id.animator), 0)), 0)).perform(new GeneralClickAction(Tap.SINGLE, new CoordinatesProvider() {
            @Override
            public float[] calculateCoordinates(View view) {
                return new float[]{x, y};
            }
        }, Press.FINGER));
    }

    public static Matcher<View> withFontSize(final float expectedSize) {
        return new BoundedMatcher<View, View>(View.class) {

            @Override
            public boolean matchesSafely(View target) {
                if (!(target instanceof TextView)) {
                    return false;
                }
                TextView targetEditText = (TextView) target;
                float pixels = targetEditText.getTextSize();
                float actualSize = pixels / target.getResources().getDisplayMetrics().scaledDensity;
                return Float.compare(actualSize, expectedSize) == 0;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("with fontSize: ");
                description.appendValue(expectedSize);
            }
        };
    }

    public static int getTextSize(final Matcher<View> matcher) {
        final int[] stringHolder = new int[1];
        onView(matcher).perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(TextView.class);
            }

            @Override
            public String getDescription() {
                return "getting textSize from a TextView";
            }

            @Override
            public void perform(UiController uiController, View view) {
                TextView tv = (TextView) view;
                float pixels = tv.getTextSize();
                float scaledPixels = pixels / view.getResources().getDisplayMetrics().scaledDensity;
                stringHolder[0] = (int) scaledPixels;
            }
        });
        return stringHolder[0];
    }

    public static int getTextLineNo(final Matcher<View> matcher) {
        final int[] stringHolder = new int[1];
        onView(matcher).perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(TextView.class);
            }

            @Override
            public String getDescription() {
                return "getting text lines from a TextView";
            }

            @Override
            public void perform(UiController uiController, View view) {
                TextView tv = (TextView) view;
                int lineNo = tv.getLineCount();
                stringHolder[0] = lineNo;
            }
        });
        return stringHolder[0];
    }

    public static TypeSafeMatcher<View> isTextInLines(final int lines) {
        return new TypeSafeMatcher<View>() {
            @Override
            protected boolean matchesSafely(View item) {
                return ((TextView) item).getLineCount() == lines;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("isTextInLines");
            }
        };
    }
}