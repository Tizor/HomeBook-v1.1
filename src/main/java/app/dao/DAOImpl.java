package app.dao;

import app.entity.User;
import app.mapper.UserMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class DAOImpl implements DAO {

    public JdbcTemplate JT;

    public DAOImpl(JdbcTemplate JT) {

        this.JT = JT;
    }


    @Override
    public List<User> allUsers() {
        String sql = " SELECT * FROM contacts";

        return JT.query(sql, new UserMapper());
        }


    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO contacts (name, city, phone) VALUES (?,?,?)";
        JT.update(sql, user.getName(), user.getCity(), user.getPhone());

    }

   @Override
    public User getId(int id) {
        String sql = "SELECT * FROM contacts WHERE id = ?";
        return JT.queryForObject(sql, new UserMapper(), id);

    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE contacts SET name=?, city=?, phone=? WHERE id=?";
        JT.update(sql, user.getName(), user.getCity(), user.getPhone(), user.getId());

    }

    @Override
    public void deleteUser(int id) {
        String sql = "DELETE FROM contacts WHERE id=?";
        JT.update(sql, id);

    }
}
