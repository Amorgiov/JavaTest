package implementations;

import database.ConfigLoader;
import database.JDBC;
import models.Cookie;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import repositories.CookieInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CookieRepositoryImp implements CookieInterface {

    private static final ConfigLoader configL = new ConfigLoader();
    /*private static Connection getConnection() throws SQLException {
        return new JDBC(configL.getDbUrl(), configL.getDbUser(), configL.getDbPassword()).getConnection();
    }*/

    private final DriverManagerDataSource dataSource;

    public CookieRepositoryImp(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Cookie cookie) {
        String sql = "INSERT INTO cookies (title) VALUES (?)";
        ResultSet generatedKeys = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, cookie.getTitle());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getAll() {
        List<String> cookies = new ArrayList<>();
        String sql = "SELECT * FROM cookies";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                cookies.add("id:" + rs.getInt("cookie_id") + "| "
                       + rs.getString("title"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cookies;
    }

    @Override
    public String getById(int id) {
        String cookies = null;
        String sql = "SELECT * FROM cookies WHERE cookie_id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                cookies = "id:" + resultSet.getInt("cookie_id") + "| "
                        + resultSet.getString("title");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cookies;
    }

    /*@Override
    public void update(int id, String title) {
        String sql = "UPDATE cookies SET title = ? WHERE cookie_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, title);

            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/

    @Override
    public void update(int id, Cookie cookie) {
        String sql = "UPDATE cookies SET title = ? WHERE cookie_id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, cookie.getTitle());

            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM cookies WHERE cookie_id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
