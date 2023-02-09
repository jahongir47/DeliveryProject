package uz.jahongir.admin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.jahongir.admin.services.PlaceService;
import uz.jahongir.admin.services.RegionService;
import uz.jahongir.library.entities.Place;
import uz.jahongir.library.entities.Region;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/places")
@RequiredArgsConstructor
public class PlaceController {

  private final PlaceService placeService;
  private final RegionService regionService;

    @GetMapping()
    public String places(Model model){

        List<Place> places= placeService.findAll();

        model.addAttribute("places",places);
        System.out.println(model);
        return "places/places";
    }

    @GetMapping("/add")
    public String add(Model model){
        System.out.println("Keldi1");
        List<Region> regions = regionService.findAll();

        Place place=new Place();
        System.out.println(place);
        model.addAttribute("regions",regions);
        model.addAttribute("place",place);
        System.out.println(model);
        return "places/form";
    }


    @PostMapping("/add")
    public String save(Place place, Model model){
        System.out.println("Keldi2");
        placeService.save(place);
        return "redirect:/places";
    }

}
