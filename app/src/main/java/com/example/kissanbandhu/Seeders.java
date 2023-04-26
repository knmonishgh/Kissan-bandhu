package com.example.kissanbandhu;

import android.widget.Button;

public class Seeders {
    String Seeder, Dealer, Price;

    //Modified
    Button OrderNow;

    public Button getOrderNow() {
        return OrderNow;
    }

    public void setOrderNow(Button orderNow) {
        OrderNow = orderNow;
    }

    public String getSeeder() {
        return Seeder;
    }

    public String getDealer() {
        return Dealer;
    }

    public String getPrice() {
        return Price;
    }

    public void setSeeder(String seeder) {
        Seeder = seeder;
    }

    public void setDealer(String dealer) {
        Dealer = dealer;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
