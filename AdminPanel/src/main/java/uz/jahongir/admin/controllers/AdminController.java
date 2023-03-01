package uz.jahongir.admin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import uz.jahongir.admin.services.AdminService;
import uz.jahongir.admin.services.PermissionService;
import uz.jahongir.library.entities.Admin;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admins")
@RequiredArgsConstructor
public class AdminController {

  private final AdminService adminService;

    @GetMapping
    public String list(Model model) {
        return listByPage(1, model);
    }

    @GetMapping("/page/{pageNum}")
    public String listByPage(@PathVariable int pageNum, Model model){
        Page<Admin> page=adminService.findAllByPage(pageNum);
        long startCount=(pageNum-1)* 10+1;
        long endCount=startCount+10-1;
        long totalCount=page.getTotalElements();
        if (endCount>totalCount)endCount=totalCount;
        model.addAttribute( "admins", page);
        model.addAttribute("startCount",startCount);
        model.addAttribute("endCount",endCount);
        model.addAttribute("totalCount",totalCount);
        return "admins/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("admin", new Admin());
        return "admins/form";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        Admin admin=  adminService.findById(id);
        model.addAttribute("admin", admin);
        return "admins/form";
    }
    @GetMapping("/delete/{id}")
    @ResponseBody
    public Boolean  delete(@PathVariable Long id) {
        adminService.deleteById(id);
        return true;
    }
    @PostMapping("/save")
    public String add(@Valid Admin admin, Errors errors){
        System.out.println("Keldi");
        if (errors.hasErrors()){
            System.out.println("Return");
            return "admins/form";

        }
        System.out.println("1");
        adminService.save(admin);
        System.out.println("2");
        return "redirect:/admins";
    }


}
