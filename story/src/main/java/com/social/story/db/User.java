package com.social.story.db;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Data
@Entity
@Table(name = "user_account")
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;


    public User(){}
    public User(String userName,String firstName,String email,String password){
        this.userName = userName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
    }
}
