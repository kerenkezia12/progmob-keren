package com.example.myfirstapp.CrudDosen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myfirstapp.Model.DefaultResult;
import com.example.myfirstapp.Network.GetDataService;
import com.example.myfirstapp.Network.RetrofitClientInstance;
import com.example.myfirstapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DosenAddActivity1 extends AppCompatActivity {

    ProgressDialog pd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen_add1);

        EditText edNama = (EditText) findViewById(R.id.editTextNamaDsn);
        EditText edNidn = (EditText) findViewById(R.id.editTextNidn);
        EditText edAlamat = (EditText) findViewById(R.id.editTextAlamat);
        EditText edEmail = (EditText) findViewById(R.id.editTextEmailDsn);
        EditText edGelar = (EditText) findViewById(R.id.editTextGelar);
        Button btnSimpan = (Button)findViewById(R.id.btnSimpanDsn);
        pd = new ProgressDialog(DosenAddActivity1.this);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Mohon menunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.add_dsn(
                        edNama.getText().toString(),
                        edNidn.getText().toString(),
                        edAlamat.getText().toString(),
                        edEmail.getText().toString(),
                        edGelar.getText().toString(),
                        "kosong",
                        "72180222"
                );

                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(DosenAddActivity1.this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(DosenAddActivity1.this, "Gagal", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
            }
        });
    }
}