package com.example.kissanbandhu;

import android.widget.Button;

public class Tractors {

    String Tractor, Dealer, Price, Contact_no;


    Button RentNow;

    public String getContact_no() {
        return Contact_no;
    }

    public void setContact_no(String contact_no) {
        Contact_no = contact_no;
    }

    public Button getRentNow() {
        return RentNow;
    }

    public void setRentNow(Button rentNow) {
        RentNow = rentNow;
    }
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