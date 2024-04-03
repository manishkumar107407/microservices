package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gurushi")
public class User
{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
@NotBlank(message = "Name cannot be blank")
private String name;
@Pattern(regexp = "/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$/",message = "Incorrect format of email")
@NotBlank(message = "Email cannot be blank")
private String email;
@Size(min = 10,max = 10,message = "Mobile must be of 10 digits")
@NotBlank(message = "Mobile cannot be blank")
private String mobile;
@NotBlank(message = "Password cannot be blank")
private String pass;
}
