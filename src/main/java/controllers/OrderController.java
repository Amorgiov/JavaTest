package controllers;

import models.CookieOrder;
import org.springframework.stereotype.Controller;
import services.CookieOrderService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cookie-orders")
public class OrderController {

    private final CookieOrderService cookieOrderService;

    public OrderController(CookieOrderService cookieOrderService) {
        this.cookieOrderService = cookieOrderService;
    }

    // GET: /cookie-orders/
    @GetMapping
    public String getAllCookieOrders(Model model) {
        List<CookieOrder> cookieOrders = cookieOrderService.getAll();
        model.addAttribute("cookieOrders", cookieOrders);
        return "cookie-orders/cookieOrders";
    }

    // GET: /cookie-orders/{id}
    @GetMapping("/{id}")
    public String getCookieOrderById(@PathVariable("id") int id, Model model) {
        CookieOrder cookieOrder = cookieOrderService.getById(id);
        if (cookieOrder == null) {
            model.addAttribute("error", "Cookie order not found");
            return "error";
        }
        model.addAttribute("cookieOrder", cookieOrder);
        return "cookie-orders/detail";
    }

    // GET: /cookie-orders/create
    @GetMapping("/create")
    public String createCookieOrderForm() {
        return "cookie-orders/create";
    }

    // POST: /cookie-orders/create
    @PostMapping("/create")
    public String createCookieOrder(@ModelAttribute("cookieOrder") CookieOrder cookieOrder) {
        cookieOrderService.insertCookieOrder(CookieOrder.CreateCookieOrder(cookieOrder.getStoreId(), cookieOrder.getWeight()));
        return "redirect:/cookie-orders";
    }

    // GET: /cookie-orders/{id}/edit
    @GetMapping("/{id}/edit")
    public String editCookieOrderForm(@PathVariable("id") int id, Model model) {
        CookieOrder cookieOrder = cookieOrderService.getById(id);
        if (cookieOrder == null) {
            model.addAttribute("error", "Cookie order not found");
            return "error";
        }
        model.addAttribute("cookieOrder", cookieOrder);
        return "cookie-orders/edit";
    }

    // POST: /cookie-orders/{id}/edit
    @PostMapping("/{id}/edit")
    public String editCookieOrder(@ModelAttribute("cookieOrder") CookieOrder cookieOrder) {
        cookieOrderService.update(cookieOrder.getCookieOrderId(), CookieOrder.CreateCookieOrder(cookieOrder.getStoreId(), cookieOrder.getWeight()));
        return "redirect:/cookie-orders";
    }

    // GET: /cookie-orders/{id}/delete
    @GetMapping("/{id}/delete")
    public String deleteCookieOrder(@PathVariable("id") int id) {
        cookieOrderService.delete(id);
        return "redirect:/cookie-orders";
    }
}
