package com.team.platformerrun;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CollectCoins extends AppCompatActivity {

    MediaPlayer coinSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_coins);
        coinSound = MediaPlayer.create(this, R.raw.coin_sound );
    }

    public void playSound(View view) {
        coinSound.start();
    }

}
