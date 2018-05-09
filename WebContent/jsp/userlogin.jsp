<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<div class="w3-container w3-teal">
  <h1>Book Reads</h1>
</div>

<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover {
    background-color: #00FF00;
}
</style>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<ul>
  <li><a class="active" href="home">Home</a></li>
  <li><a href="vendorlogin">Vendor </a></li>
  <li><a href="adminlogin">Admin </a></li>
  <li><a href="userlogin">Log Out</a></li>
  <pre>
  </pre>
</ul>
<p align="center" style="font-size:50px;">User Login</p>
<center>
<table>

<form action="login" method="GET">
 


  <div class="container">
    <label for="username"><b><tr><th>Username</b></label></th>
   <td> <input type="text" placeholder="Enter Name" name="username" required></td></th>

    <label for="password"><b><tr><th>Password</b></label></th>
 <td>   <input type="password" placeholder="Enter Password" name="password" required></td></th></table>
        
    <input type="submit" value="Login" name="submit">
    <label>
    <br>
    </label>
  </div>
  <br><br>
            <a href="userreg">Register</a> </center>
 
</form>
</body>
</html>
