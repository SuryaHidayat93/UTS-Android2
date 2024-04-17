package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Toast; // Import untuk menampilkan pesan toast

import java.util.ArrayList;
import java.util.List;

public class Page1Dosen extends AppCompatActivity {




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1_dosen);

//        View box1= findViewById(R.id.box1);
//        box1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent2= new Intent(Page1Dosen.this, Page2Dosen.class);
//                startActivity(intent2);
//            }
//        });

    RecyclerView recyclerView = findViewById(R.id.recyclerView);
    List <MyData> items = new ArrayList<MyData>();
    items.add(new MyData("Abdul", "A", "80%","5"));
        items.add(new MyData("Abdul", "A", "80%","5"));
        items.add(new MyData("Abdul", "A", "80%","5"));
        items.add(new MyData("Abdul", "A", "80%","5"));
        items.add(new MyData("Abdul", "A", "80%","5"));
        items.add(new MyData("Abdul", "A", "80%","5"));
        items.add(new MyData("Abdul", "A", "80%","5"));
        items.add(new MyData("Abdul", "A", "80%","5"));
        items.add(new MyData("Abdul", "A", "80%","5"));
        items.add(new MyData("Abdul", "A", "80%","5"));
        items.add(new MyData("Abdul", "A", "80%","5"));



    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(new MyAdapter(getApplicationContext(), items));
    }
}
