package controllers;

import models.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import repositories.ISellerService;
import services.CookieService;

import java.util.List;

@Controller
@RequestMapping("/cookies")
public class CookieController {

    private final ISellerService cookieService;

    public CookieController(ISellerService cookieService) {
        this.cookieService = cookieService;
    }

    @GetMapping
    public String showNewCourseForm() {
        return "index";
    }

    /*@GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable( value = "cookieId") int id, Model model) {

        Cookie cookie = cookieService.getById(id);
        model.addAttribute("cookie", cookie);
        return "update_course";
    }*/
}
