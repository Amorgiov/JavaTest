/*
package com.expamle;

import models.Cookie;
import models.CookieOrder;
import models.Seller;
import models.Store;
import services.CookieOrderService;
import services.CookieService;
import services.SellerService;
import services.StoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class SalaryTest {

    private final SellerService sellerService = new SellerService();
    private final CookieService cookieService = new CookieService();
    private final StoreService storeService = new StoreService();
    private final CookieOrderService cookieOrderService = new CookieOrderService();

    //Insert tests
    @Test
    public void testInsertSeller() throws SQLException {
        sellerService.insertSeller(Seller.CreateSeller("Govard2", "Stark", "345"));
    }
    @Test
    public void testInsertCookie() throws SQLException {
        cookieService.insertCookie(Cookie.CreateCookie("Milkier"));
    }
    @Test
    public void testInsertStore() throws SQLException {
        storeService.insertStore(Store.CreateStore(1, 1, 29.99, 1.5,
                Date.valueOf("2020-02-02"), LocalDateTime.now()));
    }
    @Test
    public void testInsertCookieOrder() throws SQLException {
        cookieOrderService.insertCookieOrder(CookieOrder.CreateCookieOrder(2, 1.9));
    }

    //Select all tests_____________________________________
    @Test
    public void testSelectAllSellers() throws SQLException {
        List<String> sellers = sellerService.getAll();
        Assertions.assertFalse(sellers.isEmpty());
        System.out.println(sellers);
    }
    @Test
    public void testSelectAllCookies() throws SQLException {
        List<String> cookies = cookieService.getAll();
        Assertions.assertFalse(cookies.isEmpty());
        System.out.println(cookies);
    }
    @Test
    public void testSelectAllStores() throws SQLException {
        List<String> store = storeService.getAll();
        Assertions.assertFalse(store.isEmpty());
        System.out.println(store);
    }
    @Test
    public void testSelectAllCookieOrders() throws SQLException {
        List<String> cookieOrders = cookieOrderService.getAll();
        System.out.println(cookieOrders);
    }

    //Select by id tests_____________________________________
    @Test
    public void testSelectSellerById() throws SQLException {
        String seller = sellerService.getById(1);
        System.out.println(seller);
    }
    @Test
    public void testSelectCookieById() throws SQLException {
        String cookie = cookieService.getById(1);
        System.out.println(cookie);
    }
    @Test
    public void testSelectStoreById() throws SQLException {
        String store = storeService.getById(2);
        System.out.println(store);
    }
    @Test
    public void testSelectCookieOrderById() throws SQLException {
        String cookieOrder = cookieOrderService.getById(3);
        System.out.println(cookieOrder);
    }

    //Update tests_____________________________________
    @Test
    public void testUpdateSeller() throws SQLException {
        sellerService.update(1, Seller.CreateSeller("Seller", "Seller", "666"));
    }
    @Test
    public void testUpdateCookie() throws SQLException {
        cookieService.update(1, Cookie.CreateCookie("Nutter"));
    }
    @Test
    public void testUpdateStore() throws SQLException {
        storeService.update(2, Store.CreateStore( 2, 3, 29.99, 1.9,
                Date.valueOf("2020-02-02"), LocalDateTime.now()));
    }
    @Test
    public void testUpdateCookieOrder() throws SQLException {
        cookieOrderService.update(3, CookieOrder.CreateCookieOrder(4, 4.0));
    }

    //Delete tests_____________________________________
    @Test
    public void testDeleteSeller() throws SQLException {
        sellerService.delete(1);
    }
    @Test
    public void testDeleteCookie() throws SQLException {
        cookieService.delete(1);
    }
    @Test
    public void testDeleteStore() throws SQLException {
        storeService.delete(2);
    }
    @Test
    public void testDeleteCookieOrder() throws SQLException {
        cookieOrderService.delete(3);
    }
}
*/
