package controllers;

import models.Cookie;
import org.springframework.stereotype.Controller;
import services.CookieService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cookies")
public class CookieController {

    private final CookieService cookieService;

    public CookieController(CookieService cookieService) {
        this.cookieService = cookieService;
    }

    // GET: /cookies/
    @GetMapping
    public String getAllCookies(Model model) {
        List<Cookie> cookies = cookieService.getAll();
        model.addAttribute("cookies", cookies);
        return "cookies/cookies";
    }

    // GET: /cookies/{id}
    @GetMapping("/{id}")
    public String getCookieById(@PathVariable("id") int id, Model model) {
        Cookie cookie = cookieService.getById(id);
        if (cookie == null) {
            model.addAttribute("error", "Cookie not found");
            return "error";
        }
        model.addAttribute("cookie", cookie);
        return "cookies/detail";
    }

    // GET: /cookies/create
    @GetMapping("/create")
    public String createCookieForm() {
        return "cookies/create";
    }

    // POST: /cookies/create
    @PostMapping("/create")
    public String createCookie(@ModelAttribute("cookie") Cookie cookie) {
        cookieService.insertCookie(Cookie.CreateCookie(cookie.getTitle()));
        return "redirect:/cookies";
    }

    // GET: /cookies/{id}/edit
    @GetMapping("/{id}/edit")
    public String editCookieForm(@PathVariable("id") int id, Model model) {
        Cookie cookie = cookieService.getById(id);
        if (cookie == null) {
            model.addAttribute("error", "Cookie not found");
            return "error";
        }
        model.addAttribute("cookie", cookie);
        return "cookies/edit";
    }

    // POST: /cookies/{id}/edit
    @PostMapping("/{id}/edit")
    public String editCookie(@ModelAttribute("cookie") Cookie cookie) {
        cookieService.update(cookie.getCookiesId(), Cookie.CreateCookie(cookie.getTitle()));
        return "redirect:/cookies";
    }

    // GET: /cookies/{id}/delete
    @GetMapping("/{id}/delete")
    public String deleteCookie(@PathVariable("id") int id) {
        cookieService.delete(id);
        return "redirect:/cookies";
    }
}
