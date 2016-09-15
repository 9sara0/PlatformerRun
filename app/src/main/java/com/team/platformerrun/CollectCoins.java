package com.team.platformerrun;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CollectCoins extends AppCompatActivity {

    final int MIN_DISTANCE = 5; // in meters
    final int INTERVAL = 5000; // in milli-sec

    MediaPlayer coinSound;
    Coin            coin;
    LocationManager locationManager;
    LocationListener locationListener;
    Button playButton;
    Long        startTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_coins);


        assignVariables();
        declareLocationListener();
        startLocationListening();
        setFont();
    }

    private void assignVariables(){
        coin = new Coin();
        startTime = System.currentTimeMillis();
        coinSound = MediaPlayer.create(this, R.raw.coin_sound);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
    }

    private void declareLocationListener(){
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                collectCoins();
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {
                Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(i);
            }
        };
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 10:
                startLocationListening();
                break;
            default:
                break;
        }
    }

    private void startLocationListening() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.INTERNET}
                        , 10);
            }
            return;
        }
        locationManager.requestLocationUpdates("gps", INTERVAL, MIN_DISTANCE, locationListener);
    }

    private void stopLocationListener() {
        locationManager.removeUpdates(locationListener);
        locationManager = null;
    }

    private void collectCoins() {
        coin.addCoin();
        coinSound.start();
        String message = Integer.toString(coin.getCoinTotal());
        TextView textView = (TextView) findViewById(R.id.gameRunningTotalCoins);
        textView.setText(message);
    }

    public void endGame(View view) {
        stopLocationListener();
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("Duration", calculateDuration());
        intent.putExtra("Coins", coin.getCoinTotal());
        startActivity(intent);
    }

    private Long calculateDuration() {
        Long duration;
        duration =  System.currentTimeMillis() - startTime;
        return duration;
    }

    private void setFont() {
        TextView tx = (TextView)findViewById(R.id.gameRunningTotalCoins);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/mario.ttf");
        tx.setTypeface(custom_font);
    }
}
