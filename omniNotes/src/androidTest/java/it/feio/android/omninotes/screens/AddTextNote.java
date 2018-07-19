package it.feio.android.omninotes.screens;

import android.view.View;

import org.hamcrest.Matcher;

import it.feio.android.omninotes.R;
import it.feio.android.omninotes.helpers.Constants;
import it.feio.android.omninotes.helpers.Matchers;
import it.feio.android.omninotes.helpers.Methods;

import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.core.AllOf.allOf;

public class AddTextNote {

    public static void clickTitleContainer() {
        Methods.performClick(withId(R.id.detail_title));
    }

    public static void typeDoctorAppointment() {
        Methods.typeSomeText(withId(R.id.detail_title), Constants.DOCTOR_APPOINTMENT);
    }

    public static void clickContentContainer() {
        Methods.performClick(withId(R.id.detail_content));
    }

    public static void typeDateAndTime() {
        Methods.typeSomeText(withId(R.id.detail_content), Constants.TUESDAY_17_JUL_2018_18_30);
    }

    public static void clickAddReminder() {
        Methods.performClick(withId(R.id.datetime));
    }

    public static void clickDone() {
        Methods.performClick(withId(R.id.done));
    }

    public static boolean isTimePickerDisplayed() {
        return Methods.isObjectDisplayed(withId(R.id.time_picker_dialog));
    }

    public static void clickDoneButton() {
        Methods.performClick(withId(R.id.done_button));
    }

    public static void enableRepeatWeekly() {
        Methods.performClick(withId(R.id.repeat_switch));
    }

    public static boolean isWeekNoRightOfEveryText() {
        return Methods.isFirstObjectRightOfSecondObject(withId(R.id.interval), withId(R.id.intervalPreText));
    }

    public static boolean isWeekNoLeftOfWeekText() {
        return Methods.isFirstObjectLeftOfSecondObject(withId(R.id.interval), withId(R.id.intervalPostText));
    }

    public static void clickFriday() {
        Methods.performClick(Matchers.nthChildOf(withId(R.id.weekGroup2), 1));
    }

    public static void clickBackButton() {
        Methods.performClick(withContentDescription(Constants.DRAWER_OPEN));
    }

    public static boolean isContentBoxDescendantOfLinearLayout() {
        Matcher<View> addReminder = allOf(withId(R.id.detail_content), isDescendantOfA(withParent(withParent(withParent(withId(R.id.content_wrapper))))));
        return Methods.isObjectDisplayed(addReminder);
    }

    public static boolean isAddReminderDescendantOfLinearLayout() {
        Matcher<View> addReminder = allOf(withId(R.id.datetime), isDescendantOfA(withId(R.id.reminder_layout)));
        return Methods.isObjectDisplayed(addReminder);
    }

    public static boolean isContentParentSiblingWithAddReminderParent() {
        Matcher<View> contentSiblingAddReminder = allOf(withChild(withId(R.id.detail_content)), hasSibling(withId(R.id.reminder_layout)));
        return Methods.isObjectDisplayed(contentSiblingAddReminder);
    }

    public static void clickOnADay() {
        Matchers.clickXYCoordinates(900, 1800);
    }
}