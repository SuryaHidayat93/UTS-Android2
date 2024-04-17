package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView TextKelas, TextNama, TextProgress, TextSemester;
    Context context;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        TextKelas = itemView.findViewById(R.id.textKelas);
        TextNama = itemView.findViewById(R.id.textNama);
        TextProgress = itemView.findViewById(R.id.textProgress);
        TextSemester = itemView.findViewById(R.id.textSemester);

        this.context = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (context != null) {
            Intent intent = new Intent(context, Page2Dosen.class);
            context.startActivity(intent);
        }
    }
}


