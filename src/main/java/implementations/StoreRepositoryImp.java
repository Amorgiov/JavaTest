package implementations;

import models.Store;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import repositories.StoreInterface;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StoreRepositoryImp implements StoreInterface {

    private final DriverManagerDataSource dataSource;

    public StoreRepositoryImp(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Store store) {
        String sql = "INSERT INTO store (cookie_id, seller_id, price, weight, date, created_time) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, store.getCookie());
            preparedStatement.setInt(2, store.getSeller());
            preparedStatement.setInt(3, store.getPrice());
            preparedStatement.setInt(4, store.getWeight());
            preparedStatement.setDate(5, store.getDate());
            preparedStatement.setTimestamp(6, store.getCreatedAt());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Store> getAll() {
        List<Store> store = new ArrayList<>();
        String sql = "SELECT * FROM store";
        try (Connection connection = dataSource.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int storeId = rs.getInt("store_id");
                int cookieId = rs.getInt("cookie_id");
                int sellerId = rs.getInt("seller_id");
                int price = rs.getInt("price");
                int weight = rs.getInt("weight");
                Date date = rs.getDate("date");
                Timestamp timestamp = rs.getTimestamp("created_time");

                store.add(Store.CreateStore(storeId, cookieId, sellerId, price, weight, date, timestamp));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return store;
    }

    @Override
    public Store getById(int id) {
        Store store = null;
        String sql = "SELECT * FROM store WHERE store_id = ?";

        try (Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int storeId = rs.getInt("store_id");
                int cookieId = rs.getInt("cookie_id");
                int sellerId = rs.getInt("seller_id");
                int price = rs.getInt("price");
                int weight = rs.getInt("weight");
                Date date = rs.getDate("date");
                Timestamp timestamp = rs.getTimestamp("created_time");

                store = Store.CreateStore(storeId, cookieId, sellerId, price, weight, date, timestamp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return store;
    }

    @Override
    public void update(int id, Store store) {
        String sql = "UPDATE store SET cookie_id = ?, seller_id = ?, price = ?, weight = ?, date = ?, created_time = ? WHERE store_id = ?";

        try (Connection connection = dataSource.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, store.getCookie());
            pstmt.setInt(2, store.getSeller());
            pstmt.setInt(3, store.getPrice());
            pstmt.setInt(4, store.getWeight());
            pstmt.setDate(5, new java.sql.Date(store.getDate().getTime()));
            pstmt.setTimestamp(6, store.getCreatedAt());
            pstmt.setInt(7, id);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM store WHERE store_id = ?";

        try (Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
