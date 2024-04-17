package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter2 extends RecyclerView.Adapter<MyViewHolder2> {
    Context context;
    List<MyData2> items2;

    public MyAdapter2(Context context, List<MyData2> items2) {
        this.context = context;
        this.items2 = items2;
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder2(LayoutInflater.from(context).inflate(R.layout.item_view2, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {
        holder.textsurah.setText(items2.get(position).getSurah());
        holder.textstatus.setText(items2.get(position).getStatus());
        holder.texttanggal.setText(items2.get(position).getTanggal());
    }

    @Override
    public int getItemCount() {
        return items2.size();
    }
}
