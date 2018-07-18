package it.feio.android.omninotes.screens;

import it.feio.android.omninotes.R;
import it.feio.android.omninotes.helpers.Methods;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class Home {
    public static boolean isNothingHereDisplayed() {
        return Methods.isObjectDisplayed(withId(R.id.empty_list));
    }

    public static boolean isNothingHereClickable() {
        return Methods.isObjectClickable(withId(R.id.empty_list));
    }

    public static boolean isAddButtonDisplayed() {
        return Methods.isObjectDisplayed(withId(R.id.fab_expand_menu_button));
    }

    public static boolean isAddButtonClickable() {
        return Methods.isObjectClickable(withId(R.id.fab_expand_menu_button));
    }

    public static void clickAddButton() {
        Methods.performClick(withId(R.id.fab_expand_menu_button));
    }

    public static boolean isCheckListAboveTextNote() {
        return Methods.isFirstObjectAboveSecondObject(withId(R.id.fab_checklist), withText("Text note"));
    }

    public static boolean isCheckListBelowPhoto() {
        return Methods.isFirstObjectBelowSecondObject(withId(R.id.fab_checklist), withText("Photo"));
    }

    public static boolean isPicturePhotoAbovePictureCheckList() {
        return Methods.isFirstObjectAboveSecondObject(withId(R.id.fab_camera), withId(R.id.fab_checklist));
    }

    public static void clickTextNoteButton() {
        Methods.performClick(withId(R.id.fab_note));
    }

    public static boolean isReminderSetDisplayed() {
        return Methods.isObjectDisplayed(withId(R.id.card_layout));
    }
}