package com.example.demo.entity; 
 
import jakarta.persistence.*; 
import jakarta.validation.constraints.*; 
 
@Entity 
public class studentEntity { 
 
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; 
 
    @NotBlank(message = "Name must not be empty") 
    private String name; 
 
    @Email(message = "Invalid Email format") 
    @NotBlank(message = "Email must not be empty") 
    private String email; 
 
}