package repositories;

import models.Cookie;

import java.util.List;

public interface BaseInterface<T> {
    void insert(T entity);
    List<String> getAll();
    String getById(int id);
    void update(int id, T entity);
    void delete(int id);
}