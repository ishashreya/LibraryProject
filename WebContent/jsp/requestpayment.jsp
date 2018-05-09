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


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<ul>
  <li><a class="adminlogin" href="#home" name="all">Home</a></li>
  <li><a href="vendorlistbook" name="vl">Supply Books</a></li>
  <li><a href="vendorlogin" name="ll">Log Out</a></li>
  
</ul>
<p style="font-size:15px;"> <br>  You can Ask for the Payments</p>

<center>
<p style="font-size:20px;">Payment Due</p>

<table>

<form action="addbookpay" method="GET">

  <tr><th>Book Name:</th>
  <td><input type="text" name="bookName" required></td></tr>
  <tr><th>Quantity:</th>
 <td> <input type="text" name="quantity" required></td></tr>
  
  <tr><th>Amount Due:</th>
 <td> <input type="text" name="amountDue" required></td></tr>
  
 
  <tr><th></th>
 <td> <input type="hidden" name="bookid" ></td></tr></table>
  <br><br>
  
  <input type="submit" value="Submit" name="submit">
</form> 

</center>



</body>
</html>