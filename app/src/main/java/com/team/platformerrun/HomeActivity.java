package com.team.platformerrun;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    String highScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        highScore = DataStorage.readHighScore(this);
        displayHighScore();
    }

    public void startGame(View view) {
        Intent intent = new Intent(this, CollectCoins.class);
        startActivity(intent);
    }


    private void displayHighScore() {
        String message = "High Score " + highScore;
        TextView highScoreText = (TextView) findViewById(R.id.highScore);
        highScoreText.setText(message);
    }
}
