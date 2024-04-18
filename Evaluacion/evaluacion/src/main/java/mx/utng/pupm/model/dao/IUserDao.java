package mx.utng.pupm.model.dao;

import java.util.List;

import mx.utng.pupm.model.entity.User;

public interface IUserDao {
    List<User> list();
    void save(User user);
    User getById(Long id);
    void delete(Long id);
}