package implementations;

import database.ConfigLoader;
import database.JDBC;
import models.Seller;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import repositories.SellerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SellerRepositoryImp implements SellerRepository {
    private static final ConfigLoader configL = new ConfigLoader();
   /* private static Connection getConnection() throws SQLException {
        return new JDBC(configL.getDbUrl(), configL.getDbUser(), configL.getDbPassword()).getConnection();
    }*/
    private final DriverManagerDataSource dataSource;

    public SellerRepositoryImp(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Seller seller) {
        String sql = "INSERT INTO sellers (name, surname, phone) VALUES (?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, seller.getName());
            preparedStatement.setString(2, seller.getSurname());
            preparedStatement.setString(3, seller.getPhone());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getAll() {
        List<String> sellers = new ArrayList<>();
        String sql = "SELECT * FROM sellers";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                sellers.add("id:" + rs.getInt("seller_id") + "| "
                        + rs.getString("name") + " "
                + rs.getString("surname") + " "
                + rs.getString("phone") + " ");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sellers;
    }

    @Override
    public String getById(int id) {
        String seller = null;
        String sql = "SELECT * FROM sellers WHERE seller_id = ?";

        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                seller = "id:" + resultSet.getInt("seller_id") + "| "
                        + resultSet.getString("name") + " "
                                             + resultSet.getString("surname") + " "
                                             + resultSet.getString("phone");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seller;
    }

    @Override
    public void update(int id, Seller seller) {
        String sql = "UPDATE sellers SET name = ?, surname = ?, phone = ? WHERE seller_id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, seller.getName());
            pstmt.setString(2, seller.getSurname());
            pstmt.setString(3, seller.getPhone());
            pstmt.setInt(4, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM sellers WHERE seller_id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}