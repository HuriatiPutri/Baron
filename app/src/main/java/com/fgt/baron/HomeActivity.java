package com.fgt.baron;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.fgt.baron.adapter.pagerAdapter;
import com.fgt.baron.model.pagerModel;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);
    ImageView imgProfile;
    ViewPager viewPager;
    pagerAdapter adapter;
    List<pagerModel> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
        action();
    }

    private void init() {
        imgProfile = (ImageView)findViewById(R.id.imgProfile);

        models = new ArrayList<>();
        models.add(new pagerModel(R.drawable.pager4));
        models.add(new pagerModel(R.drawable.pager3));
        models.add(new pagerModel(R.drawable.pager2));
        models.add(new pagerModel(R.drawable.pager1));

        adapter = new pagerAdapter(models, this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(200,0,200,0);
    }

    private void action() {
        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgProfile.startAnimation(buttonClick);
                Intent goProfile = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(goProfile);
            }
        });

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
