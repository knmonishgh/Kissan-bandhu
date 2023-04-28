package com.example.kissanbandhu;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class buyerhomepage extends AppCompatActivity {

    private Button btn, btnbuy1, btnbuy2;
    BottomNavigationView nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyerhomepage);
        btn = findViewById(R.id.equipments);
        btnbuy1 = findViewById(R.id.equipments_buy);
        btnbuy2 = findViewById(R.id.pesticides);
        getSupportActionBar().setTitle("BUYER");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#23863B")));
        btn.setOnClickListener(view -> {
            Intent i = new Intent(buyerhomepage.this, buyer_rentmenu.class);
            startActivity(i);
        });


        btnbuy1.setOnClickListener(view -> {
            Intent i = new Intent(buyerhomepage.this, buyer_buymenu.class);
            startActivity(i);
        });

        btnbuy2.setOnClickListener(view -> {
            Intent i = new Intent(buyerhomepage.this, buyer_buypest.class);
            startActivity(i);
        });

        nav = findViewById(R.id.nav);

        nav.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.homenav:
                        startActivity(new Intent(buyerhomepage.this,buyerhomepage.class));
                        break;
                    case R.id.ordersnav:
                        startActivity(new Intent(buyerhomepage.this,orders.class));
                        break;
                }
            }
        });
    }
}