package repositories;

import models.Cookie;
import models.Seller;

import java.util.List;

public interface ICookieService {

    void insertCookie(Cookie cookie);

    List<String> getAll();
    String getById(int id);
    void update(int id, Cookie cookie);
    void delete(int id);

}
