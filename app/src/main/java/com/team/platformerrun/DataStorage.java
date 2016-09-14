package com.team.platformerrun;

import android.content.Context;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class DataStorage  {

    public static String readHighScore(Context context) {
        File filesDir = context.getFilesDir();
        File scoreData = new File(filesDir, "high_score");
        String defaultHighScore = "0";
        try {
            return FileUtils.readFileToString(scoreData);
        } catch (IOException e) {
            return defaultHighScore;
        }
    }

    public static void writeHighScore(String coins, Context context) {
        File filesDir = context.getFilesDir();
        File scoreData = new File(filesDir, "high_score");
        try {
            FileUtils.writeStringToFile(scoreData, coins);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
