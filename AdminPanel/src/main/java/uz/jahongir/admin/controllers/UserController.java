//package uz.jahongir.admin.controllers;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import uz.jahongir.admin.services.UserService;
//import uz.jahongir.library.entities.User;
//
//import javax.validation.Valid;
//
//@Controller
//@RequestMapping("user")
//@RequiredArgsConstructor
//public class UserController {
//
//    private final UserService userService;
//
//
//
//    @GetMapping
//    public String getForm(Model model) {
//        model.addAttribute("user", new User());
//        return "register";
//    }
//
//    @PostMapping
//    public String postForm(@Valid User user, Errors errors) {
////        System.out.println(user);
//        if (errors.hasErrors()){
////            System.out.println("Errors");
//            return "register";
//        }
//
//        userService.save(user);
//        return "redirect:/login";
//    }
//
//
//}
