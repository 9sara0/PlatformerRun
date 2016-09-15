package com.team.platformerrun;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
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
import android.widget.TextView;

public class CollectCoins extends AppCompatActivity {

    MediaPlayer coinSound;
    Coin coin;
    LocationManager locationManager;
    LocationListener locationListener;
    Long startTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_coins);
        coinSound = MediaPlayer.create(this, R.raw.coin_sound);
        coin = new Coin();
        startTime = System.currentTimeMillis();
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

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
        startLocationListening();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 10:
                startLocationListening();
                break;
            default:
                break;
        }
    }

    void startLocationListening() {
        // first check for permissions
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.INTERNET}
                        , 10);
            }
            return;
        }
        // this code won't execute IF permissions are not allowed, because in the line above there is return statement.

        locationManager.requestLocationUpdates("gps", 5000, 5, locationListener);

    }

    public void stopLocationListener() {
        locationManager.removeUpdates(locationListener);
        locationManager = null;
    }

    public void collectCoins() {
        coin.addCoin();
        coinSound.start();
        String message = "Coins This Run: " + Integer.toString(coin.getCoinTotal());
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
}
