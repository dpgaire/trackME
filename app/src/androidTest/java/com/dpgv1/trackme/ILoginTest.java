package com.dpgv1.trackme;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ILoginTest {
    @Rule
    public ActivityTestRule<MainActivity> testRule=new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checklogin()
    {
        onView(withId(R.id.etusernamelogin))
                .perform(typeText("dpgaire123"));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.etPasswordLogin))
                .perform(typeText("dpgaire"));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.btnLogin)).perform(click());

        onView(withId(R.layout.activity_dashboard));
    }


}
