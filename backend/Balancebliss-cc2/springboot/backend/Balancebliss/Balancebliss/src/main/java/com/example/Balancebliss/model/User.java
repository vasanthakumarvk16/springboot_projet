package com.example.Balancebliss.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    private int userID;
    private String userName;
    private String password;
    private String emailAddress;
    @OneToMany(targetEntity = Accounts.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "userid",referencedColumnName = "userID")
    List<Accounts> accounts;
   
}
