package com.example.Balancebliss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.Balancebliss.model.User;
import com.example.Balancebliss.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private final UserRepository repository;
    public UserService(UserRepository repository) {
        this.repository = repository;
    }
    public User createuser(User user1){
        return repository.save(user1);
    }
    public List<User> getalllusers(){
        List<User> users=repository.findAll();
        return users;
    }
    public User getUserByID(int userID){
        return repository.findById(userID).orElse(null);
    }
    public User updateUserById(int userID,User user){
        User u=repository.findById(userID).orElse(null);
        if(u!=null){
            u.setUserID(user.getUserID());
            u.setUserName(user.getUserName());
            u.setEmailAddress(user.getEmailAddress());
            u.setPassword(user.getPassword());
        }
        return repository.save(u);
    }
    public Boolean deleteUserById(int userID){
        repository.deleteById(userID);
        return true;
    }
    public Page<User> pagination(int offset,int pagesize,String field){
        return repository.findAll(PageRequest.of(offset, pagesize, Sort.by(field)));
    }
   

}
