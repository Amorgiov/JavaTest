package models;

import org.springframework.stereotype.Component;


public class Cookie {
    private int cookieId;

    private String title;

    // Getters and Setters
    public int getCookiesId() {
        return cookieId;
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public static Cookie CreateCookie (String title){
        Cookie cookie = new Cookie();
        cookie.setTitle(title);
        return cookie;
    }
}
