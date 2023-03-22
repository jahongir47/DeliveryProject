package uz.jahongir.admin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import uz.jahongir.admin.services.PermissionService;
import uz.jahongir.library.entities.Permission;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/permissions")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;

    @GetMapping
    public String list() {
        return "permissions/list2";
    }

    @GetMapping("/ajax")
    @ResponseBody
    public  Map<String, Object> listAjax(@RequestParam Map<String, Object> params, Model model) {
        System.out.println("++++Keldi++");
        return permissionService.findAll(params);
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("permission", new Permission());
        return "permissions/form";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
      Permission permission=  permissionService.findById(id);
        model.addAttribute("permission", permission);
        return "permissions/form";
    }
    @GetMapping("/delete/{id}")
    @ResponseBody
    public Boolean  delete(@PathVariable Long id) {
       permissionService.deleteById(id);
        return true;
    }

    @PostMapping("/save")
    public String save(@Valid  Permission permission, Errors errors, Model model) {
        if (errors.hasErrors()){
            return "permissions/form";
        }
        permissionService.save(permission);
        return "redirect:/permissions";
    }

}
