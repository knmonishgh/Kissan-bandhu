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

public class MyAdapter3 extends RecyclerView.Adapter<MyAdapter3.MyViewHolder> {

    Context context;
    ArrayList<Pesticides> list;


    public MyAdapter3(Context context, ArrayList<Pesticides> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item3,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Pesticides pest = list.get(position);
        holder.Fertilizer.setText(pest.getFertilizer());
        holder.Dealer.setText(pest.getDealer());
        holder.Price.setText(pest.getPrice());
        holder.Contact_no.setText(pest.getContact_no());
        holder.OrderNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newitem3 = pest.getFertilizer();
                String newdealer3 =pest.getDealer();
                String newprice3 = pest.getPrice();
                String newnumber3 = pest.getContact_no();
                FirebaseDatabase.getInstance().getReference("Selected_item3").child("NewItem3").setValue(newitem3);
                FirebaseDatabase.getInstance().getReference("Selected_item3").child("NewPrice3").setValue(newprice3);
                FirebaseDatabase.getInstance().getReference("Selected_item3").child("NewDealer3").setValue(newdealer3);
                FirebaseDatabase.getInstance().getReference("Selected_item3").child("NewNumber3").setValue(newnumber3);

                Intent intent = new Intent(context, buyer_orderdetails3.class);
                context.startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        Button OrderNow;
        TextView Fertilizer, Dealer, Price, Contact_no;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Fertilizer= itemView.findViewById(R.id.psfirstName);
            Dealer = itemView.findViewById(R.id.pslastName);
            Price = itemView.findViewById(R.id.psage);
            Contact_no = itemView.findViewById(R.id.psnumber);
            OrderNow = itemView.findViewById(R.id.ordernow);
        }
    }

}