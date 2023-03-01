package uz.jahongir.admin.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.jahongir.admin.services.AdminService;
import uz.jahongir.library.entities.Admin;
import uz.jahongir.library.repositories.AdminRepository;
import uz.jahongir.library.repositories.PermissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final PermissionRepository permissionRepository;

    @Override
    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public List<Admin> findAll() {
        return (List<Admin>) adminRepository.findAll();
    }

    @Override
    public Page<Admin> findAllByPage(int pageNum) {
        Pageable pageable= PageRequest.of(pageNum-1,PAGE_SIZE);
        Page<Admin> page = adminRepository.findAll(pageable);
        return page;
    }

    @Override
    public Admin findById(Long id) {
        return adminRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        permissionRepository.deleteById(id);
    }
}
