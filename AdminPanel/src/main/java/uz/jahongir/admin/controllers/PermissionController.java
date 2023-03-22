package uz.jahongir.admin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import uz.jahongir.admin.dto.DatatableOutput;
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
    public DatatableOutput<Permission> listAjax(@RequestParam Map<String, Object> params, Model model) {
        System.out.println("++++Keldi++");
        Integer start=Integer.valueOf((String) params.get("start"));
        Integer length=Integer.valueOf((String)params.get("length"));
        return permissionService.findAll(start, length);
    }

    @GetMapping("/page/{pageNum}/size/{pageSize}")
    public String listByPage(@PathVariable int pageNum,
                             @PathVariable int pageSize,
                             @RequestParam String sortField,
                             @RequestParam String sortDir,
                             @RequestParam(required = false) String keyword,
                             Model model) {

        System.out.println(sortField);
        System.out.println(sortDir);
       Page<Permission>  page=permissionService.findAllByPage(pageNum,pageSize,sortField,sortDir, keyword);
        long startCount=(pageNum-1)*pageSize+1;
        long endCount=startCount+pageSize-1;
        long totalCount=page.getTotalElements();
        if (endCount>totalCount)endCount=totalCount;
        model.addAttribute( "permissions", page.getContent());
        model.addAttribute("startCount",startCount);
        model.addAttribute("endCount",endCount);
        model.addAttribute("totalCount",totalCount);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("currentSize", pageSize);
        model.addAttribute("sortField", sortField);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc":"asc");
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("keyword", keyword);

        return "permissions/list";
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
