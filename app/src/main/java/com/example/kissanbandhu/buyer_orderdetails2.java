package com.example.kissanbandhu;

import static android.service.controls.ControlsProviderService.TAG;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class buyer_orderdetails2 extends AppCompatActivity {

    BottomNavigationView nav;
    TextView stool, sprice, sname, snum;
    FirebaseDatabase database;
    DatabaseReference stoolRef, spriceRef, snameRef, snumRef, orderRef;
    String seedtool, seedprice, seeddealer, seednumber, phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_orderdetails2);
        getSupportActionBar().setTitle("ORDER DETAILS");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#23863B")));
        nav = findViewById(R.id.nav);
        stool = findViewById(R.id.sdtoolname);
        sprice = findViewById(R.id.sdprice_rs);
        sname = findViewById(R.id.sddealer_name);
        snum = findViewById(R.id.sddealer_contact);

        database = FirebaseDatabase.getInstance();
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        phone = currentUser.getPhoneNumber();
        database = FirebaseDatabase.getInstance();

        stoolRef = database.getReference("Selected_item2/NewItem2");
        stoolRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                seedtool = snapshot.getValue(String.class);
                stool.setText(seedtool);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        spriceRef = database.getReference("Selected_item2/NewPrice2");
        spriceRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                seedprice = snapshot.getValue(String.class);
                sprice.setText(seedprice);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        snameRef = database.getReference("Selected_item2/NewDealer2");
        snameRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                seeddealer = snapshot.getValue(String.class);
                sname.setText(seeddealer);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        snumRef = database.getReference("Selected_item2/NewNumber2");
        snumRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                seednumber = snapshot.getValue(String.class);
                snum.setText(seednumber);
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
                        startActivity(new Intent(buyer_orderdetails2.this,buyerhomepage.class));
                        break;
                    case R.id.ordersnav:
                        startActivity(new Intent(buyer_orderdetails2.this,orders.class));
                        break;
                }
            }
        });


    }
}