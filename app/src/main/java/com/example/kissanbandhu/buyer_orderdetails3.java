package com.example.kissanbandhu;

import static android.service.controls.ControlsProviderService.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class buyer_orderdetails3 extends AppCompatActivity {

    BottomNavigationView nav;
    TextView pesttool, pestprice, pestdname, pestdnum;
    FirebaseDatabase database;
    DatabaseReference pToolRef, pPriceRef, pDnameRef, pDnumRef;
    String fDname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_orderdetails3);
        getSupportActionBar().setTitle("ORDER DETAILS");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#23863B")));
        nav = findViewById(R.id.nav);
        pesttool = findViewById(R.id.pstoolname);
        pestprice = findViewById(R.id.psprice_rs);
        pestdname = findViewById(R.id.psdealer_name);
        pestdnum = findViewById(R.id.psdealer_contact);

        database = FirebaseDatabase.getInstance();

        pDnameRef = database.getReference("Selected_item/NewDealer");
        pDnameRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                fDname = snapshot.getValue(String.class);
                pestdname.setText(fDname);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
}