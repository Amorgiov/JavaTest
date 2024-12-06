package services;

import models.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import repositories.ISellerService;
import repositories.SellerRepository;

import java.util.List;

public class SellerService implements ISellerService {
    private final SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }
    public void insertSeller(Seller seller) {
        sellerRepository.insert(seller);
    }

    public List<String> getAll() { return sellerRepository.getAll(); }
    public String getById(int id) { return sellerRepository.getById(id); }
    public void update(int id, Seller seller) { sellerRepository.update(id, seller); }
    public void delete(int id) { sellerRepository.delete(id); }

}
