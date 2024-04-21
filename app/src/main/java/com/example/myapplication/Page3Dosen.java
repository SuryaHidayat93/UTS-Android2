package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.Calendar;

public class Page3Dosen extends AppCompatActivity {

    private RelativeLayout contentLayout;
    private LinearLayout sidebarLayout;
    private boolean isSidebarVisible = false;
    private Animation slideAndShrinkInAnimation;
    private Animation slideAndShrinkOutAnimation;

    String[] item = {
            "An-Naba", "An-Naziat", "Abasa", "At-Takwir", "Al-Infitar", "At-Tatfif", "Al-Inshiqaq",
            "Al-Buruj", "At-Tariq", "Al-A'la", "Al-Ghashiyah", "Al-Fajr", "Al-Balad", "Ash-Shams",
            "Al-Lail", "Ad-Duha", "Ash-Sharh", "At-Tin", "Al-Alaq", "Al-Qadr", "Al-Bayyinah",
            "Az-Zalzalah", "Al-Adiyat", "Al-Qariah", "At-Takathur", "Al-Asr", "Al-Humazah",
            "Al-Fil", "Quraish", "Al-Ma'un", "Al-Kawthar", "Al-Kafirun", "An-Nasr", "Al-Masad",
            "Al-Ikhlas", "Al-Falaq", "An-Nas"
    };

    String [] status = {"Selesai", "Mengulang"};

    AutoCompleteTextView autoCompleteTextView2;
    ArrayAdapter<String> Adapterstatus;

    AutoCompleteTextView autoCompleteTextView;

    ArrayAdapter<String> AdapterItems;


    private ArrayList<String> dateOptionsList;

    @SuppressLint({"MissingInflatedId", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3_dosen);

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

        // Menambahkan onClickListener ke tombol untuk menyembunyikan sidebar
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
                Intent intent = new Intent(Page3Dosen.this, Page1Dosen.class);
                startActivity(intent);
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) AutoCompleteTextView dateAutoCompleteTextView = findViewById(R.id.dateAutoCompleteTextView);
        dateOptionsList = generateDateOptionsList();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, dateOptionsList);
        dateAutoCompleteTextView.setAdapter(adapter);

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView2);
        AdapterItems = new ArrayAdapter<String>(this,R.layout.dropdown_menu, item);

        autoCompleteTextView.setAdapter(AdapterItems);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(Page3Dosen.this,"item"+item, Toast.LENGTH_SHORT).show();
            }
        });

        autoCompleteTextView2 = findViewById(R.id.autoCompleteTextViewstatus);
        Adapterstatus = new ArrayAdapter<String>(this,R.layout.dropdown_menu, status);

        autoCompleteTextView2.setAdapter((Adapterstatus));

        autoCompleteTextView2.setOnItemClickListener((new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String status = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(Page3Dosen.this,"Status: "+status,Toast.LENGTH_SHORT).show();
            }

        }
        ));

        View btnback = findViewById(R.id.arrowback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Page3Dosen.this, Page2Dosen.class);
                startActivity(intent);
            }
        });
        hideSidebar();
    }

    private ArrayList<String> generateDateOptionsList() {
        ArrayList<String> options = new ArrayList<>();
        for (int i = 1; i <= 31; i++) {
            for (String month : getMonths()) {
                for (String year : getYears()) {
                    options.add(i + " " + month + " " + year);
                }
            }
        }
        return options;
    }

    private String[] getMonths() {
        return new String[]{"Januari", "Februari", "Maret", "April", "Mei", "Juni",
                "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
    }

    private String[] getYears() {
        ArrayList<String> years = new ArrayList<>();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 2023; i <= currentYear; i++) {
            years.add(String.valueOf(i));
        }
        return years.toArray(new String[0]);
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


