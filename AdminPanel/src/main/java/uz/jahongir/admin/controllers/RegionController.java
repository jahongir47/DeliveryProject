package uz.jahongir.admin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.jahongir.admin.services.RegionService;
import uz.jahongir.library.entities.Region;

import java.util.List;

@Controller
@RequestMapping("/regions")
@RequiredArgsConstructor
public class RegionController {

    private final RegionService regionService;

    @GetMapping()
    public String places(Model model) {
        List<Region> regions = regionService.findAll();

        System.out.println(regions);
        model.addAttribute("regions", regions);
        System.out.println(model);
        return "regions/regions";
    }

    @GetMapping("/add")
    public String add(Model model) {
        Region region = new Region();
        model.addAttribute("region", region);
        return "regions/form";
    }


    @PostMapping("/add")
    public String save(Region region, Model model) {
        regionService.save(region);
        return "redirect:/regions";
    }

}
