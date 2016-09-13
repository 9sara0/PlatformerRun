package com.team.platformerrun;

import android.content.Context;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class DataStorage  {

    public static String readCoins(Context context) {
        File filesDir = context.getFilesDir();
        File coinData = new File(filesDir, "coin_data");
        try {
            return FileUtils.readFileToString(coinData);
        } catch (IOException e) {
            return "0";
        }
    }

    public static void writeCoins(String coins, Context context) {
        File filesDir = context.getFilesDir();
        File coinData = new File(filesDir, "coin_data");
        try {
            FileUtils.writeStringToFile(coinData, coins);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
