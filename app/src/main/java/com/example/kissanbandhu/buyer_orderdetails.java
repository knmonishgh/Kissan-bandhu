package com.example.kissanbandhu;

import static android.service.controls.ControlsProviderService.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class buyer_orderdetails extends AppCompatActivity {
    BottomNavigationView nav;
    TextView ntool, nduration, nprice, dname, dcontact;
    FirebaseDatabase database;
    DatabaseReference productNameRef, durationRef, priceRef, dealerNameRef;
    String dealerName, duration, price, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_orderdetails);
        getSupportActionBar().setTitle("ORDER DETAILS");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#23863B")));
        nav = findViewById(R.id.nav);
        ntool = findViewById(R.id.toolname);
        nduration = findViewById(R.id.duration_days);
        nprice = findViewById(R.id.price_rs);
        dname = findViewById(R.id.dealer_name);
        dcontact = findViewById(R.id.dealer_contact);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        phone = currentUser.getPhoneNumber();
        database = FirebaseDatabase.getInstance();


        productNameRef = database.getReference("Orders").child(phone);

        productNameRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String productName = snapshot.getValue(String.class);
                ntool.setText(productName);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        productNameRef = database.getReference("Selected_item/NewItem");
//
        productNameRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String productName = snapshot.getValue(String.class);
                ntool.setText(productName);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });



        //Duration
        durationRef = database.getReference("Selected_item/NewDealer");
        durationRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                duration = snapshot.getValue(String.class);
                nduration.setText(duration+" days");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });



        //Price
        priceRef = database.getReference("Selected_item/NewPrice");;
        priceRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                price = snapshot.getValue(String.class);
                nprice.setText(price);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        //Dealer Name
        dealerNameRef = database.getReference("Selected_item/NewDealer");
        dealerNameRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dealerName = snapshot.getValue(String.class);
                dname.setText(dealerName);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });



        nav.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.homenav:
                        startActivity(new Intent(buyer_orderdetails.this,buyerhomepage.class));
                        break;

                    case R.id.ordersnav:
                        startActivity(new Intent(buyer_orderdetails.this,orders.class));
                        break;
                }
            }
        });


    }
}