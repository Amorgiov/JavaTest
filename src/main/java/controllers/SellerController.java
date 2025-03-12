package controllers;

import models.Seller;
import org.springframework.stereotype.Controller;
import services.SellerService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/sellers")
public class SellerController {

    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    // GET: /sellers/
    @GetMapping
    public String getAllSellers(Model model) {
        List<Seller> sellers = sellerService.getAll();
        model.addAttribute("sellers", sellers);
        return "sellers/sellers";
    }

    // GET: /sellers/{id}
    @GetMapping("/{id}")
    public String getSellerById(@PathVariable("id") int id, Model model) {
        Seller seller = sellerService.getById(id);
        if (seller == null) {
            model.addAttribute("error", "Seller not found");
            return "error"; // Страница ошибки, если продавец не найден
        }
        model.addAttribute("seller", seller);
        return "sellers/detail"; // Страница с деталями продавца
    }

    // GET: /sellers/create
    @GetMapping("/create")
    public String createSellerForm(Model model) {
        return "sellers/create";
    }

    @PostMapping("/create")
    public String createSeller(@ModelAttribute("seller") Seller seller) {
        sellerService.insertSeller(Seller.CreateSeller(seller.getName(), seller.getSurname(), seller.getPhone()));
        return "redirect:/sellers"; // Возвращаем на страницу создания для отображения сообщения
    }

    // GET: /sellers/{id}/edit
    @GetMapping("/{id}/edit")
    public String editSellerForm(@PathVariable("id") int id, Model model) {
        Seller seller = sellerService.getById(id);
        if (seller == null) {
            model.addAttribute("error", "Seller not found");
            return "error"; // Страница ошибки, если продавец не найден
        }
        model.addAttribute("seller", seller);
        return "sellers/edit"; // Страница для редактирования
    }

    // POST: /sellers/{id}/edit
    @PostMapping("/{id}/edit")
    public String editSeller(@ModelAttribute("seller") Seller seller) {
        Seller updatedSeller = Seller.CreateSeller(seller.getName(), seller.getSurname(), seller.getPhone());
        sellerService.update(seller.getSellerId(), updatedSeller);
        return "redirect:/sellers"; // Перенаправление на список продавцов после обновления
    }

    // GET: /sellers/{id}/delete
    @GetMapping("/{id}/delete")
    public String deleteSeller(@PathVariable("id") int id) {
        sellerService.delete(id);
        return "redirect:/sellers"; // Перенаправление на список продавцов после удаления
    }
}
