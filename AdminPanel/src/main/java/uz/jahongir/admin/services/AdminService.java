package uz.jahongir.admin.services;

import org.springframework.data.domain.Page;
import uz.jahongir.library.entities.Admin;


import java.util.List;

public interface AdminService {
    int PAGE_SIZE=5;
    Admin save(Admin admin);

    List<Admin> findAll();
    Page<Admin> findAllByPage(int pageNum, int pageSize, String sortField, String sortDir);

    Admin findById(Long id);

    void deleteById(Long id);

    void changeEnabledStatus(Long id, boolean status);
}
