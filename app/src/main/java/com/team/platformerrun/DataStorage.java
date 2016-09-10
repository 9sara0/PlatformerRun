package com.team.platformerrun;

import android.app.Activity;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class DataStorage extends Activity {

    public String readItems() {
        File filesDir = getFilesDir();
        File coinData = new File(filesDir, "coin_data");
        try {
            return FileUtils.readFileToString(coinData);
        } catch (IOException e) {
            return "0";
        }
    }

    public void writeItems(String coins) {
        File filesDir = getFilesDir();
        File coinData = new File(filesDir, "coin_data");
        try {
            FileUtils.writeStringToFile(coinData, coins);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
