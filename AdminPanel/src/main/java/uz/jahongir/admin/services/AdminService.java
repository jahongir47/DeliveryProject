package uz.jahongir.admin.services;

import org.springframework.data.domain.Page;
import uz.jahongir.library.entities.Admin;
import uz.jahongir.library.entities.Permission;


import java.util.List;

public interface AdminService {
    int PAGE_SIZE=5;
    Admin save(Admin admin);

    List<Admin> findAll();
    Page<Admin> findAllByPage(int pageNum);

    Admin findById(Long id);

    void deleteById(Long id);
}
