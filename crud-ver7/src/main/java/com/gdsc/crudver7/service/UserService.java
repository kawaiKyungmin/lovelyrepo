package com.gdsc.crudver7.service;

import com.gdsc.crudver7.entity.User;
import com.gdsc.crudver7.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {return userRepository.findAll();}

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public User save(User user){
        return userRepository.save(user);
    }
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
    public User update(Long id, User userDetails){
        User user = userRepository.findById(id).orElseThrow
                (()-> new IllegalArgumentException("We dont have that id"));
        user.setName(userDetails.getName());
        user.setTitle(userDetails.getTitle());
        user.setContent(userDetails.getContent());
        return userRepository.save(user);
    }
}
