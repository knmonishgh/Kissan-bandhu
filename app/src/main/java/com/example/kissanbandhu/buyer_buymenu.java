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

public class buyer_buymenu extends AppCompatActivity {

    private Button btnseed;
    BottomNavigationView nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_buymenu);
        getSupportActionBar().setTitle("BUYER");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#23863B")));
        btnseed = findViewById(R.id.seeder);
        nav = findViewById(R.id.nav);
        btnseed.setOnClickListener(view ->
        {
            Intent i = new Intent(buyer_buymenu.this, buyer_productsmenu2.class);
            startActivity(i);
        });

        nav.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.homenav:
                        startActivity(new Intent(buyer_buymenu.this,buyerhomepage.class));
                        break;
                    case R.id.ordersnav:
                        startActivity(new Intent(buyer_buymenu.this,orders.class));
                        break;
                }
            }
        });


    }
}