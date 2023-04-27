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

public class buyer_orderdetails3 extends AppCompatActivity {

    BottomNavigationView nav;
    TextView ptool, pprice, pname, pnum;
    FirebaseDatabase database;
    DatabaseReference ptoolRef, ppriceRef, pnameRef, pnumRef;
    String pesticide, cost, dealer, number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_orderdetails3);
        getSupportActionBar().setTitle("ORDER DETAILS");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#23863B")));
        nav = findViewById(R.id.nav);
        ptool = findViewById(R.id.pestname);
        pprice = findViewById(R.id.pestprice);
        pname = findViewById(R.id.dealname);
        pnum = findViewById(R.id.dealcontact);


        database = FirebaseDatabase.getInstance();


        ptoolRef = database.getReference("Selected_item3/NewItem3");
        ptoolRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                pesticide = snapshot.getValue(String.class);
                ptool.setText(pesticide);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        ppriceRef = database.getReference("Selected_item3/NewPrice3");
        ppriceRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                cost = snapshot.getValue(String.class);
                pprice.setText(cost);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        pnameRef = database.getReference("Selected_item3/NewDealer3");
        pnameRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dealer = snapshot.getValue(String.class);
                pname.setText(dealer);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        pnumRef = database.getReference("Selected_item3/NewNumber3");
        pnumRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                number = snapshot.getValue(String.class);
                pnum.setText(number);
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
                        startActivity(new Intent(buyer_orderdetails3.this,buyerhomepage.class));
                        break;

                    case R.id.ordersnav:
                        startActivity(new Intent(buyer_orderdetails3.this,orders.class));
                        break;
                }
            }
        });
    }
}