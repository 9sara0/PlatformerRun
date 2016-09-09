package com.team.platformerrun;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by sara on 9/9/16.
 */
public class CoinTest {

    Coin coin = new Coin();

    @Test
    public void getCoinTotalShouldReturn0() {
        assertEquals(0, coin.getCoinTotal());
    }

    @Test
    public void addCoinShouldIncrementCoinTotalBy1() {
        coin.addCoin();
        assertEquals(1, coin.getCoinTotal());
    }

}