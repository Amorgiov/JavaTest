import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.SellerService;
import models.Seller;

public class App {

    private final SellerService sellerService;
    public App(SellerService sellerService){
        this.sellerService = sellerService;
    }

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        SellerService sellerService = context.getBean(SellerService.class);

        // Создание экземпляра класса App с передачей SellerService
        App app = new App(sellerService);

        // Вставка (insert) нового продавца
        app.sellerService.insertSeller(Seller.CreateSeller("John", "Doe", "1234567890"));

        /*// Получение всех продавцов
        System.out.println("All Sellers:");
        app.sellerService.getAll().forEach(System.out::println);

        // Получение продавца по ID
        int idToRetrieve = 8;
        System.out.println("Seller with ID 1: " + sellerService.getById(idToRetrieve));
        app.sellerService.getById(idToRetrieve);

        // Обновление информации о продавце
        int updatedId = 9;
        Seller newSeller = Seller.CreateSeller("Jane", "Smith", "6543210");
        app.sellerService.update(updatedId, newSeller);

        // Удаление продавца по ID
        int idToDelete = 7; // Предположим, что нужно удалить продавца с ID 1
        app.sellerService.delete(idToDelete);*/
    }
}
