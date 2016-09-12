package com.team.platformerrun;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String coins = DataStorage.readCoins(this);

        String message = "Total Coins: " + coins;
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);
    }

    public void startGame(View view) {
        Intent intent = new Intent(this, CollectCoins.class);
        startActivity(intent);
    }



}
