package com.example.Balancebliss.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Balancebliss.model.User;

public interface UserRepository extends JpaRepository <User,Integer>{
    
}
