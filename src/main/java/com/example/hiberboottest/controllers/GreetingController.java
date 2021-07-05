package com.example.hiberboottest.controllers;

import com.example.hiberboottest.User;
import com.example.hiberboottest.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        User u = userRepository.findByUserName(name);
        if (u == null) {
            User newUser = new User();
            newUser.setUserName(name);
            model.addAttribute("name", userRepository.save(newUser).getUserName());
        }
        return "greeting";
    }

}