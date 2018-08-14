package com.pglnigeria.devopsdemo_android;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    private String mName = "Shoogarh";

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testUserInput() {
        //put some test in the EditText
        Espresso.onView(withId(R.id.etMessage)).perform(typeText(mName));
        //close soft keyboard
        Espresso.closeSoftKeyboard();
        //perform button click
        Espresso.onView(withId(R.id.btnSave)).perform(click());
        Espresso.onView(withId(R.id.tvResult)).check(matches(withText(mName+"_chicken")));
    }

    @After
    public void tearDown() throws Exception {

    }
}