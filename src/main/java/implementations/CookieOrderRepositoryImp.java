package implementations;

import database.ConfigLoader;
import database.JDBC;
import models.CookieOrder;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import repositories.CookieOrderRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CookieOrderRepositoryImp implements CookieOrderRepository {

    private static final ConfigLoader configL = new ConfigLoader();

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
            preparedStatement.setDouble(2, cookieOrder.getWeight());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getAll() {
        List<String> cookieOrders = new ArrayList<>();
        String sql = "SELECT * FROM cookie_order";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                cookieOrders.add("id:" + rs.getInt("cookie_order_id") +  "| " + rs.getString("store_id") + " "
                        + rs.getString("weight"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return cookieOrders;
    }

    @Override
    public String getById(int id) {
        String cookieOrder = null;
        String sql = "SELECT * FROM cookie_order WHERE cookie_order_id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                cookieOrder = "id:" + resultSet.getInt("cookie_order_id") + "| "
                        + resultSet.getString("store_id") + " "
                        + resultSet.getString("weight");
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
            pstmt.setDouble(2, cookieOrder.getWeight());
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