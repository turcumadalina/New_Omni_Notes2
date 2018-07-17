package it.feio.android.omninotes.Tests;

import org.junit.Assert;
import org.junit.Test;

import it.feio.android.omninotes.Helpers.EspressoTestBase;
import it.feio.android.omninotes.Helpers.Methods;
import it.feio.android.omninotes.Screens.AddTextNote;
import it.feio.android.omninotes.Screens.Home;

public class FirstTest extends EspressoTestBase {

    @Test
    public void appointmentDetails() {
        // Step: Start the app

        // Verify: Image with "Nothing here" is displayed, but !(not) clickable
        Assert.assertTrue("NothingHere is not displayed", Home.isNothingHereDisplayed());
        Assert.assertTrue("NothingHere is not clickable", Home.isNothingHereClickable());

        // Verify "Add" button is displayed, clickable and has red colour
        Assert.assertTrue("Add button is not displayed", Home.isAddButtonDisplayed());
        Assert.assertTrue("Add button is not clickable", Home.isAddButtonClickable());

        // Step: Click "Add" button
        Home.clickAddButton();

        // Verify: Test "Checklist" is between 2 other texts
        Assert.assertTrue("CheckList is not above TextNote", Home.isCheckListAboveTextNote());
        Assert.assertTrue("CheckList is not Below Photo", Home.isCheckListBelowPhoto());

        // Verify: The suggestive picture of "Photo" text is above 2 other different pictures
        Assert.assertTrue("PicturePhoto is not above PictureCheckList", Home.isPicturePhotoAbovePictureCheckList());

        // Step: Click "Text note" button
        Home.clickTextNoteButton();

        // Verify: "Content" and "Add reminder" are descendant of a LinearLayout and they are siblings
        AddTextNote.isContentDescendantOfLinearLayout();
        AddTextNote.isAddReminderDescendantOfLinearLayout();
        AddTextNote.isContentSiblingWithAddReminder();

        // Step: Click "Title" container
        AddTextNote.clickTitleContainer();

        // Step: Type "Doctor appointment"
        AddTextNote.typeDoctorAppointment();

        // Step:Click "Content" container
        AddTextNote.clickContentContainer();

        // Step: Type "Tuesday, 17 Jul 2018, 18:30."
        AddTextNote.typeDateAndTime();

        // Step: Click on "Add reminder"
        AddTextNote.clickAddReminder();

        // Step: Add a reminder for the date from "Content" container
        Methods.clickXY(200, 1140);

        // Step: Click "Done" button
        AddTextNote.clickDone();

        // Verify: The "Time picker" is displayed
        AddTextNote.isTimePickerDisplayed();

        // Step: Click "Done" button
        AddTextNote.clickDoneButton();

        // Step: Swipe the "repeat weekly" button
        AddTextNote.enableRepeatWeekly();

        // Verify: The number of weeks is between 2 texts
        Assert.assertTrue("Week1 is not below RepeatWeekly", AddTextNote.isWeek1BelowRepeatWeekly());
        Assert.assertTrue("Week2 is not above Forever", AddTextNote.isWeek2AboveForever());

        // Step: Click on "Friday" button
        AddTextNote.clickFriday();

        // Step: Click on "Done" button
        AddTextNote.clickDone();

        // Step: Press back
        AddTextNote.clickBackButton();

        // Verify: Reminder set is displayed
        Home.isReminderSetDisplayed();
    }
}
