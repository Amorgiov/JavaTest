package models;

public class CookieOrder {
    private int cookieOrderId;

    private int storeId;

    private int weight;

    // Getters and Setters
    public int getCookieOrderId() {
        return cookieOrderId;
    }

    public void setCookieOrderId(int cookieOrderId) {
        this.cookieOrderId = cookieOrderId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int store) {
        this.storeId = store;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public static CookieOrder CreateCookieOrder(int cookieOrderId, int store_id, int weight) {
        CookieOrder cookieOrder = new CookieOrder();

        cookieOrder.setCookieOrderId(cookieOrderId);
        cookieOrder.setStoreId(store_id);
        cookieOrder.setWeight(weight);

        return cookieOrder;
    }

    public static CookieOrder CreateCookieOrder(int store_id, int weight) {
        CookieOrder cookieOrder = new CookieOrder();

        cookieOrder.setStoreId(store_id);
        cookieOrder.setWeight(weight);

        return cookieOrder;
    }

    @Override
    public String toString() {
        return "CookieOrder { id = " + cookieOrderId + ", store_id = " + storeId + ", weight = " + weight + " }";
    }
}
