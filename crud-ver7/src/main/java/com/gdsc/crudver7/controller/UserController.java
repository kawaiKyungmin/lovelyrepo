package com.gdsc.crudver7.controller;

import com.gdsc.crudver7.entity.User;
import com.gdsc.crudver7.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers(){
    return userService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        //@PathVariable : 중괄호 안에들어있는 '{id}'를 사용하여 매개변수를 받는다.
        return userService.findById(id);
    }
    @PostMapping
    public User createUser(@RequestParam String name, @RequestParam String title, @RequestParam String content){
        User user = new User(name,title,content);
        return userService.save(user);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestParam String name, @RequestParam String title, @RequestParam String content){
        User user = new User(name,title,content);
        return userService.update(id,user);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteById(id);
    }
}