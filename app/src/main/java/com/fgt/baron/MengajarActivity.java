package com.fgt.baron;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.fgt.baron.adapter.pagerMengajarAdapter;
import com.fgt.baron.model.pagerModel;

import java.util.ArrayList;
import java.util.List;

public class MengajarActivity extends AppCompatActivity {

    ViewPager viewPager;
    pagerMengajarAdapter adapter;
    List<pagerModel> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mengajar);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
        action();
    }

    private void init() {
        models = new ArrayList<>();
        models.add(new pagerModel(R.drawable.ppt0));
        models.add(new pagerModel(R.drawable.ppt1));
        models.add(new pagerModel(R.drawable.ppt2));
        models.add(new pagerModel(R.drawable.ppt3));
        models.add(new pagerModel(R.drawable.ppt4));
        models.add(new pagerModel(R.drawable.ppt5));
        models.add(new pagerModel(R.drawable.ppt6));
        models.add(new pagerModel(R.drawable.ppt7));
        models.add(new pagerModel(R.drawable.ppt8));

        adapter = new pagerMengajarAdapter(models, this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(200,0,200,0);
    }

    private void action() {
       viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int postionOffestPixels) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
