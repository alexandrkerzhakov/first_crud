package com.example.empl4sem2CRUD.controllers;

import com.example.empl4sem2CRUD.model.User;
import com.example.empl4sem2CRUD.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@Log
public class UserController {
    private UserService userService;

    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        log.info("Request GET on http://localhost:8080/users");
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        log.info("Request GET on http://localhost:8080/user-create for user " + user);
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        log.info("Request POST on http://localhost:8080/user-create for user " + user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteById(id);
        log.info("Request GET on http://localhost:8080/user-delete/id for id " + id);
        return "redirect:/users";
    }


    @GetMapping("/user-update/{id}")
    public String updateUser(@PathVariable("id") int id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        log.info("Request GET on http://localhost:8080/user-update/id for id " + id);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.update(user);
        log.info("Request POST on http://localhost:8080/user-update for user " + user);
        return "redirect:/users";
    }
}
