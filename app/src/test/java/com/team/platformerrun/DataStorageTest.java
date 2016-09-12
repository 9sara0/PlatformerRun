package com.team.platformerrun;

import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertTrue;

public class DataStorageTest {

    DataStorage testFile = new DataStorage();

    private HomeActivity context;

    @Mock
    private HomeActivity view;

    @Test
    public void saveDataShouldCreateAFile(){

        testFile.writeCoins("5", context);
        assertTrue(testFile.readCoins(context) == "5");
    }

}