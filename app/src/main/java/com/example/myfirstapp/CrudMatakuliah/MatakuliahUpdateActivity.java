package com.example.myfirstapp.CrudMatakuliah;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myfirstapp.Model.DefaultResult;
import com.example.myfirstapp.Model.Dosen;
import com.example.myfirstapp.Network.GetDataService;
import com.example.myfirstapp.Network.RetrofitClientInstance;
import com.example.myfirstapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatakuliahUpdateActivity extends AppCompatActivity {
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matakuliah_update);

        EditText edKodeDicari = (EditText) findViewById(R.id.editTextKodeMatkulDicari);
        EditText edNama = (EditText) findViewById(R.id.editTextNamaMatkul);
        EditText edKode = (EditText) findViewById(R.id.editTextKodeMatkul);
        EditText edHari = (EditText) findViewById(R.id.editTextHariMatkul);
        EditText edSesi = (EditText) findViewById(R.id.editTextSesiMatkul);
        EditText edSks = (EditText) findViewById(R.id.editTextSksMatkul);
        Button btnUpdate = (Button)findViewById(R.id.btnSimpanMatkul);
        pd = new ProgressDialog(MatakuliahUpdateActivity.this);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Mohon menunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.update_matkul(
                        edNama.getText().toString(),
                        edKode.getText().toString(),
                        Integer.parseInt(edHari.getText().toString()),
                        Integer.parseInt(edSesi.getText().toString()),
                        Integer.parseInt(edSks.getText().toString()),
                        edKodeDicari.getText().toString(),
                        "72180222"
                );

                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(MatakuliahUpdateActivity.this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MatakuliahUpdateActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
            }
        });
    }
}