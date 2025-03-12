package models;

import java.sql.Timestamp;
import java.sql.Date;

public class Store {
    private int storeId;
    private int cookie;
    private int seller;
    private int price;
    private int weight;
    private Date date;
    private Timestamp created_time;

    // Getters and Setters
    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getCookie() {
        return cookie;
    }

    public void setCookie(int cookie) {
        this.cookie = cookie;
    }

    public int getSeller() {
        return seller;
    }

    public void setSeller(int seller) {
        this.seller = seller;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Timestamp getCreatedAt() {
        return created_time;
    }

    public void setCreatedAt(Timestamp created_time) {
        this.created_time = created_time;
    }

    public static Store CreateStore(int storeId, int cookie, int seller, int price, int weight, Date date,
            Timestamp created_time) {
        Store store = new Store();

        store.setStoreId(storeId);
        store.setCookie(cookie);
        store.setSeller(seller);
        store.setPrice(price);
        store.setWeight(weight);
        store.setDate(date);
        store.setCreatedAt(created_time);

        return store;
    }

    public static Store CreateStore(int cookie, int seller, int price, int weight, Date date, Timestamp created_time) {
        Store store = new Store();
        store.setCookie(cookie);
        store.setSeller(seller);
        store.setPrice(price);
        store.setWeight(weight);
        store.setDate(date);
        store.setCreatedAt(created_time);

        return store;
    }

    @Override
    public String toString() {
        return "Store { storeId = " + storeId +
                ", cookie = " + cookie +
                ", seller = " + seller +
                ", price = " + price +
                ", weight = " + weight +
                ", date = " + date +
                ", created_time = " + created_time + " }";
    }
}