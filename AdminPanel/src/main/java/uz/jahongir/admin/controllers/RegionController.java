package uz.jahongir.admin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import uz.jahongir.admin.services.RegionService;
import uz.jahongir.library.entities.Region;

import javax.validation.Valid;

@Controller
@RequestMapping("/regions")
@RequiredArgsConstructor
public class RegionController {

    private final RegionService regionService;

    @GetMapping
    public String list(Model model) {
        return listByPage(1, 10,"name","asc",null, model);
    }

    @GetMapping("/page/{pageNum}/size/{pageSize}")
    public String listByPage(@PathVariable int pageNum,
                             @PathVariable int pageSize,
                             @RequestParam String sortField,
                             @RequestParam String sortDir,
                             @RequestParam(required = false) String keyword,
                             Model model) {
        Page<Region> page = regionService.findAllByPage(pageNum, pageSize, sortField, sortDir, keyword);
        System.out.println(keyword);
        long startCount = (pageNum - 1) * pageSize + 1;
        long endCount=startCount+pageSize-1;
        long totalCount=page.getTotalElements();
        if (endCount > totalCount) endCount = totalCount;
        model.addAttribute("regions", page);
        model.addAttribute("startCount", startCount);
        model.addAttribute("endCount", endCount);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("currentSize", pageSize);
        model.addAttribute("sortField", sortField);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("keyword", keyword);
        return "regions/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("region", new Region());
        return "regions/form";
    }


    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        Region region = regionService.findById(id);
        model.addAttribute("region", region);
        System.out.println(model);
        return "regions/form";
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public Boolean delete(@PathVariable Long id) {
        regionService.deleteById(id);
        return true;
    }

    @PostMapping("/add")
    public String save(@Valid Region region, Errors errors) {
        if (errors.hasErrors()) {
            return "regions/form";
        }
        regionService.save(region);
        return "redirect:/regions";
    }

}
