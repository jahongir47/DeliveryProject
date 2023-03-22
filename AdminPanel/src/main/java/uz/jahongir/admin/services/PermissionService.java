package uz.jahongir.admin.services;

import org.springframework.data.domain.Page;
import uz.jahongir.admin.dto.DatatableOutput;
import uz.jahongir.library.entities.Permission;

import java.util.List;
import java.util.Map;

public interface PermissionService {
    Permission save(Permission permission);

    List<Permission> findAll();
    DatatableOutput<Permission> findAll(Integer start, Integer length);
    Page<Permission> findAllByPage(int pageNum, int pageSize, String sortField, String sortDir,String keyword);

    Permission findById(Long id);

    void deleteById(Long id);
}

