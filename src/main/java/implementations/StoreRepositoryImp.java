package implementations;

import database.ConfigLoader;
import database.JDBC;
import models.Store;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import repositories.StoreInterface;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StoreRepositoryImp implements StoreInterface {

    private static final ConfigLoader configL = new ConfigLoader();
    /*private static Connection getConnection() throws SQLException {
        return new JDBC(configL.getDbUrl(), configL.getDbUser(), configL.getDbPassword()).getConnection();
    }*/

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
            preparedStatement.setDouble(3, store.getPrice());
            preparedStatement.setDouble(4, store.getWeight());
            preparedStatement.setDate(5, store.getDate());

            LocalDateTime localDateTime = store.getCreatedAt();
            Timestamp timestamp = Timestamp.valueOf(localDateTime);
            preparedStatement.setTimestamp(6, timestamp);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getAll() {
        List<String> store = new ArrayList<>();
        String sql = "SELECT * FROM store";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                store.add("id:" + rs.getInt("store_id") + "| "
                                + rs.getString("cookie_id") + " "
                                + rs.getString("seller_id") + " "
                                + rs.getString("price") + " "
                                + rs.getString("weight") + " "
                                + rs.getString("date") + " "
                                + rs.getString("created_time")
                        );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return store;
    }

    @Override
    public String getById(int id) {
        String store = null;
        String sql = "SELECT * FROM store WHERE store_id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                store = "id:" + resultSet.getInt("store_id") + "| "
                        + resultSet.getString("cookie_id") + " "
                        + resultSet.getString("seller_id") + " "
                        + resultSet.getString("price") + " "
                        + resultSet.getString("weight")+ " "
                        + resultSet.getString("date")+ " "
                        + resultSet.getString("created_time");
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
            pstmt.setDouble(3, store.getPrice());
            pstmt.setDouble(4, store.getWeight());
            pstmt.setDate(5, new java.sql.Date(store.getDate().getTime()));
            pstmt.setTimestamp(6, Timestamp.valueOf(store.getCreatedAt()));
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
