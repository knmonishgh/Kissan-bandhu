package com.example.kissanbandhu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class homepage extends AppCompatActivity {
      private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        bt = findViewById(R.id.button3);
        bt.setOnClickListener(view -> {

            Intent i = new Intent(homepage.this,buyer.class);
            startActivity(i);
        });

    }
}