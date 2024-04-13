package com.example.empl4sem2CRUD.repositories;

import com.example.empl4sem2CRUD.model.User;
import com.example.empl4sem2CRUD.queries.H2;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepository {
    private final JdbcTemplate jdbc;
    private final H2 h2;

    public List<User> findAll() {
//        String sql = "SELECT * FROM userTable";
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbc.query(h2.getSelectUser(), userRowMapper);
    }

    public User save(User user) {
//        String sql = "INSERT INTO userTable (firstName,lastName) VALUES ( ?, ?)";
        jdbc.update(h2.getInsertUser(), user.getFirstName(), user.getLastName());
        return user;
    }

    public void deleteById(int id) {
//        String sql = "DELETE FROM userTable WHERE id=" + id;
        jdbc.update(h2.getDeleteUser(), id);
    }

    public void update(User user) {
//        String sql = "UPDATE userTable SET firstName = ?, lastName = ? WHERE id = ?";
        jdbc.update(h2.getUpdateUser(), user.getFirstName(), user.getLastName(), user.getId());
    }

    public User findById(int id) {
//        String sql = "SELECT * FROM userTable WHERE id = ?";
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbc.queryForObject(h2.getSelectUserFindById(), userRowMapper, id);
    }
}
