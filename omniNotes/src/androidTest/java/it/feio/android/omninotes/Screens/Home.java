package it.feio.android.omninotes.Screens;

import it.feio.android.omninotes.Helpers.Matchers;
import it.feio.android.omninotes.Helpers.Methods;
import it.feio.android.omninotes.R;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class Home {
    public static boolean isNothingHereDisplayed() {
        return Methods.isObjectDisplayed(Matchers.emptyList);
    }

    public static boolean isNothingHereClickable() {
        return Methods.isObjectClickable(Matchers.emptyList);
    }

    public static boolean isAddButtonDisplayed() {
        return Methods.isObjectDisplayed(Matchers.addToDoButton);
    }

    public static boolean isAddButtonClickable() {
        return Methods.isObjectClickable(Matchers.addToDoButton);
    }

    public static void clickAddButton() {
        Methods.performClick(Matchers.addToDoButton);
    }

    public static boolean isCheckListAboveTextNote() {
        return Methods.isFirstObjectAboveSecondObject(withText("Checklist"), withText("Text note"));
    }

    public static boolean isCheckListBelowPhoto() {
        return Methods.isFirstObjectBelowSecondObject(withText("Checklist"), withText("Photo"));
    }

    public static boolean isPicturePhotoAbovePictureCheckList() {
        return Methods.isFirstObjectAboveSecondObject(Matchers.cameraImage, Matchers.checkListImage);
    }

    public static void clickTextNoteButton() {
        Methods.performClick(Matchers.textNoteButton);
    }

    public static boolean isReminderSetDisplayed() {
        return Methods.isObjectDisplayed(Matchers.reminderSet);
    }
}
