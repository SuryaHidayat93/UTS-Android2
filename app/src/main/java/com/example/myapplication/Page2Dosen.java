package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Page2Dosen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2_dosen);

        RecyclerView recyclerView =findViewById(R.id.recyclerView);
        List<MyData2> items2 = new ArrayList<MyData2>();
        items2.add(new MyData2("An-Naba", "20-10-2023", "Selesai"));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter2(getApplicationContext(),items2));
    }
}