package models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Cookie {
    private int cookieId;

    @NotBlank(message = "Title cannot be null")
    @Size(min = 3, max = 25, message = "The title should be between 3 and 25 characters")
    private String title;

    // Getters and Setters
    public int getCookieId() {
        return cookieId;
    }

    public void setCookieId(int cookieId) {
        this.cookieId = cookieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static Cookie CreateCookie(int cookieId, String title) {
        Cookie cookie = new Cookie();

        cookie.setCookieId(cookieId);
        cookie.setTitle(title);

        return cookie;
    }

    public static Cookie CreateCookie(String title) {
        Cookie cookie = new Cookie();
        cookie.setTitle(title);
        return cookie;
    }
}
