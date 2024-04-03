<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h1>Registration Page</h1>
<h2>${msg1}</h2>
<h3>${user1}</h3>
<h4>${user1.name}</h4>
<body>
<form action="register" method="post">
Name:<input type="text" name="name" placeholder="Enter name"> 
<br>
Email:<input type="email" name="email" placeholder="Enter email"> 
<br>
Mobile:<input type="tel" name="mobile" placeholder="Enter mobile"> 
<br>
Password:<input type="password" name="pass" placeholder="Enter password"> 
<br>
<input type="submit" value="Register">

</form>
</body>
</html>