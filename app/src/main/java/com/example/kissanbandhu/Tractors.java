package com.example.kissanbandhu;

import android.widget.Button;

public class Tractors {

    String Tractor, Dealer, Price;

    //Modified
    Button RentNow;

    public Button getRentNow() {
        return RentNow;
    }

    public void setRentNow(Button rentNow) {
        RentNow = rentNow;
    }
    //Till here

    public String getTractor() {
        return Tractor;
    }

    public String getDealer() {
        return Dealer;
    }

    public String getPrice() {
        return Price;
    }

    public void setTractor(String tractor) {
        Tractor = tractor;
    }

    public void setDealer(String dealer) {
        Dealer = dealer;
    }

    public void setPrice(String price) {
        Price = price;
    }
}