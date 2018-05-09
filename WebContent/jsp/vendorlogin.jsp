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
  <li><a class="active" href="home" name="ss">Home</a></li>
  <li><a href="adminlogin" name="ad">Admin login</a></li>
  <li><a href="userlogin" name="">User Login</a></li>
  <li><a href="home">logout</a></li>
  
</ul>
<p align="center" style="font-size:50px;">Vendor Login</p>
<center>
<table>
<form action="addnew" method="GET">
<pre> 
</pre>
  


  <div class="container">
    <label for="vendorname"><b><tr><th>Vendorname</b></label></th>
  <td>  <input type="text" placeholder="Enter Name" name="vendorname" required></td></tr>

    <label for="psw"><b><tr><th>Password</b></label></th>
    <td><input type="password" placeholder="Enter Password" name="psw" required></td></th></table>
        
        <br><br>
    <input type="submit" value="login" name="submit"></center>
    
    
  </div>

  <div class="container" style="background-color:#00FF00">
         
  </div>
</form>

</body>
</html>
    