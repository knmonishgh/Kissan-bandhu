package com.example.kissanbandhu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class orders2 extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    MyAdapter5 myAdapter5;
    ArrayList<seller_rentorderschema> list;
    BottomNavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        getSupportActionBar().setTitle("ORDERS");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#23863B")));

        recyclerView = findViewById(R.id.orderlist);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        nav = findViewById(R.id.nav);
        list = new ArrayList<>();
        myAdapter5 = new MyAdapter5(this,list);
        recyclerView.setAdapter(myAdapter5);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        String phone = currentUser.getPhoneNumber();
        database = FirebaseDatabase.getInstance().getReference("Orders").child("seller").child("rent").child(phone);


        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){


                    seller_rentorderschema order= dataSnapshot.getValue(seller_rentorderschema.class);
                    list.add(order);



                }
                myAdapter5.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        nav.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.homenav:
                        startActivity(new Intent(orders2.this,sellerhome.class));
                        break;

                    case R.id.ordersnav:
                        startActivity(new Intent(orders2.this,orders2.class));
                        break;
                }
            }
        });



    }
}