package it.feio.android.omninotes.screens;

import android.view.View;

import org.hamcrest.Matcher;

import it.feio.android.omninotes.R;
import it.feio.android.omninotes.helpers.Constants;
import it.feio.android.omninotes.helpers.EspressoMatchers;
import it.feio.android.omninotes.helpers.HelperMethods;

import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

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

    public static void deletePayTheBillsNote() {
        HelperMethods.deleteElement(withId(R.id.root));
    }

    public static boolean isArchiveButtonDisplayed() {
        return HelperMethods.isObjectDisplayed(allOf(withId(R.id.title), withText(Constants.ARCHIVE)));
    }

    public static boolean isArchiveButtonSiblingWithNotesButton() {
        Matcher<View> archiveButton = allOf(withChild(withChild(allOf(withId(R.id.title), withText(Constants.ARCHIVE)))), hasSibling(withChild(withChild(allOf(withId(R.id.title), withText(Constants.NOTES))))));
        return HelperMethods.isObjectDisplayed(archiveButton);
    }

    public static void clickArchiveButton() {
        HelperMethods.performClick(allOf(withId(R.id.title), withText(Constants.ARCHIVE)));
    }

    public static void clickTrashButton() {
        HelperMethods.performClick(allOf(withId(R.id.title), withText(Constants.TRASH)));
    }

    public static void clickMoreOptions() {
        HelperMethods.performClick(withContentDescription(Constants.MORE_OPTIONS));
    }

    public static void clickEmptyTrash() {
        HelperMethods.performClick(allOf(withId(R.id.title), withText(Constants.EMPTY_TRASH)));
    }

    public static void clickOKButton() {
        HelperMethods.performClick(withId(R.id.buttonDefaultPositive));
    }

    public static boolean isTrashButtonDisplayed() {
        return HelperMethods.isObjectDisplayed(allOf(withId(R.id.title), withText(Constants.TRASH)));
    }

    public static int getListViewNoOfChildren() {
        return EspressoMatchers.getListViewChildCount(withId(R.id.list));
    }

    public static boolean isMenuSortLeftOfMoreOptions() {
        return HelperMethods.isFirstObjectLeftOfSecondObject(withId(R.id.menu_sort), withContentDescription(Constants.MORE_OPTIONS));
    }

    public static boolean isMenuSortRightOfSearch() {
        return HelperMethods.isFirstObjectRightOfSecondObject(withId(R.id.menu_sort), withId(R.id.menu_search));
    }

    public static void add5ItemsOneIsASpecialItem() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Home.clickAddButton();
            Home.clickTextNoteButton();
            if (i == 4) {
                HelperMethods.typeSomeText(withId(R.id.detail_title), Constants.MY_NOTE);
            } else {
                HelperMethods.typeSomeText(withId(R.id.detail_title), EspressoMatchers.generateRandomString(7));
            }
            AddTextNote.clickBackButton();
            Thread.sleep(1000);
        }
    }

    public static int getListNoOfChildren() {
        return EspressoMatchers.getListViewChildCount(withId(R.id.list));
    }
}