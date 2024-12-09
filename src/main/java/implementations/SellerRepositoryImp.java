package implementations;

import models.Seller;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import repositories.SellerRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SellerRepositoryImp implements SellerRepository {

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
    public List<Seller> getAll() {
        List<Seller> sellers = new ArrayList<>();
        String sql = "SELECT * FROM sellers";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("seller_id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String phone = rs.getString("phone");

                sellers.add(Seller.CreateSeller(id, name, surname, phone));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sellers;
    }

    @Override
    public Seller getById(int id) {
        Seller seller = null;
        String sql = "SELECT * FROM sellers WHERE seller_id = ?";

        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int sellerId = resultSet.getInt("seller_id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String phone = resultSet.getString("phone");

                seller = Seller.CreateSeller(sellerId, name, surname, phone);
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