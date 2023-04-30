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

public class seller_buymenu extends AppCompatActivity {

    BottomNavigationView nav;
    private Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_buymenu);
        getSupportActionBar().setTitle("SELLER");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#23863B")));
        nav = findViewById(R.id.nav);
        bt1 = findViewById(R.id.Tractor);
        bt1.setOnClickListener(view -> {

            Intent i = new Intent(seller_buymenu.this, seller_addtrac.class);
            startActivity(i);
        });

        nav.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.homenav:
                        startActivity(new Intent(seller_buymenu.this,sellerhome.class));
                        break;
                    case R.id.ordersnav:
                        startActivity(new Intent(seller_buymenu.this,orders2.class));
                        break;
                }
            }
        });
    }
}