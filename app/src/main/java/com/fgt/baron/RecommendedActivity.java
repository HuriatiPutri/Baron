package com.fgt.baron;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.fgt.baron.adapter.listTrendingAdapter;
import com.fgt.baron.model.listTrendingModel;

import java.util.ArrayList;

public class RecommendedActivity extends AppCompatActivity {

    TextView textPopular, textTrending;
    ImageView imgProfile;
    private RecyclerView recyclerView;
    private listTrendingAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    private ArrayList<listTrendingModel> listTrendingArrayList;
    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommended);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
        action();
    }

    private void init() {
        imgProfile = (ImageView)findViewById(R.id.imgProfile);
        textPopular = (TextView)findViewById(R.id.textPopular);
        textTrending = (TextView)findViewById(R.id.textTrending);

        addData();

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);

        adapter = new listTrendingAdapter(listTrendingArrayList);

        layoutManager = new LinearLayoutManager(getApplicationContext());
        //layoutManager = new GridLayoutManager(getApplicationContext(),3);

        layoutManager.setAutoMeasureEnabled(true);

        recyclerView.setHasFixedSize(false);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }


    void addData(){
        listTrendingArrayList = new ArrayList<>();
        listTrendingArrayList.add(new listTrendingModel("Programming","Sertifikasi Java","Frisdiandi Septiatama"));
        listTrendingArrayList.add(new listTrendingModel("Memasak","Try Out CPNS","Putri Huriati"));
        listTrendingArrayList.add(new listTrendingModel("Desainer","Sertifikasi Adobe XD","A.Syauli Nadima"));
    }

    private void action() {
        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgProfile.startAnimation(buttonClick);
                Intent goProfile = new Intent(getApplicationContext(), AccountActivity.class);
                startActivity(goProfile);
            }
        });

        textPopular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textPopular.setAnimation(buttonClick);
                Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(i);
            }
        });

        textTrending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textTrending.setAnimation(buttonClick);
                Intent i = new Intent(getApplicationContext(), TrendingActivity.class);
                startActivity(i);
            }
        });
    }
}

