package services;

import models.Seller;
import repositories.SellerRepository;

import java.util.List;

public class SellerService {
    private final SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }
    public void insertSeller(Seller seller) {
        sellerRepository.insert(seller);
    }

    public List<Seller> getAll() { return sellerRepository.getAll(); }
    public Seller getById(int id) { return sellerRepository.getById(id); }
    public void update(int id, Seller seller) { sellerRepository.update(id, seller); }
    public void delete(int id) { sellerRepository.delete(id); }

}
