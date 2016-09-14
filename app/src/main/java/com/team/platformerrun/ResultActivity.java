package com.team.platformerrun;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import javax.xml.datatype.Duration;

public class ResultActivity extends AppCompatActivity {

    String coinsCollectedInRun;
    Long runDuration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        // gets the coins from the completed game
        Intent intent = getIntent();
        coinsCollectedInRun = intent.getExtras().getString("Coins");
        // get the duration
        runDuration = (intent.getLongExtra("Duration", 0));

        // saves the coins to file
        DataStorage.writeCoins(coinsCollectedInRun, this);


        // displays the total and time
        displayCoinTotal();



    }

    public void startGame(View view) {
        Intent intent = new Intent(this, CollectCoins.class);
        startActivity(intent);
    }

    public void returnHome(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void displayCoinTotal () {
        String duration = formatDuration(runDuration);
        String message = "You collected " + coinsCollectedInRun + " coins in " + duration;
        TextView textView = (TextView) findViewById(R.id.coins_collected);
        textView.setText(message);

    }


    public String formatDuration(Long millis) {
        long second = (millis / 1000) % 60;
        long minute = (millis / (1000 * 60)) % 60;
        long hour = (millis / (1000 * 60 * 60)) % 24;
        String time = String.format("%02d:%02d:%02d", hour, minute, second);
        return time;
    }

}
