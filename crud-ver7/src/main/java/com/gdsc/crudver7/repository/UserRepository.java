package com.gdsc.crudver7.repository;

import com.gdsc.crudver7.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
