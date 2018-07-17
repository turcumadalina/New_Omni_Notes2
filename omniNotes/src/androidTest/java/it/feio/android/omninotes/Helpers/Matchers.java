package it.feio.android.omninotes.Helpers;

import android.view.View;

import org.hamcrest.Matcher;

import it.feio.android.omninotes.R;

import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class Matchers {
    public static Matcher<View> emptyList = withId(R.id.empty_list);
    public static Matcher<View> addToDoButton = withId(R.id.fab_expand_menu_button);
    public static Matcher<View> cameraImage = withId(R.id.fab_camera);
    public static Matcher<View> checkListImage = withId(R.id.fab_checklist);
    public static Matcher<View> textNoteButton = withId(R.id.fab_note);
    public static Matcher<View> reminderSet = withId(R.id.card_layout);
    public static Matcher<View> titleContainer = withId(R.id.detail_title);
    public static Matcher<View> contentContainer = withId(R.id.detail_content);
    public static Matcher<View> addReminder = withId(R.id.datetime);
    public static Matcher<View> done = withId(R.id.done);
    public static Matcher<View> timePicker = withId(R.id.time_picker_dialog);
    public static Matcher<View> doneButton = withId(R.id.done_button);
    public static Matcher<View> repeatWeekly = withId(R.id.repeat_switch);
    public static Matcher<View> week2 = withId(R.id.weekGroup2);
    public static Matcher<View> forever = withId(R.id.endGroup);
    public static Matcher<View> week = withId(R.id.weekGroup);
    public static Matcher<View> everyWeek = withId(R.id.freqSpinner);
    public static Matcher<View> contentWrapper = withId(R.id.content_wrapper);


}
