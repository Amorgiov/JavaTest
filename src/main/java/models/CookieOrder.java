package models;

import org.springframework.stereotype.Component;


public class CookieOrder {
    private int cookieOrderId;

    private int store_id;

    private Double weight;

    // Getters and Setters
    public int getCookieOrderId() { return cookieOrderId; }
    public void setCookieOrderId(int cookieOrderId) { this.cookieOrderId = cookieOrderId; }

    public int getStoreId() {
        return store_id;
    }

    private void setStoreId(int store) {
        this.store_id = store;
    }

    public Double getWeight() {
        return weight;
    }

    private void setWeight(Double weight) {
        this.weight = weight;
    }

    public static CookieOrder CreateCookieOrder (int store_id, Double weight) {
        CookieOrder cookieOrder = new CookieOrder();

        cookieOrder.setStoreId(store_id);
        cookieOrder.setWeight(weight);

        return cookieOrder;
    }

    @Override
    public String toString() {
        return "CookieOrder { id = " + cookieOrderId + ", store_id = " + store_id + ", weight = " + weight + " }";
    }
}
