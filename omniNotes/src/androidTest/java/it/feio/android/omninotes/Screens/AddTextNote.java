package it.feio.android.omninotes.Screens;

import android.view.View;

import org.hamcrest.Matcher;

import it.feio.android.omninotes.Helpers.Matchers;
import it.feio.android.omninotes.Helpers.Methods;

import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;

public class AddTextNote {

    public static void clickTitleContainer() {
        Methods.performClick(Matchers.titleContainer);
    }

    public static void typeDoctorAppointment() {
        Methods.typeSomeText(Matchers.titleContainer, "Doctor appointment");
    }

    public static void clickContentContainer() {
        Methods.performClick(Matchers.contentContainer);
    }

    public static void typeDateAndTime() {
        Methods.typeSomeText(Matchers.contentContainer, "Tuesday, 17 Jul 2018, 18:30.");
    }

    public static void clickAddReminder() {
        Methods.performClick(Matchers.addReminder);
    }

    public static void clickDone() {
        Methods.performClick(Matchers.done);
    }

    public static boolean isTimePickerDisplayed() {
        return Methods.isObjectDisplayed(Matchers.timePicker);
    }

    public static void clickDoneButton() {
        Methods.performClick(Matchers.doneButton);
    }

    public static void enableRepeatWeekly() {
        Methods.performClick(Matchers.repeatWeekly);
    }

    public static boolean isWeek2AboveForever() {
        return Methods.isFirstObjectAboveSecondObject(Matchers.week2, Matchers.forever);
    }

    public static boolean isWeek1BelowRepeatWeekly() {
        return Methods.isFirstObjectBelowSecondObject(Matchers.week, Matchers.everyWeek);
    }

    public static void clickFriday() {
        Matcher<View> matcher = Methods.nthChildOf(Matchers.week2, 1);
        Methods.performClick(matcher);
    }

    public static void clickBackButton() {
        Methods.performClick(withContentDescription("drawer open"));
    }

    public static boolean isContentDescendantOfLinearLayout() {
        Matcher<View> matcher1 = Methods.nthChildOf(Matchers.contentWrapper, 0);
        Matcher<View> matcher2 = Methods.nthChildOf(matcher1, 1);
        Matcher<View> matcher3 = Methods.nthChildOf(matcher2, 0);
        return Methods.isFirstObjectDescendantOfSecondObject(matcher3, matcher2);
    }

    public static boolean isAddReminderDescendantOfLinearLayout() {
        Matcher<View> matcher1 = Methods.nthChildOf(Matchers.contentWrapper, 0);
        Matcher<View> matcher2 = Methods.nthChildOf(matcher1, 1);
        Matcher<View> matcher3 = Methods.nthChildOf(matcher2, 1);
        return Methods.isFirstObjectDescendantOfSecondObject(matcher3, matcher2);
    }

    public static boolean isContentSiblingWithAddReminder() {
        Matcher<View> matcher1 = Methods.nthChildOf(Matchers.contentWrapper, 0);
        Matcher<View> matcher2 = Methods.nthChildOf(matcher1, 1);
        Matcher<View> matcher3 = Methods.nthChildOf(matcher2, 1);
        Matcher<View> matcher4 = Methods.nthChildOf(matcher3, 1);
        return Methods.isFirstObjectSiblingOfSecondObject(matcher3, matcher4);
    }
}
