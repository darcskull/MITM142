package com.MITM142.repository;

import com.MITM142.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> findAllUsers() {
        List<Map<String, Object>> rows =  jdbcTemplate.queryForList("SELECT * FROM \"USER\"");
        List<User> users = new ArrayList<>();

        for (Map<String, Object> row : rows) {
            User user = User.builder()
                    .id((Integer) row.get("id"))
                    .firstName((String) row.get("firstName"))
                    .lastName((String) row.get("lastName"))
                    .phoneNumber((String) row.get("phoneNumber"))
                    .email((String) row.get("email"))
                    .build();

            users.add(user);
        }

        return users;
    }

    public User findUserByEmailAndPassword(String email, String password) {
        String query = "SELECT * FROM \"USER\" WHERE email = ? AND password = ?";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query, email, password);

        return getUser(rows);
    }

    public User findUserByEmail(String email) {
        String query = "SELECT * FROM \"USER\" WHERE email = ?";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query, email);

        return getUser(rows);
    }

    public void createUser(User user) {
        String query = "INSERT INTO \"USER\" (id, firstName, lastName, email, password, phoneNumber) " +
                "VALUES (nextval('user_sequence'),?, ?, ?, ?, ?)";
        jdbcTemplate.update(query,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getPhoneNumber());
    }

    public Boolean doesUserExistByEmail(String email) {
        String query = "SELECT COUNT(*) FROM \"USER\" WHERE email = ?";
        int count = jdbcTemplate.queryForObject(query, Integer.class, email);
        return count > 0;
    }

    public User findUserById(int userId) {
        String query = "SELECT * FROM \"USER\" WHERE id = ?";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query, userId);

        return getUser(rows);
    }

    private User getUser(List<Map<String, Object>> rows) {
        if (rows.isEmpty()) {
            return null;
        }

        Map<String, Object> row = rows.get(0);

        return User.builder()
                .id((Integer) row.get("id"))
                .firstName((String) row.get("firstName"))
                .lastName((String) row.get("lastName"))
                .email((String) row.get("email"))
                .phoneNumber((String) row.get("phoneNumber"))
                .build();
    }

}
