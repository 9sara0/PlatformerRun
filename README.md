# Run to Riches

The game-ified running app that will inspire people to get out and work up a sweat.

Pull out your old trainers, dust them off and get ready to play a timeless classic:

1. Collect coins
* Beat highscore's
* Run faster
* Run longer
* and most importantly, have fun.

You'll be addicted in no time!

## Getting Started

* This app currently runs on android versions ??????
* To download the app, clone this repo and ????


These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

To run the app you'll need Android Studio and an Android device (which version????) or emulator.

```
Install Android Studio from: https://developer.android.com/studio/install.html

```

### Installing

Get the app up and running.

```
Clone this repo to your machine
```
**Add pictures!!!!!!!!!!**

```
Click run the app
```
**Add pictures!!!!!!!!!!**

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

To run the unit tests:

1. go to the java directory

2. select the package with the extension android test

3. right click and select run test

### Test Examples

**Unit Test**  
Ensuring our addCoin method increases the coin total.
```
@Test
public void addCoinShouldIncrementCoinTotalBy1() {
    coin.addCoin();
    assertEquals(1, coin.getCoinTotal());
}
```


**Feature Test**  
Ensuring that the correct default values are displayed when a game is started.
```
@Test
public void clickingStartGameButtonShouldDispalyCoinsThisRun0(){
    onView(withId(R.id.startGame))
            .perform(click());
    onView(withId(R.id.gameRunningTotalCoins))
            .check(matches(withText("Coins This Run: 0")));
}
```

## Built With

* Android Studio
* Java

## Team

* **Alban** https://github.com/albiebabie
* **Robert** https://github.com/Rob-rls
* **Ross** https://github.com/SlipperyJ
* **Sara** https://github.com/9sarah0


## Acknowledgments

* Hat tip to anyone who's code was used
* Inspiration
* etc
