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
    public List<User> AllUsers() {
        String sql = " SELECT * FROM contacts";

        return JT.query(sql, new UserMapper());
        }


    @Override
    public void AddUser(User user) {
        String sql = "INSERT INTO contacts (name, city, phone) VALUES (?,?,?)";
        JT.update(sql, user.getName(), user.getCity(), user.getPhone());

    }

   @Override
    public User GetId(int id) {
        String sql = "SELECT * FROM contacts WHERE id = ?";
        return JT.queryForObject(sql, new UserMapper(), id);

    }

    @Override
    public void UpdateUser(User user) {
        String sql = "UPDATE contacts SET name=?, city=?, phone=? WHERE id=?";
        JT.update(sql, user.getName(), user.getCity(), user.getPhone(), user.getId());

    }

    @Override
    public void DeleteUser(int id) {
        String sql = "DELETE FROM contacts WHERE id=?";
        JT.update(sql, id);

    }
}
