package ru.hrumi.hw_311.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.hrumi.hw_311.model.User;
import ru.hrumi.hw_311.service.UserService;


@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping() //для получение view со списком users
    public String getAll(Model model) {
        model.addAttribute("usersList", userService.getAllUsers());
        return "index";
    }

//    @GetMapping("/new") //получение view для создания нового user
//    public String newUser(@ModelAttribute("user") User user) {
//        return "new";
//    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user";
    }

    @PostMapping() //ловим ПОСТ запрос из view new
    public String addNewUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @PatchMapping ("/{id}")  //отправка данных страницы изменения в БД
    public String EditUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(id, user);
        return "redirect:/users";
    }
}
