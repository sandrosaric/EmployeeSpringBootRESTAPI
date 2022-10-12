package com.sandrosaric.springbootbackend.model;


import com.sun.istack.NotNull;
import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=2,message="First Name should have at least 2 characters")
    @Column(name="first_name",nullable = false)
    private String firstName;

    @NotNull
    @Size(min=2,message="Last Name should have at least 2 characters")
    @Column(name="last_name",nullable = false)
    private String lastName;

    @NotBlank
    @Email
    @Column(name="email",nullable = false)
    private String email;
}
