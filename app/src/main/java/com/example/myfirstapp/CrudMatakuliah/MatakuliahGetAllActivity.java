package com.example.myfirstapp.CrudMatakuliah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myfirstapp.Adapter.MahasiswaCRUDRecyclerAdapter;
import com.example.myfirstapp.Adapter.MatkulCRUDRecyclerAdapter;
import com.example.myfirstapp.Crud.MahasiswaGetAllActivity;
import com.example.myfirstapp.Model.Matkul;
import com.example.myfirstapp.Network.GetDataService;
import com.example.myfirstapp.Network.RetrofitClientInstance;
import com.example.myfirstapp.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatakuliahGetAllActivity extends AppCompatActivity {

    RecyclerView rvDsn;
    MatkulCRUDRecyclerAdapter dsnAdapter;
    ProgressDialog pd;
    List<Matkul> matakuliahList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matakuliah_get_all);

        rvDsn = (RecyclerView) findViewById(R.id.rvGetMatkul);
        pd = new ProgressDialog(this);
        pd.setTitle("Mohon Bersabar");
        pd.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Matkul>> call = service.getMatkul("72180222");

        call.enqueue(new Callback<List<Matkul>>() {
            @Override
            public void onResponse(Call<List<Matkul>> call, Response<List<Matkul>> response) {
                pd.dismiss();

                matakuliahList = response.body();
                dsnAdapter = new MatkulCRUDRecyclerAdapter(MatakuliahGetAllActivity.this);
                dsnAdapter.setMatkulList(matakuliahList);

                rvDsn.setLayoutManager(new LinearLayoutManager(MatakuliahGetAllActivity.this));
                rvDsn.setAdapter(dsnAdapter);
            }
            @Override
            public void onFailure(Call<List<Matkul>> call, Throwable t) {
                pd.dismiss();
                Toast.makeText(MatakuliahGetAllActivity.this, "Error", Toast.LENGTH_LONG).show();
            }
        });


    }
}