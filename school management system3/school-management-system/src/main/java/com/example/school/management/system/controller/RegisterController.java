package com.example.school.management.system.controller;


import com.example.school.management.system.model.Account;
import com.example.school.management.system.service.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private AccountRepo accountRepo;

    @GetMapping
    public String register(Model model){
      model.addAttribute("account", new Account());
        return "register";
    }
    @PostMapping
    public String processRegistration(Account user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        accountRepo.save(user);
        return "login";

    }
}
