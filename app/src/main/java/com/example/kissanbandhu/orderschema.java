package com.example.kissanbandhu;

import android.widget.Button;

public class orderschema {
    String tool, Dealer, Price, Contact_no;


    public String getContact_no() {
        return Contact_no;
    }

    public void setContact_no(String contact_no) {
        Contact_no = contact_no;
    }



    public String getTool() {
        return tool;
    }

    public String getDealer() {
        return Dealer;
    }

    public String getPrice() {
        return Price;
    }

    public void setSeeder(String tool) {
        tool  = tool;
    }

    public void setDealer(String dealer) {
        Dealer = dealer;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
