package com.fgt.baron.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.fgt.baron.R;
import com.fgt.baron.model.tutorialModel;

import java.util.List;

public class pagerTutorial extends PagerAdapter {
    private List<tutorialModel> models;
    private Context context;
    private LayoutInflater layoutInflater;

    public pagerTutorial(List<tutorialModel> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_tutorial, container, false);
        ImageView imageView;
        imageView = view.findViewById(R.id.imgTutorial);

        imageView.setImageResource(models.get(position).getGambar());
        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
