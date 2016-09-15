package com.team.platformerrun;

import android.content.Intent;
import android.graphics.Typeface;
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
        setFont();
    }

    public void startGame(View view) {
        Intent intent = new Intent(this, CollectCoins.class);
        startActivity(intent);
    }


    private void displayHighScore() {
        String message = highScore;
        TextView highScoreText = (TextView) findViewById(R.id.highScore);
        highScoreText.setText(message);
    }

    private void setFont(){
       TextView tx = (TextView)findViewById(R.id.highScore);
       Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/mario.ttf");
       tx.setTypeface(custom_font);
    }
}
