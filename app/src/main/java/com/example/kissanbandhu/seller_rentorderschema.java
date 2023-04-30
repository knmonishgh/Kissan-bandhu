package com.example.kissanbandhu;

public class seller_rentorderschema {

    String tool;
    String Price;

    String days;
    String address;
    String buyer_number;

    public String getBuyer_number() {
        return buyer_number;
    }

    public void setBuyer_number(String buyer_number) {
        this.buyer_number = buyer_number;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public String getDays() {
        return days;
    }




    public String getTool() {
        return tool;
    }

    public String getPrice() {
        return Price;
    }

    public void setSeeder(String tool) {
        tool  = tool;
    }

    public void setPrice(String price) {
        Price = price;
    }



    public void setDays(String days) {
        days = days;
    }
}
