package com.example.kissanbandhu;

import android.widget.Button;

public class Pesticides {

    String Fertilizer, Dealer, Price, Contact_no;

    //Modified
    Button OrderNow;

    public Button getOrderNow() {
        return OrderNow;
    }

    public String getContact_no() {
        return Contact_no;
    }

    public void setContact_no(String contact_no) {
        Contact_no = contact_no;
    }

    public void setOrderNow(Button orderNow) {
        OrderNow = orderNow;
    }

    public String getFertilizer() {
        return Fertilizer;
    }

    public String getDealer() {
        return Dealer;
    }

    public String getPrice() {
        return Price;
    }

    public void setFertilizer(String fertilizer) {
        Fertilizer = fertilizer;
    }

    public void setDealer(String dealer) {
        Dealer = dealer;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
