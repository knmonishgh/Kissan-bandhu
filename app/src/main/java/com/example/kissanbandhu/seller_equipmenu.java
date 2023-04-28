package com.example.kissanbandhu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;

public class seller_equipmenu extends AppCompatActivity {
    private Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_equipmenu);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#23863B")));
        bt1 = findViewById(R.id.Tractor);
        bt1.setOnClickListener(view -> {

            Intent i = new Intent(seller_equipmenu.this, seller_equiprenttrac.class);
            startActivity(i);
        });


    }
}