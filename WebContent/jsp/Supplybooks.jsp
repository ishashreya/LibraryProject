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
    background-color: #111;
}
</style>

</head>
<ul>
  <li><a class="active" href="adminlogin" name="hh">Home</a></li>
  <li><a href="requestpayment" name="rp">Request Payment</a></li>
  <li><a href="vendorlogin" name="vb">Log Out</a></li>
  </ul>
  
  
  <center>
<p style="font-size:30px;">Supply Books</p>

<form action="addbook" method="GET">


<table>
  <div class="container">
  
  <tr><th>Book Name:</th>
  <td><input type="text" name="bookName"  value="${vbl.bookName}"></td></tr>
  
   <tr><th>Book Author:</th>
 <td> <input type="text" name="bookAuthor"  value="${vbl.bookAuthor}"></td></tr>
  
   <tr><th>Book Price:</th>
  <td><input type="text" name="price" required ></td></tr></table>
  <br><br>
  <input type="submit" value="Submit" name="submit">

</form> 
</div>

</center>

</head>

</html>
