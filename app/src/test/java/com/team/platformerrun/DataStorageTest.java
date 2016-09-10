package com.team.platformerrun;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DataStorageTest {

    DataStorage testFile = new DataStorage();

    @Test
    public void saveDataShouldCreateAFile(){

        testFile.writeItems("5");
        assertTrue(testFile.readItems() == "5");
    }

}