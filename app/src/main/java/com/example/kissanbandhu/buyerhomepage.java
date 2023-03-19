package com.example.kissanbandhu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class buyerhomepage extends AppCompatActivity {

    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyerhomepage);
        btn = findViewById(R.id.rent_btn);
        btn.setOnClickListener(view -> {

            Intent i = new Intent(buyerhomepage.this, buyer_rentmenu.class);
            startActivity(i);
        });
    }
}