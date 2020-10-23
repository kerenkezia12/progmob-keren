package com.example.myfirstapp.Crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myfirstapp.MainActivity;
import com.example.myfirstapp.R;

import Pertemuan2.ListActivity;

public class MainMhsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mhs);

        Button btnGetAll = (Button)findViewById(R.id.buttonGetMhs);
        Button btnAdd = (Button)findViewById(R.id.buttonAddMhs);

        btnGetAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMhsActivity.this, MahasiswaGetAllActivity.class);
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMhsActivity.this, MahasiswaAddActivity.class);
                startActivity(intent);
            }
        });
    }
}