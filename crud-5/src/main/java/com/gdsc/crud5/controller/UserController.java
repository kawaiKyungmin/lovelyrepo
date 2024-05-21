package com.gdsc.crud5.controller;

import com.gdsc.crud5.entity.User;
import com.gdsc.crud5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//API라고 선언
@RequestMapping("/users")
public class UserController {
     @Autowired
    private UserService userService;
     //service 부분을 끌어다 씀

    @GetMapping// '/users'만 쓰면 실행됨
    public List<User> getAllUsers(){
        return userService.findAll();
        //UserService에서 findAll()메소드 끌어오기
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        //@PathVariable : URL 경로의 {id}를 매개변수로 받음
        return userService.findById(id);
        //id로 찾아서 리턴
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        user.setId(id);
        return userService.save(user);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteById(id);
    }
}
