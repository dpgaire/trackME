package com.dpgv1.trackme;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class IRegisterTest {
    @Rule
    public ActivityTestRule<RegisterActivity> testRule=new ActivityTestRule<>(RegisterActivity.class);
    @Test
    public void RegisterUser()
    {
        onView(withId(R.id.etfirstname))
                .perform(typeText("Brendom"));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.etlastname))
                .perform(typeText("McCllum"));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.etaddress))
                .perform(typeText("Galyang"));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.etusernameReg))
                .perform(typeText("brendonMcc"));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.etPasswordReg))
                .perform(typeText("password"));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.btnRegister)).perform(click());

        onView(withId(R.id.navigation_dashboard));
    }

}
