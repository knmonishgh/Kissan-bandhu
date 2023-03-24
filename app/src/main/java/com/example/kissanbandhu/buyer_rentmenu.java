package com.example.kissanbandhu;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class buyer_rentmenu extends AppCompatActivity {

    private Button btntrac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_rentmenu);
        getSupportActionBar().setTitle("BUYER");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#547AE1")));
        btntrac = findViewById(R.id.Tractor);
        btntrac.setOnClickListener(view ->
        {
            Intent i = new Intent(buyer_rentmenu.this, buyer_productsmenu.class);
            startActivity(i);
        });

    }
}