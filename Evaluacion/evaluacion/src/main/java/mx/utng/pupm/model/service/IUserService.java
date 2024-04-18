package mx.utng.pupm.model.service;


import java.util.List;

import mx.utng.pupm.model.entity.User;

public interface IUserService {
    List<User> list();
    void save(User user);
    User getById(Long id);
    void delete(Long id);
}

