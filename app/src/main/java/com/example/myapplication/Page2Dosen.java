package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

        View btninput = findViewById(R.id.btninput);
        btninput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ketika tombolSignIn ditekan, pindah ke Page1Dosen
                Intent intent = new Intent(Page2Dosen.this, Page3Dosen.class);
                startActivity(intent);
            }
        });

        View btnstatistik = findViewById(R.id.btnstatistik);
        btnstatistik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Page2Dosen.this, Page4Dosen.class);
                startActivity(intent);
            }
        });
    }
}