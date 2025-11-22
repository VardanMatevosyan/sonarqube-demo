package com.practice.sonarqube_demo.persistence;

import com.practice.sonarqube_demo.model.entities.User;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDaoImpl implements UserDao {

    final DataSource dataSource;

    public Optional<User> getUserById(Integer id) {
        try (
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement()) {
            String query = "SELECT id, username, email FROM users WHERE id = " + id;
            var rs = statement.executeQuery(query);
            if (rs.next()) {
                User user = buildUserEntity(rs);
                return Optional.of(user);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException("SQL error", e);
        }
    }

    private User buildUserEntity(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("email"));
    }
}
