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
import com.fgt.baron.model.listTrendingModel;

import java.util.ArrayList;

public class listTrendingAdapter extends RecyclerView.Adapter<listTrendingAdapter.listTrendingViewHolder> {

    private ArrayList<listTrendingModel> dataList;

    public listTrendingAdapter(ArrayList<listTrendingModel> dataList) {
        this.dataList = dataList;
    }

    @Override
    public listTrendingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list_trending, parent, false);
        return new listTrendingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final listTrendingViewHolder holder, final int position) {
        holder.textUser.setText(dataList.get(position).getUser());
        holder.textTitle.setText(dataList.get(position).getTitle());
        holder.textCategory.setText(dataList.get(position).getCategory());

        holder.listTrending.setOnClickListener(new View.OnClickListener() {
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

    public class listTrendingViewHolder extends RecyclerView.ViewHolder{
        private TextView textCategory, textUser, textTitle;
        private RelativeLayout listTrending;

        public listTrendingViewHolder(View itemView) {
            super(itemView);
            textUser = (TextView) itemView.findViewById(R.id.textUser);
            textTitle = (TextView) itemView.findViewById(R.id.textTitle);
            textCategory = (TextView) itemView.findViewById(R.id.textCategory);
            listTrending = (RelativeLayout) itemView.findViewById(R.id.listTrending);
        }

    }
}
