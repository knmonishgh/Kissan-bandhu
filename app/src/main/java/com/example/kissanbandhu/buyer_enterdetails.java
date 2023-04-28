package com.example.kissanbandhu;

import static android.service.controls.ControlsProviderService.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class buyer_enterdetails extends AppCompatActivity {

    BottomNavigationView nav;
    TextView tool;
    FirebaseDatabase database;
    DatabaseReference productNameRef, productPriceRef, dealerRef,orderRef, selectRef;
    Calendar startCal, endCal;
    TextView mstartdate, menddate;
    TextView mprice, testname;
    Button order;
    EditText address;
    String value, productName, dealerName;
    String productPrice;
    String phone;
    long days, calculatedPrice;
    int price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_enterdetails);
        getSupportActionBar().setTitle("BUYER");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#23863B")));
        nav = findViewById(R.id.nav);
        tool = findViewById(R.id.tool_name);

        mstartdate = findViewById(R.id.start_date);
        menddate = findViewById(R.id.end_date);
        mprice = findViewById(R.id.pricecal);
        startCal = Calendar.getInstance();
        endCal = Calendar.getInstance();
        order = findViewById(R.id.order_button);
        address = findViewById(R.id.user_address);
        testname = findViewById(R.id.testname);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        database = FirebaseDatabase.getInstance();
        productNameRef = database.getReference("Selected_item/NewItem");
        orderRef = database.getReference("Orders");
        dealerRef = database.getReference("Selected_item/NewDealer");
        selectRef = database.getReference("Selected_item");

        String phone = currentUser.getPhoneNumber();



        productNameRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                productName = snapshot.getValue(String.class);
                tool.setText(productName);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

       

 productPriceRef = database.getReference("Selected_item/NewPrice");
        productPriceRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                productPrice = snapshot.getValue(String.class);
                price = Integer.parseInt(extractInt(productPrice));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });



        dealerRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dealerName = snapshot.getValue(String.class);
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
                    case R.id.ordersnav:
                        startActivity(new Intent(buyer_enterdetails.this, orders.class));
                        break;
                }
            }
        });


        

        mstartdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showStartDateDialog(buyer_enterdetails.this);
            }
        });

        menddate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEndDateDialog(buyer_enterdetails.this);

            }
        });



        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getAddress = address.getText().toString();
                if (TextUtils.isEmpty(getAddress)){
                    Toast.makeText(buyer_enterdetails.this, "Enter address", Toast.LENGTH_SHORT).show();
                }
                else {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("address", getAddress);
                    hashMap.put("tool", productName);
                    hashMap.put("price", productPrice);
                    hashMap.put("duration", days);
                    hashMap.put("dealer", dealerName);

                    orderRef.child(phone).child(productName).setValue(hashMap);

                    selectRef.child("NewDuration").setValue(Long.toString(days));

                    selectRef.child("NewPrice").setValue("₹" + Long.toString(calculatedPrice));

                    Toast.makeText(buyer_enterdetails.this, "Order Placed", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(buyer_enterdetails.this, buyer_orderdetails.class);
                    startActivity(i);

                    address.setText("");
                }
            }
        });
    }


   private void showStartDateDialog(Context context) {

        int year = startCal.get(Calendar.YEAR);
        int month = startCal.get(Calendar.MONTH);
        int day = startCal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                context,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        startCal.set(year, monthOfYear, dayOfMonth);

                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                        mstartdate.setText(sdf.format(startCal.getTime()));
                    }
                }, year, month, day);

        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datePickerDialog.show();
    }

    private void showEndDateDialog(Context context) {

        int year = endCal.get(Calendar.YEAR);
        int month = endCal.get(Calendar.MONTH);
        int day = endCal.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(
                context,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        endCal.set(year, monthOfYear, dayOfMonth);

                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                        menddate.setText(sdf.format(endCal.getTime()));

                        long durationInMillis = endCal.getTimeInMillis() - startCal.getTimeInMillis();
                        days = TimeUnit.MILLISECONDS.toDays(durationInMillis);
                        calculatedPrice = days * (long)price;

                        mprice.setText("₹ " + calculatedPrice);
                    }
                }, year, month, day);

        datePickerDialog.getDatePicker().setMinDate(startCal.getTimeInMillis());
        datePickerDialog.show();
    }

    static String extractInt(String str)
    {
        str = str.replaceAll("[^0-9]", " ");

        str = str.replaceAll(" +", " ");
        str = str.trim();
        if (str.equals(""))
            return "-1";

        return str;
    }

}

