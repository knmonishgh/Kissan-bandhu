package com.example.kissanbandhu;

import static android.service.controls.ControlsProviderService.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class buyer_enterdetails extends AppCompatActivity {

    BottomNavigationView nav;

    TextView tool;
    FirebaseDatabase database;
    DatabaseReference productNameRef;

    private Button mStartDateButton;
    private Button mEndDateButton;
    private TextView mDurationTextView;

    private Calendar mStartCalendar;
    private Calendar mEndCalendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_enterdetails);
        getSupportActionBar().setTitle("BUYER");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#547AE1")));
        nav = findViewById(R.id.nav);
        tool = findViewById(R.id.tool_name);
        mStartDateButton = findViewById(R.id.start_date_button);
        mEndDateButton = findViewById(R.id.end_date_button);
        mDurationTextView = findViewById(R.id.duration_textview);
        mDurationTextView = findViewById(R.id.duration_textview);

        database = FirebaseDatabase.getInstance();
        productNameRef = database.getReference("Selected_item/NewItem");
        productNameRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String productName = snapshot.getValue(String.class);
                tool.setText(productName);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        nav.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.homenav:
                        startActivity(new Intent(buyer_enterdetails.this, buyerhomepage.class));
                        break;
                    case R.id.cartnav:
                        startActivity(new Intent(buyer_enterdetails.this, rentcart.class));
                        break;
                    case R.id.ordersnav:
                        startActivity(new Intent(buyer_enterdetails.this, orders.class));
                        break;
                }
            }
        });

        mStartDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog(true);
            }
        });

        mEndDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog(false);
            }
        });
    }

    private void showDatePickerDialog(final boolean isStartDate) {
        // Get the current date
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        // Show the date picker dialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(buyer_enterdetails.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        // Update the selected date
                        Calendar selectedCalendar = Calendar.getInstance();
                        selectedCalendar.set(year, month, day);

                        if (isStartDate) {
                            mStartCalendar = selectedCalendar;
                        } else {
                            mEndCalendar = selectedCalendar;
                        }

                        // Calculate the duration and display it
                        if (mStartCalendar != null && mEndCalendar != null) {
                            long durationMillis = mEndCalendar.getTimeInMillis() - mStartCalendar.getTimeInMillis();
                            int durationDays = (int) TimeUnit.MILLISECONDS.toDays(durationMillis);

                            mDurationTextView.setText("Duration: " + durationDays + " days");
                        }
                    }
                }, year, month, dayOfMonth);

    }
}
