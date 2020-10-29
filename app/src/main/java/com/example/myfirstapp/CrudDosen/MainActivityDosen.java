package com.example.myfirstapp.CrudDosen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myfirstapp.Crud.MainMhsActivity;
import com.example.myfirstapp.R;

public class MainActivityDosen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dosen);

        Button btnLihatDsn = (Button)findViewById(R.id.btnLihatDsn);
        Button btnTambahDsn = (Button)findViewById(R.id.btnTambahDsn);
        Button btnUbahDsn = (Button)findViewById(R.id.btnUbahDsn);
        Button btnHapusDsn = (Button)findViewById(R.id.btnHapusDsn);

        btnLihatDsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(MainActivityDosen.this,DosenGetAllActivity.class);
                startActivity(Intent);
            }
        });
        btnTambahDsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(MainActivityDosen.this,DosenAddActivity1.class);
                startActivity(Intent);
            }
        });
        btnUbahDsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(MainActivityDosen.this,DosenUpdateActivity.class);
                startActivity(Intent);
            }
        });
        btnHapusDsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(MainActivityDosen.this,DosenDeleteActivity.class);
                startActivity(Intent);
            }
        });
    };
    }
