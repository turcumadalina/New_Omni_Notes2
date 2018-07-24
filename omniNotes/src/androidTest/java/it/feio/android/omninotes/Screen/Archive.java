package it.feio.android.omninotes.Screen;

import it.feio.android.omninotes.Helpers.Constants;
import it.feio.android.omninotes.Helpers.HelpersMethods;

import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class Archive {
    public static boolean isPayTheBillsVisible() {
        return HelpersMethods.isVisible(withText(Constants.PAY_THE_BILLS));
    }
}
