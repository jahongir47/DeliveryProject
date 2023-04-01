package uz.jahongir.admin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uz.jahongir.admin.services.UserService;
import uz.jahongir.library.entities.User;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping
    public String list(Model model){
        return listByPage(1,10,"firstName","asc", model);
    }

    public String listByPage(@PathVariable int pageNum,
                             @PathVariable int pageSize,
                             @RequestParam String sortField,
                             @RequestParam String sortDir,
                             Model model){
        Page<User> page=userService.findAllByPage(pageNum,pageSize,sortField,sortDir);
        long startCount=(pageNum-1)*pageSize+1;
        long endCount=startCount+pageSize-1;
        long totalCount=page.getTotalElements();
        if (endCount>totalCount)endCount=totalCount;
        model.addAttribute( "admins", page);
        model.addAttribute("startCount",startCount);
        model.addAttribute("endCount",endCount);
        model.addAttribute("totalCount",totalCount);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("currentSize", pageSize);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc":"asc");
        return "admins/list";
    }


}
