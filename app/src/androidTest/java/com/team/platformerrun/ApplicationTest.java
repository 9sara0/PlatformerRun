package com.team.platformerrun;

import android.app.Application;

import org.junit.Test;
import org.junit.Rule;
import org.junit.runner.RunWith;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;

import android.test.suitebuilder.annotation.LargeTest;

import dalvik.annotation.TestTarget;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static java.util.regex.Pattern.matches;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest



public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    @Rule
    public ActivityTestRule<HomeActivity> myActivittyRule = new ActivityTestRule<>(HomeActivity.class);

    @Test
    public void startNewGame_secondActivity(){
        onView(withId(R.id.startGame))
                .perform(click());



    }

}