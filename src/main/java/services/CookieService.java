package services;

import models.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CookieInterface;
import repositories.ICookieService;

import java.util.List;

public class CookieService implements ICookieService
{
    private final CookieInterface cookieRepository;

    public CookieService(CookieInterface cookieRepository) {
        this.cookieRepository = cookieRepository;
    }

    public void insertCookie(Cookie cookie) {
        cookieRepository.insert(cookie);
    }
    public List<String> getAll() { return cookieRepository.getAll(); }
    public String getById(int id) { return cookieRepository.getById(id); }
    public void update(int id, Cookie cookie) { cookieRepository.update(id, cookie); }
    public void delete(int id) { cookieRepository.delete(id); }
}
