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
public class IAddFriend {
    @Rule
    public ActivityTestRule<AddFriendActivity> testRule=new ActivityTestRule<>(AddFriendActivity.class);
    @Test
    public void AddFriend()
    {
        onView(withId(R.id.etfirstnamea))
                .perform(typeText("Dpvai"));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.etlastnamea))
                .perform(typeText("McCllum"));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.etphonenumbera))
                .perform(typeText("9845552522"));
        Espresso.closeSoftKeyboard();



        onView(withId(R.id.btnAddFriend)).perform(click());

        onView(withId(R.layout.activity_friend));
    }

}

