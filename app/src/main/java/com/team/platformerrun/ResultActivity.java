package com.team.platformerrun;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    String coinsCollectedInRun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        // gets the coins from the completed game
        Intent intent = getIntent();
        coinsCollectedInRun = intent.getExtras().getString("Coins");

        // saves the coins to file
        DataStorage.writeCoins(coinsCollectedInRun, this);

        // displays the total
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
        String message = "You collected " + coinsCollectedInRun + " coins!";
        TextView textView = (TextView) findViewById(R.id.coins_collected);
        textView.setText(message);
    }
}
