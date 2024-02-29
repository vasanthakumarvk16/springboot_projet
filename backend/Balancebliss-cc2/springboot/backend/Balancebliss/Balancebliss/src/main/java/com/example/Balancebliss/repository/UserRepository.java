package com.example.Balancebliss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Balancebliss.model.User;
@Repository
public interface UserRepository extends JpaRepository <User,Integer>{
    
}
