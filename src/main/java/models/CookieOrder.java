package models;

import org.springframework.stereotype.Component;


public class CookieOrder {
    private int cookieOrderId;

    private int store_id;

    private Double weight;

    // Getters and Setters
    public int getCookieOrderId() { return cookieOrderId; }

    public int getStoreId() {
        return store_id;
    }

    public void setStoreId(int store) {
        this.store_id = store;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public static CookieOrder CreateCookieOrder (int store_id, Double weight) {
        CookieOrder cookieOrder = new CookieOrder();

        cookieOrder.setStoreId(store_id);
        cookieOrder.setWeight(weight);

        return cookieOrder;
    }
}
