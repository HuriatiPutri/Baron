package com.fgt.baron;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;

import com.fgt.baron.adapter.listMateriAdapter;
import com.fgt.baron.model.listMateriModel;

import java.util.ArrayList;

public class ListMateriActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private listMateriAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    private ArrayList<listMateriModel> listMateriArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_materi);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
    }

    private void init() {
        addData();

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);

        adapter = new listMateriAdapter(listMateriArrayList);

        layoutManager = new LinearLayoutManager(getApplicationContext());
        //layoutManager = new GridLayoutManager(getApplicationContext(),3);

        layoutManager.setAutoMeasureEnabled(true);

        recyclerView.setHasFixedSize(false);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }

    void addData(){
        listMateriArrayList = new ArrayList<>();
        listMateriArrayList.add(new listMateriModel(R.drawable.ic_img_people1,R.drawable.ic_img_content,"Dr.Bima","Kesehatan Ibu Hamil"));
        listMateriArrayList.add(new listMateriModel(R.drawable.ic_img_people2,R.drawable.ic_img_content,"Dr.Winda","Ilmu Jantung"));
        listMateriArrayList.add(new listMateriModel(R.drawable.ic_img_people1,R.drawable.ic_img_content,"Dr.Dandi","Belajar Hati"));
        listMateriArrayList.add(new listMateriModel(R.drawable.ic_img_people2,R.drawable.ic_img_content,"Dr.Putri","Organ Dalam"));
    }
}
