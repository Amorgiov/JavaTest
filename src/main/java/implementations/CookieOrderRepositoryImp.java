package implementations;

import models.CookieOrder;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import repositories.CookieOrderRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CookieOrderRepositoryImp implements CookieOrderRepository {


    private final DriverManagerDataSource dataSource;

    public CookieOrderRepositoryImp(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(CookieOrder cookieOrder) {
        String sql = "INSERT INTO cookie_order (store_id, weight) VALUES (?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, cookieOrder.getStoreId());
            preparedStatement.setInt(2, cookieOrder.getWeight());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CookieOrder> getAll() {
        List<CookieOrder> cookieOrders = new ArrayList<>();
        String sql = "SELECT * FROM cookie_order";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int cookieOrderId = rs.getInt("cookie_order_id");
                int storeId = rs.getInt("store_id");
                int weight = rs.getInt("weight");

                cookieOrders.add(CookieOrder.CreateCookieOrder(cookieOrderId, storeId, weight));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return cookieOrders;
    }

    @Override
    public CookieOrder getById(int id) {
        CookieOrder cookieOrder = null;
        String sql = "SELECT * FROM cookie_order WHERE cookie_order_id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int cookieOrderId = resultSet.getInt("cookie_order_id");
                int storeId = resultSet.getInt("store_id");
                int weight = resultSet.getInt("weight");

                cookieOrder = CookieOrder.CreateCookieOrder(cookieOrderId, storeId, weight);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cookieOrder;
    }

    @Override
    public void update(int id, CookieOrder cookieOrder) {
        String sql = "UPDATE cookie_order SET store_id = ?, weight = ? WHERE cookie_order_id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, cookieOrder.getStoreId());
            pstmt.setInt(2, cookieOrder.getWeight());
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM cookie_order WHERE cookie_order_id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}