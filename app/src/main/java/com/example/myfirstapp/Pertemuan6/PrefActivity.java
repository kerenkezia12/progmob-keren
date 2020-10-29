package com.example.myfirstapp.Pertemuan6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;

import com.example.myfirstapp.R;

public class PrefActivity extends AppCompatActivity {
    String isLogin ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pref);

        Button btnPref3 = (Button)findViewById(R.id.btnPref3);

        SharedPreferences pref = PrefActivity.this.getSharedPreferences("pref_file",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        //Membaca pref isi login apakah true atau false
        isLogin = pref.getString("isLogin", "0");
        if(isLogin.equals("1")){
            btnPref3.setText("Logout");
        }else{
            btnPref3.setText("Login");
        }

        //pengisian pref
        btnPref3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                isLogin = pref.getString("isLogin", "0");
                if(isLogin.equals("0")){
                    editor.putString("isLogin","1");
                    btnPref3.setText("Logout");
                }else {
                    editor.putString("isLogin","0");
                    btnPref3.setText("Login");
                }
                editor.commit();
            }
        });
    }
}