package com.example.myfirstapp.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfirstapp.Model.Matkul;
import com.example.myfirstapp.R;

import java.util.ArrayList;
import java.util.List;

public class MatkulCRUDRecyclerAdapter extends RecyclerView.Adapter<MatkulCRUDRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<Matkul> matkulList;

    public MatkulCRUDRecyclerAdapter(Context context) {
        this.context = context;
        matkulList = new ArrayList<>();
    }

    public MatkulCRUDRecyclerAdapter(List<Matkul> matkulList) {
        this.matkulList = matkulList;
    }

    public List<Matkul> getMatkulList() {
        return matkulList;
    }

    public void setMatkulList(List<Matkul> matkulList) {
        this.matkulList = matkulList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_list_cardview_matkul,parent,false);
        return new ViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Matkul d = matkulList.get(position);

        holder.tvNama.setText(d.getNama());
        holder.tvKode.setText(d.getKode());
        holder.tvSesi.setText(Integer.toString(d.getSesi()));
        holder.tvHari.setText(Integer.toString(d.getHari()));
        holder.tvSks.setText(Integer.toString(d.getSks()));
    }
    @Override
    public int getItemCount() {
        return matkulList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvNama, tvKode, tvSesi, tvHari, tvSks;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNamaMk);
            tvKode = itemView.findViewById(R.id.tvkode);
            tvSesi = itemView.findViewById(R.id.tvSesi);
            tvHari = itemView.findViewById(R.id.tvHari);
            tvSks = itemView.findViewById(R.id.tvSks);
        }
    }
}

