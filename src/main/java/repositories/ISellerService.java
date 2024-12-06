package repositories;

import models.Seller;

import java.util.List;

public interface ISellerService {
    void insertSeller(Seller seller);

    List<String> getAll();
    String getById(int id);
    void update(int id, Seller seller);
    void delete(int id);
}
