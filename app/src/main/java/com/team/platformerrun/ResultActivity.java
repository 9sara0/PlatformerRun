package com.team.platformerrun;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class ResultActivity extends AppCompatActivity {

    Long runDuration;
    int coinsCollectedInRun;
    String highScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();

        runDuration = (intent.getLongExtra("Duration", 0));
        coinsCollectedInRun = intent.getExtras().getInt("Coins");
        displayCoinTotal();

        highScore = DataStorage.readHighScore(this);
        updateHighestScore();
        DataStorage.writeHighScore(highScore, this);
        displayHighScore();
        displayDuration();
        setFont();
    }

    public void startGame(View view) {
        Intent intent = new Intent(this, CollectCoins.class);
        startActivity(intent);
    }

    public void returnHome(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    private void displayCoinTotal() {
        String message = Integer.toString(coinsCollectedInRun);
        TextView textView = (TextView) findViewById(R.id.coinsCollected);
        textView.setText(message);
    }

    private void displayDuration() {
        String duration = formatDuration(runDuration);
        String message = "Duration: " + duration;
        TextView textView = (TextView) findViewById(R.id.duration);
        textView.setText(message);
    }

    private String formatDuration(Long millis) {
        long second = (millis/ 1000) % 60;
        long minute = (millis / (1000 * 60)) % 60;
        long hour = (millis / (1000 * 60 * 60)) % 24;
        String time = String.format("%02d:%02d:%02d", hour, minute, second);
        return time;
    }

    private void displayHighScore() {
        String message = highScore;
        TextView highScoreText = (TextView) findViewById(R.id.highScore);
        highScoreText.setText(message);
    }

    private void updateHighestScore() {
        if (coinsCollectedInRun > Integer.parseInt(highScore)) {
            highScore = Integer.toString(coinsCollectedInRun);
        }
    }

    private void setFont() {
        TextView tx = (TextView)findViewById(R.id.coinsCollected);
        TextView tx2 = (TextView)findViewById(R.id.highScore);
        TextView tx3 = (TextView)findViewById(R.id.duration);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/mario.ttf");
        tx.setTypeface(custom_font);
        tx2.setTypeface(custom_font);
        tx3.setTypeface(custom_font);
    }
}
