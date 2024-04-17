package com.example.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder2 extends RecyclerView.ViewHolder {

    TextView textsurah, texttanggal, textstatus;
    public MyViewHolder2(@NonNull View itemView) {
        super(itemView);

        textsurah = itemView.findViewById(R.id.namasurah);
        texttanggal = itemView.findViewById(R.id.tanggal);
        textstatus = itemView.findViewById(R.id.status);

    }
}
