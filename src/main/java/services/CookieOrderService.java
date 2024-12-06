package services;

import models.CookieOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import repositories.CookieOrderRepository;

import java.util.List;

public class CookieOrderService {

    private final CookieOrderRepository cookieOrderRepository;

    public CookieOrderService(CookieOrderRepository cookieOrderRepository) {
        this.cookieOrderRepository = cookieOrderRepository;
    }

    public void insertCookieOrder(CookieOrder cookieOrder) {
        cookieOrderRepository.insert(
                CookieOrder.CreateCookieOrder(cookieOrder.getStoreId(), cookieOrder.getWeight()));
    }

    public List<String> getAll() { return cookieOrderRepository.getAll(); }

    public String getById(int id) { return cookieOrderRepository.getById(id); }

    public void update(int id, CookieOrder cookieOrder) { cookieOrderRepository.update(id, cookieOrder); }

    public void delete(int id) { cookieOrderRepository.delete(id); }
}