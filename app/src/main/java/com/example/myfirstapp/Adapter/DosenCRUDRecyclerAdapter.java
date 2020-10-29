package com.example.myfirstapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfirstapp.Model.Dosen;
import com.example.myfirstapp.R;

import java.util.ArrayList;
import java.util.List;

public class DosenCRUDRecyclerAdapter extends RecyclerView.Adapter<DosenCRUDRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<Dosen> dosenList;

    public DosenCRUDRecyclerAdapter(Context context) {
        this.context = context;
        dosenList = new ArrayList<>();
    }

    public DosenCRUDRecyclerAdapter(List<Dosen> dosenList) {
        this.dosenList = dosenList;
    }

    public List<Dosen> getDosenList() {
        return dosenList;
    }

    public void setDosenList(List<Dosen> dosenList) {
        this.dosenList = dosenList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_list_cardview_dosen,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Dosen d = dosenList.get(position);

        holder.tvNama.setText(d.getNama());
        holder.tvNidn.setText(d.getNidn());
        holder.tvAlamat.setText(d.getAlamat());
        holder.tvEmail.setText(d.getEmail());
        holder.tvGelar.setText(d.getGelar());

    }
    @Override
    public int getItemCount() {
        return dosenList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvNama, tvNidn,tvAlamat, tvEmail, tvGelar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNamaMk);
            tvNidn = itemView.findViewById(R.id.tvNidn);
            tvAlamat = itemView.findViewById(R.id.tvAlamat);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvGelar = itemView.findViewById(R.id.tvGelar);
        }
    }
}

