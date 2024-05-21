package com.gdsc.crud4.repository;

import com.gdsc.crud4.entity.crudEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface crudRepository extends JpaRepository<crudEntity,Long> {

}
