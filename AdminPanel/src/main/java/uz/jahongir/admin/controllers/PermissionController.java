package uz.jahongir.admin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.jahongir.admin.services.PermissionService;
import uz.jahongir.library.entities.Permission;
import uz.jahongir.library.entities.Region;

import java.util.List;

@Controller
@RequestMapping("/permissions")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;

    @GetMapping()
    public String places(Model model) {
        List<Permission> permissions = permissionService.findAll();

        System.out.println(permissions);
        model.addAttribute("permissions", permissions);
        System.out.println(model);
        return "permissions/permissions";
    }

    @GetMapping("/add")
    public String add(Model model) {
        Permission permission = new Permission();
        model.addAttribute("permission", permission);
        return "permissions/form";
    }


    @PostMapping("/add")
    public String save(Permission permission, Model model) {
        permissionService.save(permission);
        return "redirect:/permissions";
    }

}
