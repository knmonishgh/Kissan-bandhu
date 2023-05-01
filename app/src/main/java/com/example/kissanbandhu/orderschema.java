package com.example.kissanbandhu;

import android.widget.Button;

public class orderschema {
    String tool;
    String Dealer;
    String Price;
    String dealer_number;
    public String getDealer_number() {
        return dealer_number;
    }

    public void setDealer_number(String dealer_number) {
        this.dealer_number = dealer_number;
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
