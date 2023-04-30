package com.example.kissanbandhu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class seller_addtrac extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    Button btn1;
    FirebaseDatabase database;
    DatabaseReference tracRef;
    String phone;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_addtrac);
        getSupportActionBar().setTitle("SELLER");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#23863B")));


        ed1 = findViewById(R.id.Tractor_name);
        ed2 = findViewById(R.id.Dealer_name);
        ed3 = findViewById(R.id.Cost_perday);
        btn1 = findViewById(R.id.Add_stock);


        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        phone = currentUser.getPhoneNumber();
        database = FirebaseDatabase.getInstance();
        tracRef = database.getReference("Tractors");

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getTracname = ed1.getText().toString();
                String getDealname = ed2.getText().toString();
                String getCost = ed3.getText().toString();
                String key = tracRef.push().getKey();

                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("Tractor", getTracname);
                hashMap.put("Dealer", getDealname);
                hashMap.put("Price", getCost);
                hashMap.put("Contact_no", phone);

                tracRef.child(key).setValue(hashMap);

                Toast.makeText(seller_addtrac.this, "Stock Added", Toast.LENGTH_SHORT).show();

            }
        });
    }
}