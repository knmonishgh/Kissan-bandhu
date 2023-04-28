package com.example.kissanbandhu;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class buyerlogin extends AppCompatActivity {

    private EditText phone, otp, name;
    private Button btngen, btnverify;
    private FirebaseAuth mAuth;
    private String verificationid;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyerlogin);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#23863B")));
        phone = findViewById(R.id.phone);
        otp = findViewById(R.id.otp);
        name = findViewById(R.id.login_name);
        btngen = findViewById(R.id.genotp_button);
        btnverify = findViewById(R.id.verifyotp_button);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference("buyer_login");

        btngen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(phone.getText().toString())){
                    Toast.makeText(buyerlogin.this, "Enter valid phone number", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(name.getText().toString())){
                    Toast.makeText(buyerlogin.this, "Enter name", Toast.LENGTH_SHORT).show();
                }
                else {
                    String num = phone.getText().toString();
                    sendverificationcode(num);
                }
            }
        });



        btnverify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(otp.getText().toString())){
                    Toast.makeText(buyerlogin.this, "Please enter OTP", Toast.LENGTH_SHORT).show();
                }
                else {
                    verifycode(otp.getText().toString());
                }
            }
        });

    }

    private void sendverificationcode(String phoneNumber) {
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+91 "+phoneNumber)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
            mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential credential) {
            final String code = credential.getSmsCode();
            if(code!=null){
                verifycode(code);
            }
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            Toast.makeText(buyerlogin.this, "Wrong Number", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCodeSent(@NonNull String s,
                               @NonNull PhoneAuthProvider.ForceResendingToken token) {
            super.onCodeSent(s, token);
            verificationid = s;
            Toast.makeText(buyerlogin.this, "OTP Sent", Toast.LENGTH_SHORT).show();
        }
    };


    private void verifycode(String Code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationid, Code);
        signinbycredentials(credential);
    }

    private void signinbycredentials(PhoneAuthCredential credential) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(buyerlogin.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(buyerlogin.this, buyerhomepage.class));
                            String getName = name.getText().toString();
                            String getPhone = phone.getText().toString();
                            String key = mRef.push().getKey();

                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put("name",getName);
                            hashMap.put("phone",getPhone);

                            mRef.child("users").child("+91"+getPhone).setValue(hashMap);
                            otp.setText("");
                        }
                        else{
                            Toast.makeText(buyerlogin.this, "Wrong OTP", Toast.LENGTH_SHORT).show();
                            otp.setText("");
                        }

                    }
                });

    }
}
