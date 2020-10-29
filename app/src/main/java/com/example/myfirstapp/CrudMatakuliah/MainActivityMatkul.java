package com.example.myfirstapp.CrudMatakuliah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myfirstapp.R;

public class MainActivityMatkul extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_matkul);

        Button btnLihatDsn = (Button)findViewById(R.id.btnLihatDsn);
        Button btnTambahDsn = (Button)findViewById(R.id.btnTambahDsn);
        Button btnUbahDsn = (Button)findViewById(R.id.btnUbahDsn);
        Button btnHapusDsn = (Button)findViewById(R.id.btnHapusDsn);

        btnLihatDsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(MainActivityMatkul.this,MatakuliahGetAllActivity.class);
                startActivity(Intent);
            }
        });
        btnTambahDsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(MainActivityMatkul.this,MatakuliahAddActivity.class);
                startActivity(Intent);
            }
        });
        btnUbahDsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(MainActivityMatkul.this,MatakuliahUpdateActivity.class);
                startActivity(Intent);
            }
        });
        btnHapusDsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(MainActivityMatkul.this,MatakuliahDeleteActivity.class);
                startActivity(Intent);
            }
        });
    };
}
