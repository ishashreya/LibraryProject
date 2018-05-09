<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<body>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<ul>
		<li><a class="active" href="adminlogin" name="aa">Home</a></li>
		<li><a href="listadminbook" name="ll">List Of Books</a></li>
		<li><a href="vendorlogin" name="vn">Log Out</a></li>
	</ul>

	<p align="center" style="font-size: 50px;">Update Book</p>
	<center>
		<title>Update Record</title>
		<form action="updateNow" metod="GET">

			<table>
				<tr>
					<th>Id:<br></th>
					<td><input type="text" name="bookId" value="${bid}"></td>
				</tr>
				<br>
				<br>
				<tr>
					<th>Book Name:</th>
					<td><input type="text" name="bookName" value="${bookName}"></td>
				</tr>

				<tr>
					<th>Book Author:</th>
					<td><input type="text" name="bookAuthor" value="${bookAuthor }"></td>

				</tr>

				<tr>
					<th>Book Price:</th>
					<td><input type="text" name="price"></td>
				</tr>
			</table>

			<br>
			<br> <input type="submit" value="Submit" name="submit"> <input
				type="submit" value="EDIT">
	</center>


	</form>
</body>
</html>