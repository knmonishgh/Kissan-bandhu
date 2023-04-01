package com.example.kissanbandhu;

import android.content.Context;
import android.content.Intent;
import android.text.style.TtsSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

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
        holder.RentNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newitem = trac.getTractor();
                String newprice = trac.getPrice();
                FirebaseDatabase.getInstance().getReference("Selected_item").child("NewItem").setValue(newitem);
                FirebaseDatabase.getInstance().getReference("Selected_item").child("NewPrice").setValue(newprice);
                Intent intent = new Intent(context, buyer_enterdetails.class);
                context.startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        Button RentNow;
        TextView Tractor, Dealer, Price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Tractor= itemView.findViewById(R.id.tvfirstName);
            Dealer = itemView.findViewById(R.id.tvlastName);
            Price = itemView.findViewById(R.id.tvage);
            RentNow = itemView.findViewById(R.id.rentnow);
        }
    }

}