package com.team.platformerrun;

/**
 * Created by sara on 9/9/16.
 */
public class Coin {

    int totalCoin = 0;

    public int getCoinTotal() {
        return totalCoin;
    }


    public void addCoin() {
        ++totalCoin;
    }
}
