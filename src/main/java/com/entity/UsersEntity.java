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
    private Integer id_users;
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private String password;
    private String verification_code;

    public String print() {
        return "ID = " + id_users + ", name = " + name + ", surname = " + surname + ", age = " + age +
                ", email = " + email + ", password = " + password + ", verificationCode = " + verification_code;
    }
}
