package com.example.kissanbandhu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class buyer_orderdetails extends AppCompatActivity {
    BottomNavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_orderdetails);
        getSupportActionBar().setTitle("ORDER DETAILS");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#547AE1")));
        nav = findViewById(R.id.nav);
        nav.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.homenav:
                        startActivity(new Intent(buyer_orderdetails.this,buyerhomepage.class));
                        break;
                    case R.id.cartnav:
                        startActivity(new Intent(buyer_orderdetails.this,rentcart.class));
                        break;
                    case R.id.ordersnav:
                        startActivity(new Intent(buyer_orderdetails.this,orders.class));
                        break;
                }
            }
        });
    }
}