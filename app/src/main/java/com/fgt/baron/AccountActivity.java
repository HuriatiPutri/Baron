package com.fgt.baron;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.fgt.baron.adapter.pagerAccountAdapter;

public class AccountActivity extends AppCompatActivity implements InformasiFragment.OnFragmentInteractionListener, ContentFragment.OnFragmentInteractionListener, IklanFragment.OnFragmentInteractionListener{

    TabLayout tabLayout;
    ViewPager viewPager;
    pagerAccountAdapter adapter;
    Button btnBack, btnNotif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
        action();
    }

    private void init() {
        btnBack = (Button)findViewById(R.id.btnBack);
        btnNotif = (Button)findViewById(R.id.btnNotif);

        tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Profil & Informasi"));
        tabLayout.addTab(tabLayout.newTab().setText("Kontent"));
        tabLayout.addTab(tabLayout.newTab().setText("Iklan dan penawaran"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = (ViewPager)findViewById(R.id.pager);
        adapter = new pagerAccountAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
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

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goBack = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(goBack);
                finish();
            }
        });


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
