package com.team.platformerrun;

import android.app.Application;
import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    @Rule
    public ActivityTestRule<HomeActivity> myActivityRule = new ActivityTestRule<>(HomeActivity.class);

    @Test
    public void clickingStartGameButtonShouldDispalyCoinsThisRun0(){
        onView(withId(R.id.startGame))
                .perform(click());
        onView(withId(R.id.gameRunningTotalCoins))
                .check(matches(withText("Coins This Run: 0")));
    }

    @Test
    public void clickingCollectCoinButtonShouldDispalyCoinsThisRun1(){
        onView(withId(R.id.startGame))
                .perform(click());
        onView(withId(R.id.collectCoinsButton))
                .perform(click());
        onView(withId(R.id.gameRunningTotalCoins))
                .check(matches(withText("Coins This Run: 1")));
    }


    @Test
    public void clickingEndGameButtonShouldDispalyYouCollected1Coin(){
        onView(withId(R.id.startGame))
                .perform(click());
        onView(withId(R.id.collectCoinsButton))
                .perform(click());
        onView(withId(R.id.endGameButton))
                .perform(click());
        onView(withId(R.id.coins_collected))
                .check(matches(withText("You collected 1 coins!")));
        onView(withId(R.id.highScore))
                .check(matches(withText("High Score 6")));
    }


}