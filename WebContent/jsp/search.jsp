
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<div class="w3-container w3-teal">
  <h1>Book Reads</h1>
</div>

<title>Insert title here</title>
</head>
<body>
<ul>
  <li><a href="userlogin">Home</a></li>
  <li><a href="listBook">List Of Books</a></li>
  <li><a href="search">View Prevoius Logs</a></li>
  <li><a href="userlogin">Log Out</a></li>
  
  
</ul>

<h3>Hello User , Here You can See the list of Books you have Issued</h3><br>
<center>

<h4>Please Enter your UserName</h4>
		
		<form action="listuser" method="GET">
			<table>
				User name:
				<input type="text" name="userName" value="">
				<br>
				<br>
			</table>
			<br> <br> <input type="submit" value="Submit" />
		</form>
</center>
</body>
</html>