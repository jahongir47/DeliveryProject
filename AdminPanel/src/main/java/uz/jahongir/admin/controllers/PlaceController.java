package uz.jahongir.admin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import uz.jahongir.admin.services.PermissionService;
import uz.jahongir.admin.services.PlaceService;
import uz.jahongir.admin.services.RegionService;
import uz.jahongir.library.entities.Place;
import uz.jahongir.library.entities.Region;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/places")
@RequiredArgsConstructor
public class PlaceController {

  private final PlaceService placeService;
  private final RegionService regionService;

    @GetMapping
    public String list(Model model) {
        return listByPage(1,10,"name","asc",null, model);
    }
    @GetMapping("/page/{pageNum}/size/{pageSize}")
    public String listByPage(@PathVariable int pageNum,
                             @PathVariable int pageSize,
                             @RequestParam String sortField,
                             @RequestParam String sortDir,
                             @RequestParam(required = false) String keyword,
                             Model model) {
        System.out.println(keyword);
        Page<Place> page=placeService.findAllByPage(pageNum,pageSize,sortField,sortDir, keyword);
        long startCount=(pageNum-1)*pageSize+1;
        long endCount=startCount+pageSize-1;
        long totalCount=page.getTotalElements();
        if (endCount>totalCount)endCount=totalCount;
        model.addAttribute( "places", page);
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
        System.out.println(keyword);

        return "places/list";
    }

//    @GetMapping()
//    public String places(Model model){
//        List<Place> places= placeService.findAll();
//        model.addAttribute("places",places);
//        return "places/list";
//    }


    @GetMapping("/create")
    public String create(Model model){
        List<Region> regions = regionService.findAll();
        model.addAttribute("regions",regions);
        model.addAttribute("place",new Place());
        return "places/form";
    }

    @GetMapping("/update/{id}")
    public String create(@PathVariable Long id, Model model){
        List<Region> regions = regionService.findAll();
        Place place=placeService.findById(id).get();
        model.addAttribute("regions",regions);
        model.addAttribute("place",place);
        return "places/form";
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public Boolean delete(@PathVariable Long id){
        System.out.println("Deletega keldi");
        placeService.deleteById(id);
        return true;
    }


    @PostMapping("/save")
    public String save(@Valid Place place, Errors errors){
        if (errors.hasErrors()){
            return "places/form";
        }
        placeService.save(place);
        return "redirect:/places";
    }

}
