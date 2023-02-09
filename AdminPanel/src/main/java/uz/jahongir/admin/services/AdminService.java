package uz.jahongir.admin.services;

import uz.jahongir.library.entities.Admin;


import java.util.List;

public interface AdminService {
    Admin save(Admin admin);

    List<Admin> findAll();
}
