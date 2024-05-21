package com.gdsc.crud5.repository;

import com.gdsc.crud5.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}