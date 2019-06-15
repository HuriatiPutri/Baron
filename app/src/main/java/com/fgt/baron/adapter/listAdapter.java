package com.fgt.baron.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fgt.baron.R;
import com.fgt.baron.model.listModel;

import java.util.List;

public class listAdapter extends RecyclerView.Adapter<listAdapter.ViewHolder> {

    private Context context;
    private List<listModel> listModels;

    public listAdapter(Context context, List<listModel> listUser) {
        this.context = context;
        this.listModels = listUser;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, viewGroup,false);
        return new listAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final listModel list = listModels.get(i);
        viewHolder.txtNama.setText(list.getNama());
        viewHolder.txtKategori.setText(list.getKategori());
        viewHolder.txtDurasi.setText(list.getDurasi());
        viewHolder.txtHarga.setText(list.getHarga());
    }

    @Override
    public int getItemCount() {
        return listModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgProfile;
        TextView txtNama, txtKategori, txtHarga, txtDurasi;

        public ViewHolder(View itemView){
            super(itemView);
            imgProfile = itemView.findViewById(R.id.imgUser);
            txtNama = itemView.findViewById(R.id.txtNama);
            txtKategori = itemView.findViewById(R.id.txtKategori);
            txtHarga = itemView.findViewById(R.id.txtHarga);
            txtDurasi = itemView.findViewById(R.id.txtDurasi);
        }
    }
}
