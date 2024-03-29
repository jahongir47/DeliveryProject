package uz.jahongir.admin.services;

import org.springframework.data.domain.Page;
import uz.jahongir.library.entities.Permission;

import java.util.List;

public interface PermissionService {
    Permission save(Permission permission);

    List<Permission> findAll();
    Page<Permission> findAllByPage(int pageNum, int pageSize, String sortField, String sortDir,String keyword);

    Permission findById(Long id);

    void deleteById(Long id);
}

