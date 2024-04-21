package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Page1Dosen extends AppCompatActivity {

    private RelativeLayout contentLayout;
    private LinearLayout sidebarLayout;
    private boolean isSidebarVisible = false;
    private Animation slideAndShrinkInAnimation;
    private Animation slideAndShrinkOutAnimation;

    @SuppressLint({"WrongViewCast", "ResourceType"})

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1_dosen);

        // Inisialisasi tampilan dan animasi
        contentLayout = findViewById(R.id.content_layout);
        sidebarLayout = findViewById(R.id.sidebar_layout);
        slideAndShrinkInAnimation = AnimationUtils.loadAnimation(this, R.drawable.slide_and_shrink_in);
        slideAndShrinkOutAnimation = AnimationUtils.loadAnimation(this, R.drawable.slide_and_shrink_out);

        // Mengatur onClickListener untuk tombol sidebar
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
                Intent intent = new Intent(Page1Dosen.this, Page1Dosen.class);
                startActivity(intent);
            }
        });

        // Inisialisasi RecyclerView dan adapter
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        List<MyData> items = new ArrayList<MyData>();
        // Menambahkan data dummy
        items.add(new MyData("Abdul", "A", "80%", "5"));
        // ...

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), items));

        // Sembunyikan sidebar saat aplikasi dimulai
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

