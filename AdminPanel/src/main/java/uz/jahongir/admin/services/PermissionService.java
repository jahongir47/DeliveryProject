package uz.jahongir.admin.services;

import uz.jahongir.library.entities.Permission;
import uz.jahongir.library.entities.Region;

import java.util.List;

public interface PermissionService {
    Permission save(Permission permission);

    List<Permission> findAll();
}
