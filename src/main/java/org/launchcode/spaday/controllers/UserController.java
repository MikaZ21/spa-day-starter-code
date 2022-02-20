package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.launchcode.spaday.persistance.UserDictionary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

//    private UserDictionary userDictionary;
//
//    public UserController(UserDictionary userDictionary) {
//        this.userDictionary = userDictionary;
//    }

    @GetMapping("/add")
    public String displayAddUserForm(Model model) {
        model.addAttribute("title", "Add User");
        model.addAttribute(new User());
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute @Valid User user,
                                     Errors errors, String verify) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add User");
            return "user/add";
        }
            model.addAttribute("user", user);
//            userDictionary.userArrayList.add(user);
            model.addAttribute("verify", verify);
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            if (user.getPassword().equals(verify)) {
                return "user/index";
            } else {
                model.addAttribute("error", "Passwords do not match");
                return "user/add";
            }
        }
//            return "redirect:";


}
