package com.team.platformerrun;

import android.content.Context;

import java.io.FileOutputStream;

public class DataStorage {


    public static void saveData(String coins) {
        FileOutputStream outputStream = null;
        context = getApplicationContext();
        try {
            outputStream = context.openFileOutput("coins_data", Context.MODE_PRIVATE);
            outputStream.write(coins.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
