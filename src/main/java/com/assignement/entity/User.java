package com.assignement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Entity
@Data  // generates getters, setters, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UserId;

    @NotBlank(message = "need first name")
    private String firstName;

    @NotBlank(message = "need last name")
    private String lastName;

    @NotBlank(message = "need email")
    private String email;

    @NotBlank(message = "password cannot be null")
    private String password;





}
