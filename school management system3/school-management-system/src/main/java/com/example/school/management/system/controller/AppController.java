package com.example.school.management.system.controller;

import com.example.school.management.system.model.Account;
import com.example.school.management.system.model.Student;
import com.example.school.management.system.service.AccountRepo;
import com.example.school.management.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    private StudentService service;


    @Autowired
    public AppController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("student",service.getStudents());
        return "home";
    }
    @GetMapping("/home")
    public String home2(Model model){
        model.addAttribute("student",service.getStudents());
        return "home";
    }
    @GetMapping("/view")
    public String viewStudents(Model model){
        model.addAttribute("student", service.getStudents());
        return "view";
    }
    @GetMapping("/add")
    public String addStudent(Model model){
        model.addAttribute("student",new Student());
        return "addStudent";
    }
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student){
        service.addStudent(student);
        return "redirect:/";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id,Model model){
        model.addAttribute("student",service.getStudentById(id));
        return "updateStudent";
    }
    @GetMapping("/viewStudent/{id}")
    public String viewStudent(@PathVariable("id")Long id,Model model){
        model.addAttribute("student",service.getStudentById(id));
        return "viewStudent";
    }
    @PostMapping("/updateStudent")
    public String saveUpdate(@ModelAttribute Student student){
        service.addStudent(student);
        return "redirect:/";

    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        service.deleteStudentById(id);
        return "redirect:/";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }




}
