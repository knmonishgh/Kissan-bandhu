package com.example.kissanbandhu;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class seller_addtrac extends AppCompatActivity {
//    MYDatabaseHandler myDb;
    EditText ed1,ed2,ed3,ed4;
    Button btn1,btn2,btn3,btn4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_addtrac);
        getSupportActionBar().setTitle("SELLER");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#23863B")));
//        myDb= new MYDatabaseHandler(this);
//        ed1 = findViewById(R.id.Tractor_name);
//        ed2 = findViewById(R.id.Dealer_name);
//        ed3 = findViewById(R.id.Cost_perday);
//        ed4 = findViewById(R.id.Contact_number);
//        btn1 = findViewById(R.id.Add_stock);
//        btn2 = findViewById(R.id.Update_stock);
//        btn3 = findViewById(R.id.Delete_stock);
//        btn4 = findViewById(R.id.View_stock);
//        inserdata();
//        UpdateData();
//        DeleteData();
//        displayalldata();
//
//    }
//    public void UpdateData()
//    {
//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                boolean isupdate = myDb.updateData(ed1.getText().toString(),ed2.getText().toString(),ed3.getText().toString(),ed4.getText().toString());
////                if(isupdate == true)
//                    Toast.makeText(seller_addtrac.this, "Data Updated ", Toast.LENGTH_SHORT).show();
//                else
//                    Toast.makeText(seller_addtrac.this, "Data not Updated ", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//    public void DeleteData()
//    {
//        btn4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Integer deletedrows = myDb.deleData(ed1.getText().toString());
////                if(deletedrows>0)
//                    Toast.makeText(seller_addtrac.this, "Data Deleted", Toast.LENGTH_SHORT).show();
//                else
//                    Toast.makeText(seller_addtrac.this, "Data not Deleted", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//    public void displayalldata()
//    {
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Cursor res = myDb.displayalldata();
//                if(res.getCount() == 0)
//                {
//                    showMessage("Error","No Data Inserted");
//                    return;
//                }
//                StringBuffer buffer = new StringBuffer();
//                while (res.moveToNext())
//                {
//                    buffer.append("Tractor_name :"+res.getString(0)+"\n");
//                    buffer.append("Dealer_name :"+res.getString(1)+"\n");
//                    buffer.append("Cost_perday :"+res.getString(2)+"\n");
//                    buffer.append("Contact_number :"+res.getString(3)+"\n\n");
//                }
//                showMessage("Data",buffer.toString());
//            }
//        });
//    }
//    public void showMessage(String title, String message)
//    {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setCancelable(true);
//        builder.setTitle(title);
//        builder.setMessage(message);
//        builder.show();
//    }
//    public void inserdata(){
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {boolean isinserted =   myDb.insertData(ed2.getText().toString(),ed3.getText().toString(),ed4.getText().toString());
//                if(isinserted == true)
//                    Toast.makeText(seller_addtrac.this, "Data Inserted", Toast.LENGTH_SHORT).show();
//                else
//                    Toast.makeText(seller_addtrac.this, "Data not Inserted", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}