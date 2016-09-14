package com.team.platformerrun;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    int coinsCollectedInRun;
    String highScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        // gets the coins from the completed game
        Intent intent = getIntent();
        coinsCollectedInRun = intent.getExtras().getInt("Coins");

        // displays the total
        displayCoinTotal();

        //Read high score
        highScore = DataStorage.readHighScore(this);
        //update high score value
        updateHighestScore();
        // save high score
        DataStorage.writeHighScore(highScore, this);

        displayHighScore();

    }

    public void startGame(View view) {
        Intent intent = new Intent(this, CollectCoins.class);
        startActivity(intent);
    }

    public void returnHome(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void displayCoinTotal() {
        String message = "You collected " + coinsCollectedInRun + " coins!";
        TextView textView = (TextView) findViewById(R.id.coins_collected);
        textView.setText(message);
    }


    public void displayHighScore() {
        String message = "High Score " + highScore;
        TextView highScoreText = (TextView) findViewById(R.id.highScore);
        highScoreText.setText(message);
    }

    public void updateHighestScore() {
        if (coinsCollectedInRun > Integer.parseInt(highScore)) {
            highScore = Integer.toString(coinsCollectedInRun);
        }
    }


}
