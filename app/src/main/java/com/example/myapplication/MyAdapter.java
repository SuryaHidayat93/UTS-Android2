package com.example.myapplication;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<MyData> items;


    public MyAdapter(Context context, List<MyData> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.TextKelas.setText(items.get(position).getKelas());
    holder.TextNama.setText(items.get(position).getNama());
    holder.TextProgress.setText(items.get(position).getProgress());
    holder.TextSemester.setText(items.get(position).getSemester());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
