package uz.jahongir.admin.services;

import org.springframework.data.domain.Page;
import uz.jahongir.library.entities.Admin;
import uz.jahongir.library.entities.User;

import java.util.List;

public interface UserService {
    User save(User user1);
    List<User> findAll();
    User findById(Integer id);
    void deleteById(Integer id);
    Page<User> findAllByPage(int pageNum, int pageSize, String sortField, String sortDir);
}
