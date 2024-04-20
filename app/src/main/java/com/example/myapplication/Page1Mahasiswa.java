package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Page1Mahasiswa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1_mahasiswa);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) RecyclerView recyclerView =findViewById(R.id.recyclerView);
        List<MyData2> items2 = new ArrayList<MyData2>();
        items2.add(new MyData2("An-Naba", "20-10-2023", "Selesai"));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter2(getApplicationContext(),items2));

        View btnstatistik = findViewById(R.id.btn1);
        btnstatistik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Page1Mahasiswa.this, Page2Mahasiswa.class);
                startActivity(intent);
            }
        });
    }
}