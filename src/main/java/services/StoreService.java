package services;

import models.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.StoreInterface;

import java.util.List;

public class StoreService {
    private final StoreInterface storeRepository;

    public StoreService(StoreInterface storeRepository) {
        this.storeRepository = storeRepository;
    }

    public void insertStore(Store store) { storeRepository.insert(store); }
    public List<Store> getAll() { return storeRepository.getAll(); }
    public Store getById(int id) { return storeRepository.getById(id); }
    public void update(int id, Store store) { storeRepository.update(id, store); }
    public void delete(int id) { storeRepository.delete(id); }
}
