package uz.jahongir.admin.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.jahongir.admin.services.PermissionService;
import uz.jahongir.library.entities.Permission;
import uz.jahongir.library.entities.Region;
import uz.jahongir.library.repositories.PermissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;

    @Override
    public Permission save(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public List<Permission> findAll() {
        return (List<Permission>) permissionRepository.findAll();
    }
}
