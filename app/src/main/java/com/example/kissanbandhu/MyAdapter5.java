package com.example.kissanbandhu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MyAdapter5 extends RecyclerView.Adapter<MyAdapter5.MyViewHolder> {

    Context context;
    ArrayList<seller_rentorderschema> list;
    public MyAdapter5(Context context, ArrayList<seller_rentorderschema> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_sell,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        seller_rentorderschema order = list.get(position);
        holder.name.setText(order.getTool());
        holder.Price.setText(order.getPrice());
        holder.Duration.setText(order.getDays());
        holder.add.setText(order.getAddress());
        holder.buynumb.setText(order.getBuyer_number());
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name, Duration, Price, buynumb,add;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name= itemView.findViewById(R.id.osname);
            Price = itemView.findViewById(R.id.osprice);
            Duration = itemView.findViewById(R.id.osduration);
            buynumb = itemView.findViewById(R.id.osnumber);
            add = itemView.findViewById(R.id.osaddress);

            //Contact_no = itemView.findViewById(R.id.onumber);
        }
    }

}