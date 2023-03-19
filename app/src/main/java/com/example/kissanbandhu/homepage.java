package com.example.kissanbandhu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;

public class homepage extends AppCompatActivity {
      private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#23863B")));
        bt = findViewById(R.id.button3);
        bt.setOnClickListener(view -> {

            Intent i = new Intent(homepage.this, buyerlogin.class);
            startActivity(i);
        });

    }
}