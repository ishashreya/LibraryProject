<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>




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
  <li><a class="active" href="adminlogin">Home</a></li>
  <li><a class="active" href="userlogin">User ?</a></li>
  
</ul>
<center>
<h1 style ="color: blue;">Admin REGISTRATION FORM</h1>
</center>
<form action="addlib" method="GET" >
<center>
 

<table>

<tr><th>AdminId:</th>
<td><input type="text" name="id" value="1" required/><div id="errormsg" style="color:red"></td></tr></div><br>

<tr><th>ADMINNAME:</th>
<td><input type="text" name="Name" value="shreya" required/><div id="errormsg" style="color:red"></td></tr></div>

<tr><th>PASSWORD:</th>
<td><input type="text" name="Password" value="shreya" required/><div id="error" style="color:red"></td></tr></div>
<tr><th>EMAIL:</th>
<td><input type="text" name="Email" value="shreya@gmail.com" required/><div id="ermsg" style="color:red"></td></tr></div>
<tr><th>ADDRESS:
<td><input type="text" name="Address" value="kota" required/><div id="errorms" style="color:red"></td></tr></div>

<tr><th>CITY:</th>
<td><input type="text" name="City" value="kota" required/><div id="errzq" style="color:red"></td></tr></div>

<tr><th>CONTACT NO:</th>
<td><input type="text" name="ContactNo" value="234567890" required/><div id="errzq" style="color:red"></td></</div>
</table>


<input type="submit" value="Submit" />
</form>
</centre>
</body>

</html>
