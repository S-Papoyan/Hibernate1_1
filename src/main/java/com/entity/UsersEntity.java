package com.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UsersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String first_name;
    private String last_name;
    private Integer age;
    private String email;
    private String password;
    private String verification_code;

    public String print() {
        return "ID = " + id + ", name = " + first_name + ", surname = " + last_name + ", age = " + age +
                ", email = " + email + ", password = " + password + ", verificationCode = " + verification_code;
    }
}
