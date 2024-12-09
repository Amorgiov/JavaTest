import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.SellerService;
import models.Seller;

import java.io.Console;
import java.util.List;

public class App {

    private final SellerService sellerService;
    public App(SellerService sellerService){
        this.sellerService = sellerService;
    }

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        SellerService sellerService = context.getBean(SellerService.class);

        App app = new App(sellerService);

        app.sellerService.update(14, Seller.CreateSeller("name", "surname", "2131488"));
    }
}
