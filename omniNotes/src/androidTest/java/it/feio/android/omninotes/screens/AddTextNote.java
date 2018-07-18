package it.feio.android.omninotes.screens;

import it.feio.android.omninotes.R;
import it.feio.android.omninotes.helpers.Constants;
import it.feio.android.omninotes.helpers.Matchers;
import it.feio.android.omninotes.helpers.Methods;

import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

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

    public static boolean isContentDescendantOfLinearLayout() {
        return Methods.isFirstObjectDescendantOfSecondObject(Matchers.nthChildOf(Matchers.nthChildOf(withId(R.id.content_wrapper),
                0), 1), Matchers.nthChildOf(Matchers.nthChildOf(Matchers.nthChildOf
                (withId(R.id.content_wrapper), 0), 1), 0));
    }

    public static boolean isAddReminderDescendantOfLinearLayout() {
        return Methods.isFirstObjectDescendantOfSecondObject(Matchers.nthChildOf(Matchers.nthChildOf(withId(R.id.content_wrapper),
                0), 1), Matchers.nthChildOf(Matchers.nthChildOf(Matchers.nthChildOf
                (withId(R.id.content_wrapper), 0), 1), 1));
    }

    public static boolean isContentSiblingWithAddReminder() {
        return Methods.isFirstObjectSiblingOfSecondObject(Matchers.nthChildOf(Matchers.nthChildOf(Matchers.nthChildOf
                (withId(R.id.content_wrapper), 0), 1), 0), Matchers.nthChildOf
                (Matchers.nthChildOf(Matchers.nthChildOf(withId(R.id.content_wrapper), 0), 1), 1));
    }

    public static void clickOnADay() {
        Matchers.clickXYCoordinates(900, 1800);
    }
}