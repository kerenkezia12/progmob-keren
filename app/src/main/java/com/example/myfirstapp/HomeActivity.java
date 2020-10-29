package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myfirstapp.Crud.MainMhsActivity;
import com.example.myfirstapp.CrudDosen.MainActivityDosen;
import com.example.myfirstapp.CrudMatakuliah.MainActivityMatkul;

public class HomeActivity extends AppCompatActivity {

    SharedPreferences session;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toast.makeText(HomeActivity.this, "Ini Home", Toast.LENGTH_SHORT).show();
        session = PreferenceManager.getDefaultSharedPreferences(HomeActivity.this);
        if(session.getString("nimnik", "").isEmpty() && session.getString("nama", "").isEmpty()) {
            finish();
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            return;
        }

        TextView welcome = (TextView) findViewById(R.id.textViewWelcome);
        Button btnMhs = (Button)findViewById(R.id.btnmhs);
        Button btnDsn = (Button)findViewById(R.id.btndsn);
        Button btnMk = (Button)findViewById(R.id.btnmk);
        Button btnLogout = (Button)findViewById(R.id.buttonLogout);

        welcome.setText("Selamat datang "+session.getString("nama", ""));

        btnMhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(HomeActivity.this, MainMhsActivity.class);
                startActivity(Intent);
            }
        });
        btnDsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(HomeActivity.this,MainActivityDosen.class);
                startActivity(Intent);
            }
        });
        btnMk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(HomeActivity.this,MainActivityMatkul.class);
                startActivity(Intent);
            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = session.edit();
                editor.clear();
                editor.apply();
                finish();
                Intent Intent = new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(Intent);
            }
        });
    }
}