package com.gdsc.crud5.service;

import com.gdsc.crud5.entity.User;
import com.gdsc.crud5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    //유저 레포지토리를 끌어다 씀

    public List<User> findAll() {
        //List형태로 반환 : 해당되는 내용 전부 반환
        return userRepository.findAll();
        //UserRepository에서 기본으로 제공하는 메소드 findAll()호출
    }
    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }
    public User save(User user){
        return userRepository.save(user);
    }
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
}
