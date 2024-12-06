package models;

import org.springframework.stereotype.Component;

public class Seller {
    private int sellerId;

    private String name;

    private String surname;

    private String phone;

    // Getters and Setters
    public int getSellerId() {
        return sellerId;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    private void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    private void setPhone(String phone) {
        this.phone = phone;
    }

    public static Seller CreateSeller(String name, String surname, String phone){
        Seller seller = new Seller();
        seller.setName(name);
        seller.setSurname(surname);
        seller.setPhone(phone);
        return seller;
    }
}