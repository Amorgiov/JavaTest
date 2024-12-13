
package controllers;

import models.Store;
import org.springframework.stereotype.Controller;
import services.StoreService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("/stores")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public String getAllStores(Model model) {
        List<Store> stores = storeService.getAll();
        model.addAttribute("stores", stores);
        return "stores/stores";
    }

    @GetMapping("/{id}")
    public String getStoreById(@PathVariable("id") int id, Model model) {
        Store store = storeService.getById(id);
        if (store == null) {
            model.addAttribute("error", "Store not found");
            return "error";
        }
        model.addAttribute("store", store);
        return "stores/detail";
    }

    @GetMapping("/create")
    public String createStoreForm() {
        return "stores/create";
    }

    @PostMapping("/create")
    public String createStore(@ModelAttribute("store") Store store) {
        storeService.insertStore(Store.CreateStore(store.getStoreId(), store.getCookie(), store.getSeller(), store.getPrice(), store.getWeight(), store.getDate(), new Timestamp(System.currentTimeMillis())));
        return "redirect:/stores";
    }

    @GetMapping("/{id}/edit")
    public String editStoreForm(@PathVariable("id") int id, Model model) {
        Store store = storeService.getById(id);
        model.addAttribute("store", store);
        return "stores/edit";
    }

    @PostMapping("/{id}/edit")
    public String editStore(@ModelAttribute("store") Store store) {
        storeService.update(store.getStoreId(), Store.CreateStore(store.getCookie(), store.getSeller(), store.getPrice(), store.getWeight(), store.getDate(), new Timestamp(System.currentTimeMillis())));
        return "redirect:/stores";
    }

    @GetMapping("/{id}/delete")
    public String deleteStore(@PathVariable("id") int id) {
        storeService.delete(id);
        return "redirect:/stores";
    }
}
