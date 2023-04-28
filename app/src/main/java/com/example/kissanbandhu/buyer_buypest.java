package com.example.kissanbandhu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class buyer_buypest extends AppCompatActivity {

    private Button btnpest;
    BottomNavigationView nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_buypest);
        getSupportActionBar().setTitle("BUYER");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#23863B")));
        btnpest = findViewById(R.id.atabron);
        nav = findViewById(R.id.nav);
        btnpest.setOnClickListener(view ->
        {
            Intent i = new Intent(buyer_buypest.this, buyer_productsmenu3.class);
            startActivity(i);
        });

        nav.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.homenav:
                        startActivity(new Intent(buyer_buypest.this,buyerhomepage.class));
                        break;
                    case R.id.ordersnav:
                        startActivity(new Intent(buyer_buypest.this,orders.class));
                        break;
                }
            }
        });

    }
}