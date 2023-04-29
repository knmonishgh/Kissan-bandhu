package com.example.kissanbandhu;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class sellerhome extends AppCompatActivity {

    private Button btn,btn1, btn2;
    BottomNavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyerhomepage);
        btn = findViewById(R.id.equipments);
        btn1 = findViewById(R.id.equipments_buy);
        btn2 = findViewById(R.id.pesticides);
        getSupportActionBar().setTitle("SELLER");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#23863B")));
        btn.setOnClickListener(view -> {
            Intent i = new Intent(sellerhome.this, seller_buymenu.class);
            startActivity(i);
        });
        btn1.setOnClickListener(view -> {
            Intent i = new Intent(sellerhome.this, seller_rentmenu.class);
            startActivity(i);
        });


        btn2.setOnClickListener(view -> {
            Intent i = new Intent(sellerhome.this, seller_buypest.class);
            startActivity(i);
        });
    }
}


