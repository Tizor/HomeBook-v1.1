package app.dao;
import app.entity.User;
import java.util.List;

//варианты взаимодействия с базой данных


public interface DAO {

    List<User> AllUsers();

    public User GetId(int UserId);

    void AddUser(User user);

    void UpdateUser(User user);


    void DeleteUser (int UserId);
}
