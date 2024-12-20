package services;

import models.Cookie;
import repositories.CookieInterface;

import java.util.List;

public class CookieService
{
    private final CookieInterface cookieRepository;

    public CookieService(CookieInterface cookieRepository) {
        this.cookieRepository = cookieRepository;
    }

    public void insertCookie(Cookie cookie) {
        cookieRepository.insert(cookie);
    }
    public List<Cookie> getAll() { return cookieRepository.getAll(); }
    public Cookie getById(int id) { return cookieRepository.getById(id); }
    public void update(int id, Cookie cookie) { cookieRepository.update(id, cookie); }
    public void delete(int id) { cookieRepository.delete(id); }
}
