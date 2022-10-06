package com.example.school.management.system.model;

import lombok.*;
import javax.persistence.*;


@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
public class Account{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Username",nullable = false)
    private String username;
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name = "full name",nullable = false)
    private  String fullName;
    @Column(name = "email",nullable = false)
    private String email;


    public Account(Long id, String username, String password, String fullName, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
