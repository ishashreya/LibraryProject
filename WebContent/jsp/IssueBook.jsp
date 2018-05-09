<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
  <li><a class="active" href="userlogin" name="us">Home</a></li>
  <li><a href="listBook" name="sb">Search Book</a></li>
  <li><a href="userlogin" name="as">Log Out</a></li>
  
</ul>
<center>
<table>
 <div class="container">

<p align="center" style="font-size:50px;">Issue Book</p>



<form action="addbookissue" method="GET">

<%-- <c:out value="${book.bookId}"/> 
 --%>  <tr><th>Book Id:</th>
  <td><input type="text" name="bookId"  value="${book.bookId}" />    </td></tr>
  
  <tr><th>User Name:</th>
 <td> <input type="text" name="username"  value="${user.username}"/> </td></tr>
  
   <tr><th>Book Name:</th>
  <td><input type="text" name="bookname" value="${book.bookname }"/></td></tr>
  
  <tr><th>Start Date:</th>
  <td><input type="date" name="startDate" required></td></tr>
  
  <tr><th>End Date:</th>
  <td><input type="date" name="endDate" required></td></tr>
  <br>
  
</table>  
 <div class="container" style="background-color:white">
 <br>
  <input type="submit" value="Submit" name="sn"></center>
  </div>
  
  </div>
</form> 



</body>
</html>