package app.dao;
import app.entity.User;
import java.util.List;

//варианты взаимодействия с базой данных


public interface DAO {

    List<User> allUsers();

    public User getId(int UserId);

    void addUser(User user);

    void updateUser(User user);


    void deleteUser (int UserId);
}
