package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.example.myfirstapp.Pertemuan6.PrefActivity;

public class SplashActivity extends Activity {

    SharedPreferences session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Toast.makeText(SplashActivity.this, "Ini Splash", Toast.LENGTH_SHORT).show();
        session = PreferenceManager.getDefaultSharedPreferences(SplashActivity.this);
        if(!session.getString("nimnik", "").isEmpty() && !session.getString("nama", "").isEmpty()) {
            finish();
            startActivity(new Intent(SplashActivity.this, HomeActivity.class));
            return;
        }
        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    finish();
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                }
            }
        };
        thread.start();
    }

}