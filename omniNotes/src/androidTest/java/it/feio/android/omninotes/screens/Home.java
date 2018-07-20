package it.feio.android.omninotes.screens;

import it.feio.android.omninotes.R;
import it.feio.android.omninotes.helpers.Constants;
import it.feio.android.omninotes.helpers.HelperMethods;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class Home {

    public static boolean isNothingHereDisplayed() {
        return HelperMethods.isObjectDisplayed(withId(R.id.empty_list));
    }

    public static boolean isNothingHereClickable() {
        return HelperMethods.isObjectClickable(withId(R.id.empty_list));
    }

    public static boolean isAddButtonDisplayed() {
        return HelperMethods.isObjectDisplayed(withId(R.id.fab_expand_menu_button));
    }

    public static boolean isAddButtonClickable() {
        return HelperMethods.isObjectClickable(withId(R.id.fab_expand_menu_button));
    }

    public static void clickAddButton() {
        HelperMethods.performClick(withId(R.id.fab_expand_menu_button));
    }

    public static boolean isCheckListAboveTextNote() {
        return HelperMethods.isFirstObjectAboveSecondObject(withText(Constants.CHECKLIST), withText(Constants.TEXT_NOTE));
    }

    public static boolean isCheckListBelowPhoto() {
        return HelperMethods.isFirstObjectBelowSecondObject(withText(Constants.CHECKLIST), withText(Constants.PHOTO));
    }

    public static boolean isPicturePhotoAbovePictureCheckList() {
        return HelperMethods.isFirstObjectAboveSecondObject(withId(R.id.fab_camera), withId(R.id.fab_checklist));
    }

    public static void clickTextNoteButton() {
        HelperMethods.performClick(withId(R.id.fab_note));
    }

    public static boolean isReminderSetDisplayed() {
        return HelperMethods.isObjectDisplayed(withId(R.id.card_layout));
    }
}