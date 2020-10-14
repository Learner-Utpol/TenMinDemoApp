package com.example.tenmindemoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.tenmindemoapp.adapter.AdapterForRootList;
import com.example.tenmindemoapp.pojo.Data;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rootRecyclerView;
    private ArrayList<Data> arrayListForRootRecyclerView; //this list will contain data for rootList(It may load from database)
    private AdapterForRootList adapterForRootList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFields();
        getDataForRootRecyclerView();
        initRecyclerView();

    }

    //initialize fields
    private void initFields() {
        rootRecyclerView = findViewById(R.id.rootRecyclerViewID);
        arrayListForRootRecyclerView = new ArrayList<>();
    }

    //prepare data for root recyclerView
    private void getDataForRootRecyclerView() {
        for (int i = 1; i<=5; i++){
            String name = "Chapter "+i;
            Data data = new Data(name, R.drawable.ic_chapter, true);
            arrayListForRootRecyclerView.add(data);
        }
        for (int i = 1; i<=2; i++){
            String name = "Video "+i;
            Data data = new Data(name, R.drawable.ic_video, false);
            arrayListForRootRecyclerView.add(data);
        }

        for (int i = 1; i<=2; i++){
            String name = "Audio "+i;
            Data data = new Data(name, R.drawable.ic_audio, false);
            arrayListForRootRecyclerView.add(data);
        }


    }

    //initialize recyclerView
    private void initRecyclerView() {
        rootRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapterForRootList = new AdapterForRootList(arrayListForRootRecyclerView, this);
        rootRecyclerView.setAdapter(adapterForRootList);
    }



}