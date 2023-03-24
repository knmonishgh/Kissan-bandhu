package com.example.kissanbandhu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;

    ArrayList<Tractors> list;


    public MyAdapter(Context context, ArrayList<Tractors> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Tractors trac = list.get(position);
        holder.Tractor.setText(trac.getTractor());
        holder.Dealer.setText(trac.getDealer());
        holder.Price.setText(trac.getPrice());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Tractor, Dealer, Price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Tractor= itemView.findViewById(R.id.tvfirstName);
            Dealer = itemView.findViewById(R.id.tvlastName);
            Price = itemView.findViewById(R.id.tvage);

        }
    }

}