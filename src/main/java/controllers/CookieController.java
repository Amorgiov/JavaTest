package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import services.SellerService;

@Controller
@RequestMapping("/cookies")
public class CookieController {

    private final SellerService cookieService;

    public CookieController(SellerService cookieService) {
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
