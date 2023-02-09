package uz.jahongir.admin.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.jahongir.admin.services.AdminService;
import uz.jahongir.library.entities.Admin;
import uz.jahongir.library.entities.Region;
import uz.jahongir.library.repositories.AdminRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Override
    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public List<Admin> findAll() {
        return (List<Admin>) adminRepository.findAll();
    }
}
