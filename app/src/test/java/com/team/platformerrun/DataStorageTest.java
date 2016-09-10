package com.team.platformerrun;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;

public class DataStorageTest {

    @Test
    public void saveDataShouldCreateAFile(){
        DataStorage.saveData("5");
        File file = new File("coins_data");
        assertTrue(file.exists());
    }

}