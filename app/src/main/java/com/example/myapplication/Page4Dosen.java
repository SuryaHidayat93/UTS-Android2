package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class Page4Dosen extends AppCompatActivity {

    ProgressBar progressbar1;
    ProgressBar progressbar2;
    ProgressBar progressbar3;
    ProgressBar progressbar4;

    int counter1 = 0;
    int counter2 = 0;
    int counter3 = 0;
    int counter4 = 0;

    int maxCounter1 = 50; // Batas counter untuk ProgressBar 1
    int maxCounter2 = 70; // Batas counter untuk ProgressBar 2
    int maxCounter3 = 80; // Batas counter untuk ProgressBar 3
    int maxCounter4 = 90; // Batas counter untuk ProgressBar 4

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4_dosen);

        // Inisialisasi ProgressBar
        progressbar1 = findViewById(R.id.progressbar1);
        progressbar2 = findViewById(R.id.progressbar2);
        progressbar3 = findViewById(R.id.progressbar3);
        progressbar4 = findViewById(R.id.progressbar4);

        // Memulai ProgressBar
        startProgressBar(progressbar1, maxCounter1);
        startProgressBar(progressbar2, maxCounter2);
        startProgressBar(progressbar3, maxCounter3);
        startProgressBar(progressbar4, maxCounter4);

        View btnback = findViewById(R.id.arrowback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Page4Dosen.this, Page2Dosen.class);
                startActivity(intent);
            }
        });
    }

    // Method untuk memulai ProgressBar
    private void startProgressBar(final ProgressBar progressBar, final int maxCounter) {
        final Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // Menambah nilai counter
                        if (progressBar.getProgress() < maxCounter) {
                            progressBar.setProgress(progressBar.getProgress() + 1);
                        }

                        // Jika counter mencapai batas, hentikan Timer
                        if (progressBar.getProgress() == maxCounter)
                            t.cancel();
                    }
                });
            }
        };

        // Menentukan interval TimerTask berdasarkan nilai maksimum counter
        // Semakin tinggi nilai maxCounter, semakin cepat intervalnya
        long interval = 500 / maxCounter; // Misalnya, interval default 500ms dibagi dengan maxCounter

        // Menjadwalkan TimerTask untuk dijalankan dengan interval yang telah dihitung
        t.schedule(tt, 0, interval);
    }
}
