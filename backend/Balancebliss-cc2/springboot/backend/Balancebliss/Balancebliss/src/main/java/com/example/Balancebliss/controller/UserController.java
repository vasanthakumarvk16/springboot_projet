package com.example.Balancebliss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Balancebliss.model.Request;
import com.example.Balancebliss.model.User;
import com.example.Balancebliss.repository.UserRepository;
import com.example.Balancebliss.service.UserService;

@RestController
@RequestMapping("/balancebliss")
public class UserController {
    @Autowired
    private final UserService service;
    @Autowired
    private final UserRepository repository;
    
    public UserController(UserService service, UserRepository repository) {
        this.service = service;
        this.repository = repository;
    }
    @PostMapping("/adduser")
    public User creatuser(@RequestBody User user){
        return service.createuser(user);
    }
    @PostMapping("/adduserwithaccount")
    public User adduser(@RequestBody Request req){
        return repository.save(req.getUser());
    }
    @GetMapping("/getallusers")
    public List<User> getallUsers(){
        //List<User> users=service.getalllusers();
        return service.getalllusers();
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
    @GetMapping("/pagination/{offset}/{pagesize}/{field}")
    public Page<User> pagination(@PathVariable ("offset") int offset,@PathVariable ("pagesize") int pagesize,@PathVariable ("field") String field){
        return service.pagination(offset,pagesize,field);
    }
   
}
