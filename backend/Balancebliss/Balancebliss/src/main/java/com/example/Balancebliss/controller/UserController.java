package com.example.Balancebliss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Balancebliss.model.User;
import com.example.Balancebliss.service.UserService;

@RestController
@RequestMapping("/balancebliss")
public class UserController {
    private final UserService service;
    
    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }
    @PostMapping("/adduser")
    public User creatuser(@RequestBody User user){
        return service.createuser(user);
    }
    @GetMapping("/getallusers")
    public List<User> getallUsers(){
        List<User> users=service.getalllusers();
        return users;
    }
    @GetMapping("/getuser/{userID}")
    public User getUserById(@PathVariable int userID){
        return service.getUserByID(userID);
    }
    @PutMapping("/updateuser/{userID}")
    public User updateUserById(@PathVariable int userID,@RequestBody User user){
        return service.updateUserById(userID, user);
    }
    @DeleteMapping("/deleteuser/{userID}")
    public Boolean deleteUserById(@PathVariable int userID){
        return service.deleteUserById(userID);
    }
}
