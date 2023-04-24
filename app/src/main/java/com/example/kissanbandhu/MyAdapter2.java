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

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder> {

    Context context;
    ArrayList<Seeders> list;


    public MyAdapter2(Context context, ArrayList<Seeders> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item2,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Seeders seed = list.get(position);
        holder.Seeder.setText(seed.getSeeder());
        holder.Dealer.setText(seed.getDealer());
        holder.Price.setText(seed.getPrice());
        holder.OrderNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newitem2 = seed.getSeeder();
                String newdealer2 = seed.getDealer();
                String newprice2 = seed.getPrice();
                FirebaseDatabase.getInstance().getReference("Selected_item2").child("NewItem2").setValue(newitem2);
                FirebaseDatabase.getInstance().getReference("Selected_item2").child("NewPrice2").setValue(newprice2);
                FirebaseDatabase.getInstance().getReference("Selected_item2").child("NewDealer2").setValue(newdealer2);

                Intent intent = new Intent(context, buyer_buyorder_details.class);
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
        TextView Seeder, Dealer, Price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Seeder= itemView.findViewById(R.id.sdfirstName);
            Dealer = itemView.findViewById(R.id.sdlastName);
            Price = itemView.findViewById(R.id.sdage);
            OrderNow = itemView.findViewById(R.id.ordernow);
        }
    }

}