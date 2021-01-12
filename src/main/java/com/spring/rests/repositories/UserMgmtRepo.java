package com.spring.rests.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.rests.models.User;

public interface UserMgmtRepo extends JpaRepository<User, Long>{

}
