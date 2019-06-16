package com.fgt.baron.adapter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fgt.baron.DeskripsiMateriActivity;
import com.fgt.baron.R;
import com.fgt.baron.model.listMateriModel;

import java.util.ArrayList;

public class listMateriAdapter extends RecyclerView.Adapter<listMateriAdapter.listMateriViewHolder> {

    private ArrayList<listMateriModel> dataList;

    public listMateriAdapter(ArrayList<listMateriModel> dataList) {
        this.dataList = dataList;
    }

    @Override
    public listMateriViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list_materi, parent, false);
        return new listMateriViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final listMateriViewHolder holder, final int position) {
        holder.textUser.setText(dataList.get(position).getTextUser());
        holder.textTitle.setText(dataList.get(position).getTextTitle());
        holder.imgProfile.setImageResource(dataList.get(position).getImgProfile());
        holder.imgContent.setImageResource(dataList.get(position).getImgContent());

        holder.listMateri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goDetail = new Intent(v.getContext(), DeskripsiMateriActivity.class);
                v.getContext().startActivity(goDetail);
            }
        });

    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class listMateriViewHolder extends RecyclerView.ViewHolder{
        private TextView textUser, textTitle;
        private ImageView imgProfile, imgContent;
        private RelativeLayout listMateri;

        public listMateriViewHolder(View itemView) {
            super(itemView);
            textUser = (TextView) itemView.findViewById(R.id.textUser);
            textTitle = (TextView) itemView.findViewById(R.id.textTitle);
            listMateri = (RelativeLayout) itemView.findViewById(R.id.listMateri);
            imgProfile = (ImageView) itemView.findViewById(R.id.imgProfile);
            imgContent = (ImageView) itemView.findViewById(R.id.imgContent);
        }

    }
}

