package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class Page1Mahasiswa extends AppCompatActivity {

    private RelativeLayout contentLayout;
    private LinearLayout sidebarLayout;
    private boolean isSidebarVisible = false;
    private Animation slideAndShrinkInAnimation;
    private Animation slideAndShrinkOutAnimation;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1_mahasiswa);

        contentLayout = findViewById(R.id.content_layout);
        sidebarLayout = findViewById(R.id.sidebar_layout);
        slideAndShrinkInAnimation = AnimationUtils.loadAnimation(this, R.drawable.slide_and_shrink_in);
        slideAndShrinkOutAnimation = AnimationUtils.loadAnimation(this, R.drawable.slide_and_shrink_out);

        findViewById(R.id.btnsidebar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSidebar();
            }
        });

        // Mengatur onClickListener untuk tombol menutup sidebar
        findViewById(R.id.closesidebar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSidebar();
            }
        });

        View tombolhome = findViewById(R.id.btnhome);
        tombolhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ketika tombolSignIn ditekan, pindah ke Page1Dosen
                Intent intent = new Intent(Page1Mahasiswa.this, Page1Mahasiswa.class);
                startActivity(intent);
            }
        });


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
        hideSidebar();
    }
    private void showSidebar() {
        sidebarLayout.startAnimation(slideAndShrinkInAnimation);
        sidebarLayout.setVisibility(View.VISIBLE);
        isSidebarVisible = true;
    }

    private void hideSidebar() {
        sidebarLayout.startAnimation(slideAndShrinkOutAnimation);
        sidebarLayout.setVisibility(View.GONE);
        isSidebarVisible = false;
    }
}
