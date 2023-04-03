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

public class buyer_rentmenu extends AppCompatActivity {

    private Button btntrac;
    BottomNavigationView nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_rentmenu);
        getSupportActionBar().setTitle("BUYER");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#23863B")));
        btntrac = findViewById(R.id.Tractor);
        nav = findViewById(R.id.nav);
        btntrac.setOnClickListener(view ->
        {
            Intent i = new Intent(buyer_rentmenu.this, buyer_productsmenu.class);
            startActivity(i);
        });

        nav.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.homenav:
                        startActivity(new Intent(buyer_rentmenu.this,buyerhomepage.class));
                        break;
                    case R.id.cartnav:
                        startActivity(new Intent(buyer_rentmenu.this,rentcart.class));
                        break;
                    case R.id.ordersnav:
                        startActivity(new Intent(buyer_rentmenu.this,orders.class));
                        break;
                }
            }
        });


    }
}