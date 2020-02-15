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
public class IChatTest {
    @Rule
    public ActivityTestRule<Chats> testRule=new ActivityTestRule<>(Chats.class);
    @Test
    public void SendMessage() {
        onView( withId( R.id.editTextSendMesage ) )
                .perform( typeText( "Hello" ) );
        Espresso.closeSoftKeyboard();

        onView( withId( R.id.sendMessageButton ) ).perform( click() );
        onView( withId( R.layout.activity_chats ) );
    }
}
