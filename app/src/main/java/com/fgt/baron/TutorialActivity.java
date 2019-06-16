package com.fgt.baron;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fgt.baron.adapter.pagerTutorial;
import com.fgt.baron.model.tutorialModel;

import java.util.ArrayList;
import java.util.List;

public class TutorialActivity extends AppCompatActivity {

    List<tutorialModel> modelList;
    pagerTutorial adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        modelList = new ArrayList<>();

        modelList.add(new tutorialModel(R.drawable.tutorial1));
        modelList.add(new tutorialModel(R.drawable.tutorial2));
        modelList.add(new tutorialModel(R.drawable.tutorial3));
        modelList.add(new tutorialModel(R.drawable.tutorial4));

        adapter = new pagerTutorial(modelList, this);
        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
    }
}
