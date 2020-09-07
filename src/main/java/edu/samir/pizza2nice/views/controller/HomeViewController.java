package edu.samir.pizza2nice.views.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeViewController {
    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/pizza2nice")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }
}