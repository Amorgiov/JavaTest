package models;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.sql.Date;

public class Store {
    private int storeId;
    private int cookie;
    private int seller;
    private Double price;
    private Double weight;
    private Date date;
    private LocalDateTime created_time;

    // Getters and Setters
    public int getStoreId() { return storeId; }

    public int getCookie() { return cookie; }
    private void setCookie(int cookie) { this.cookie = cookie; }

    public int getSeller() { return seller; }
    private void setSeller(int seller) { this.seller = seller; }

    public Double getPrice() { return price; }
    private void setPrice(Double price) { this.price = price; }

    public Double getWeight() { return weight; }
    private void setWeight(Double weight) { this.weight = weight; }

    public Date getDate() { return date; }
    private void setDate(Date date) { this.date = date; }

    public LocalDateTime getCreatedAt() { return created_time; }
    private void setCreatedAt(LocalDateTime created_time) { this.created_time = created_time; }

    public static Store CreateStore(int cookie, int seller, Double price, Double weight, Date date, LocalDateTime created_time){
        Store store = new Store();

        store.setCookie(cookie);
        store.setSeller(seller);
        store.setPrice(price);
        store.setWeight(weight);
        store.setDate(date);
        store.setCreatedAt(created_time);

        return store;
    }
}