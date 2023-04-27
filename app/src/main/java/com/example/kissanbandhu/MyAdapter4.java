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

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MyAdapter4 extends RecyclerView.Adapter<MyAdapter4.MyViewHolder> {

    Context context;
    ArrayList<orderschema> list;


    public MyAdapter4(Context context, ArrayList<orderschema> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item4,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        orderschema order = list.get(position);
        holder.name.setText(order.getTool());
        holder.Dealer.setText(order.getDealer());
        holder.Price.setText(order.getPrice());
        //holder.Contact_no.setText(order.getContact_no());


    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        Button OrderNow;
        TextView name, Dealer, Price, Contact_no;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name= itemView.findViewById(R.id.oname);
            Dealer = itemView.findViewById(R.id.odealer);
            Price = itemView.findViewById(R.id.oprice);
            //Contact_no = itemView.findViewById(R.id.onumber);
        }
    }

}