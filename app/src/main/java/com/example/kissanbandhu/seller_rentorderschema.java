package com.example.kissanbandhu;

public class seller_rentorderschema {

    String tool, Price, Contact_no, days;

    public String getDays() {
        return days;
    }

    public String getContact_no() {
        return Contact_no;
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

    public void setContact_no(String contact_no) {
        Contact_no = contact_no;
    }

    public void setDays(String days) {
        this.days = days;
    }
}
