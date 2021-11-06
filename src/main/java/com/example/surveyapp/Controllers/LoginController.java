package com.example.surveyapp.Controllers;

import com.example.surveyapp.Models.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

@Controller
public class LoginController {

    @GetMapping("/auth/login")
    public String LoginPage(){
        return "login";
    }

    @PostMapping("/auth/login")
    public String AdminLogin(@Valid Admin admin,
                                  BindingResult bindingResult,
                                  Model model){
        if (bindingResult.hasErrors()){
            String message = "Bad credentials!";
            model.addAttribute("message", message);
            model.addAttribute("admin", admin);
            return "login";
        }
        model.addAttribute("message", null);
        return "redirect:/admin";
    }
}
