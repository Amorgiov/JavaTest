package models;

public class Seller {
    private int sellerId;

    private String name;

    private String surname;

    private String phone;

    public Seller(){}

    // Getters and Setters
    public int getSellerId() {
        return sellerId;
    }
    public void setSellerId(int id) { this.sellerId = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static Seller CreateSeller(int id, String name, String surname, String phone){
        Seller seller = new Seller();
        seller.setSellerId(id);
        seller.setName(name);
        seller.setSurname(surname);
        seller.setPhone(phone);
        return seller;
    }

    public static Seller CreateSeller(String name, String surname, String phone){
        Seller seller = new Seller();
        seller.setName(name);
        seller.setSurname(surname);
        seller.setPhone(phone);
        return seller;
    }

    @Override
    public String toString() {
        return "Seller { id = " + sellerId +
                ", name = " + name +
                ", surname = " + surname +
                ", phone = " + phone + " }";
    }
}