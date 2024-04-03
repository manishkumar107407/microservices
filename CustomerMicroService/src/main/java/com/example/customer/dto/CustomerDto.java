package com.example.customer.dto;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto 
{	
 @JsonIgnore	
 String id;	

@JsonIgnore
private String extra;

@NotEmpty(message = "Name is Required")
@Size(min = 3,max = 50, message = "Name Must be Bteween 3 to 50")
@Pattern(regexp ="^[a-zA-Z\s]+$",message = "Name must Contains only letter and Space" )
private String name;


@NotEmpty(message = "Email is Required")
@Size(min = 5,max = 60, message = "Email Must be Bteween 5 to 60")
@Pattern(regexp ="^(.+)@(.+)$",message = "Inalid Email Format" )
private String email;

@NotEmpty(message = "Mobile Number is Required")
@Size(min = 10,max = 10, message = "Mobile Must 10 digit ")
private String mobile;


@NotEmpty(message = "Password is Required")
@Size(min = 3,max = 20, message = "Password Must be Bteween 3 to 20")
private String  pass;

private Object order;





}
