package implementations;

import models.Cookie;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import repositories.CookieInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CookieRepositoryImp implements CookieInterface {

    private final DriverManagerDataSource dataSource;

    public CookieRepositoryImp(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Cookie cookie) {
        String sql = "INSERT INTO cookies (title) VALUES (?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, cookie.getTitle());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cookie> getAll() {
        List<Cookie> cookies = new ArrayList<>();
        String sql = "SELECT * FROM public.cookies";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int cookieId = rs.getInt("cookie_id");
                String title = rs.getString("title");
                cookies.add(Cookie.CreateCookie(cookieId, title));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cookies;
    }

    @Override
    public Cookie getById(int id) {
        Cookie cookie = null;
        String sql = "SELECT * FROM public.cookies WHERE cookie_id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int cookieId = resultSet.getInt("cookie_id");
                String title = resultSet.getString("title");
                cookie = Cookie.CreateCookie(cookieId, title);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cookie;
    }

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
