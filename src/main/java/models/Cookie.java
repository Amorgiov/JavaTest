package models;

import org.springframework.stereotype.Component;


public class Cookie {
    private int cookieId;

    private String title;

    // Getters and Setters
    public int getCookiesId() {
        return cookieId;
    }

    public int getCookieId() { return cookieId; }
    public void setCookieId(int cookieId) { this.cookieId = cookieId; }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static Cookie CreateCookie (String title){
        Cookie cookie = new Cookie();
        cookie.setTitle(title);
        return cookie;
    }

    @Override
    public String toString() {
        return "Cookie { id = " + cookieId + ", title = " + title + " }";
    }
}
