package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myfirstapp.CrudMatakuliah.MainActivityMatkul;
import com.example.myfirstapp.CrudMatakuliah.MatakuliahAddActivity;
import com.example.myfirstapp.Model.DefaultResult;
import com.example.myfirstapp.Model.User;
import com.example.myfirstapp.Network.GetDataService;
import com.example.myfirstapp.Network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    ProgressDialog pd;
    List<User> users;
    SharedPreferences session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toast.makeText(LoginActivity.this, "Ini Login", Toast.LENGTH_SHORT).show();
        session = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
        if(!session.getString("nimnik", "").isEmpty() && !session.getString("nama", "").isEmpty()) {
            finish();
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            return;
        }

        EditText nimnik = (EditText) findViewById(R.id.nimnik);
        EditText password = (EditText) findViewById(R.id.password);
        Button btnSimpan = (Button)findViewById(R.id.login);
        pd = new ProgressDialog(LoginActivity.this);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Mohon menunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<List<User>> call = service.login(
                        nimnik.getText().toString(),
                        password.getText().toString()
                );

                call.enqueue(new Callback<List<User>>() {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                        pd.dismiss();
                        users = response.body();
                        User u = users.get(0);
                        SharedPreferences.Editor editor = session.edit();
                        editor.clear();
                        editor.putString("nimnik", u.getNimnik());
                        editor.putString("nama", u.getNama());
                        editor.apply();
                        finish();
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(LoginActivity.this, "Username atau password salah.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}