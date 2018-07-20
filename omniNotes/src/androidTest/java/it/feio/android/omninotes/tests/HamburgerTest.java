package it.feio.android.omninotes.tests;

import org.junit.Test;

import it.feio.android.omninotes.screens.AddTextNote;
import it.feio.android.omninotes.screens.Home;

public class HamburgerTest {

    @Test
    public void HamburgerViewTest() {
        // Step: Click on Add button
        Home.clickAddButton();

        // Step: Click on Text Note button
        Home.clickTextNoteButton();

        // Step: Add note with title "Pay the bills"
        AddTextNote.typePayTheBills();

        // Step: Click return button

        // Step: Delete (swipe) the note with title "Pay the bills"

        // Step: Click on hamburger

        // Verify: The button with name Archive is displayed and has sibling the button with name Notes

        // Step: Click on Archive button

        // Verify: Note with title "Pay the bills" is displayed"

        // Step: Delete (swipe) the note with title "Pay the bills"

        // Step: Click on hamburger

        // Verify: The button with name Trash is displayed below the button with name Notes

        // Verify: The button with name Archive is NOT displayed

        // Step: Click on Trash button

        // Verify: Note with title "Pay the bills" is displayed"

        // Verify: List View has one child

        // Step: Click More option

        // Step: Click Empty trash button

        // Step: Click Button with text OK

        // Step: Note with title "Pay the bills" is NOT displayed"
    }
}
