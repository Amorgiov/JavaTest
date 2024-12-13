import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.CookieService;
import services.SellerService;
import models.Seller;

import java.io.Console;
import java.util.List;

public class App {

    private final CookieService cookieService;
    public App(CookieService cookieService){
        this.cookieService = cookieService;
    }

    public static void main(String[] args) {


    }
}
