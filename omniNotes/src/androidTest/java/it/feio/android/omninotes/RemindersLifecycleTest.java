package it.feio.android.omninotes;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.startsWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class RemindersLifecycleTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void remindersLifecycle() {
        ViewInteraction viewInteraction = onView(allOf(withId(R.id.fab_expand_menu_button), withParent(withId(R.id.fab)), isDisplayed()));
        viewInteraction.perform(click());

        ViewInteraction floatingActionButton = onView(allOf(withId(R.id.fab_note), withParent(withId(R.id.fab)), isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction linearLayout = onView(withId(R.id.reminder_layout));
        linearLayout.perform(scrollTo(), click());

        ViewInteraction appCompatButton = onView(allOf(withId(R.id.done), withText(R.string.done_label), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatButton2 = onView(allOf(withId(R.id.done_button), withText(R.string.done_label), isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatButton3 = onView(allOf(withId(R.id.done), withText(R.string.save_label), isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction textView = onView(withId(R.id.datetime));
        textView.check(matches(withText(startsWith(OmniNotes.getAppContext().getResources().getString(R.string.alarm_set_on)))));
    }
}
