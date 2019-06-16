package com.fgt.baron.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fgt.baron.DetailActivity;
import com.fgt.baron.R;
import com.fgt.baron.model.pagerModel;

import java.util.List;

public class pagerMengajarAdapter extends PagerAdapter {

    private List<pagerModel> models;
    private LayoutInflater layoutInflater;
    private Context context;

    public pagerMengajarAdapter(List<pagerModel> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        final View view = layoutInflater.inflate(R.layout.item_mengajar, container, false);
        ImageView imageView;
        imageView = view.findViewById(R.id.image);

        imageView.setImageResource(models.get(position).getImage());

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goDetail = new Intent(view.getContext(), DetailActivity.class);
                view.getContext().startActivity(goDetail);
            }
        });

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }


}
