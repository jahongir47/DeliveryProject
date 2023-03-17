package uz.jahongir.admin.services;

import uz.jahongir.library.entities.User;

import java.util.List;

public interface UserService {
    User save(User user1);
    List<User> findAll();
    User findById(Integer id);
    void deleteById(Integer id);
}
