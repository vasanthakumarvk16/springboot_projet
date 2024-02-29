package com.example.Balancebliss.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Accounts {
    @Id
    private int accountID;
    private String accountName;
    private String accountType;
}
