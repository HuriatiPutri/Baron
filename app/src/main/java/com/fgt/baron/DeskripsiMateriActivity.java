package com.fgt.baron;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.Button;

import com.fgt.baron.adapter.pagerMateriAdapter;

public class DeskripsiMateriActivity extends AppCompatActivity implements TextMateriFragment.OnFragmentInteractionListener, VideoMateriFragment.OnFragmentInteractionListener, VrMateriFragment.OnFragmentInteractionListener, ArMateriFragment.OnFragmentInteractionListener{

    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);
    TabLayout tabLayout;
    ViewPager viewPager;
    pagerMateriAdapter adapter;
    Button btnBelajar, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskripsi_materi);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
        action();
    }

    private void init() {
        tabLayout = (TabLayout)findViewById(R.id.tablayout);
        btnBelajar = (Button)findViewById(R.id.btnBelajar);
        btnBack = (Button)findViewById(R.id.btnBack);
        tabLayout.addTab(tabLayout.newTab().setText("Text"));
        tabLayout.addTab(tabLayout.newTab().setText("Vids"));
        tabLayout.addTab(tabLayout.newTab().setText("VR"));
        tabLayout.addTab(tabLayout.newTab().setText("AR"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = (ViewPager)findViewById(R.id.pager);
        adapter = new pagerMateriAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    private void action() {
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        btnBelajar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnBelajar.startAnimation(buttonClick);
                Intent goChange = new Intent(getApplicationContext(), ChangeActivity.class);
                startActivity(goChange);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnBack.startAnimation(buttonClick);
                Intent goList = new Intent(getApplicationContext(), ListMateriActivity.class);
                startActivity(goList);
                finish();
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        
    }
}
