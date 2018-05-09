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
  <li><a class="active" href="home" name="home">Home</a></li>
  <li><a href="vendorlogin" name="vendor">Vendor login</a></li>
  <li><a href="userlogin" name="user">User Login</a></li>
  <li><a href="home" name="out">logout</a></li>
  
</ul>
<p align="center" style="font-size:50px;">Librarian Login Form</p>

<form action="addadmin" method="GET" >
<center>
 

<table>
  <div class="container">
<tr><th>AdminId: </th>
   <td> <input type="text" placeholder="Enter ID" name="id" required></td></tr>
    <tr><th>Adminname: </th>
   <th> <input type="text" placeholder="Enter Name" name="name" required></th></tr>

   <tr><th> Password: </th>
  <th>  <input type="password" placeholder="Enter Password" name="password" required></th>
    </table>  <br>
    <input type="submit" value="login" name="sb">
<br>
      <input type="checkbox" checked="checked" name="remember"> Remember me

  </div>

  <div class="container" style="background-color:white">
  <br>
        <a href="librarian_registration">Register</a></center>
  </div>
</form>

</body>
</html>
