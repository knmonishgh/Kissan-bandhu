package com.example.kissanbandhu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;

public class homepage extends AppCompatActivity {
      private Button bt1,bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#23863B")));
        bt1 = findViewById(R.id.button3);
        bt1.setOnClickListener(view -> {

            Intent i = new Intent(homepage.this, buyerlogin.class);
            startActivity(i);
        });
        bt2 = findViewById(R.id.button4);
        bt2.setOnClickListener(view -> {

            Intent i = new Intent(homepage.this, sellerlogin.class);
            startActivity(i);
        });

    }
}