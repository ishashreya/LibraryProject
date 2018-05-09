<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Show All Users</title>
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


<ul>
  <li><a href="userlogin">Home</a></li>
  
    <li><a href="vendorlistbook">Supply Books</a></li>
      <li><a href="requestpayment">Request Payment</a></li>
    
  
  <li><a href="userlogin">Log Out</a></li>
  
</ul>
<p style="font-size:15px;">Welcome, Vendor You have successfully Logged In<br> You can supply books to the Library</p>

<p align="center" style="font-size:30px;">Vendor Supply BookList</p>
</head>
<body>
<form action="vendorlistbook" method="GET" >
<center>
    <table border=1>
        <thead>
            <tr>
                
                <th>Book ID</th>
                <th>Book Name</th>
                <th>Book Author</th>
                <th>Book Price</th>
                <th>Book Quantity</th>
                <th>SupplyBooks</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${vlistbooks}" var="vbooks">
                <tr>
                    <td><c:out value="${vbooks.bookId}" /></td>
                    <td><c:out value="${vbooks.bookName}" /></td>
                     <td><c:out value="${vbooks.bookAuthor}" /></td>
                      <td><c:out value="${vbooks.price}" /></td>
                       <td><c:out value="${vbooks.quantity}" /></td>
                    <%--   <td><a href="${deleteUrl}">Issue</a></td> --%>
              			 <!--   <td><a href="Supplybooks">Supply</a></td> -->
 <td><a href="Supplybook?bookName=<c:out value="${vbooks.bookName}"/>&bookAuthor=<c:out value="${vbooks.bookAuthor }"/>">Supply</a></td>
              			   
             <%--     <td><a href="edit/${books.bookId}">Update</a></td> --%>
              <%--   <td><a href="<c:out value="remove/${libs.id}"/>">Delete</a></td> --%>
                    <%-- <td><a href="<spring:url value="delete/${libs.id}"/>">">Delete</a></td> --%>
                   <%--  <td><a href="/?action=edit&id=<c:out value="${libs.id}"/>">Update</a></td> --%>
                    <%-- <td><a href="delete?action=delete&id=<c:out value="${libs.id}"/>"></a></td> --%>
                </tr>
            </c:forEach>
        </tbody>
        </center>
    </table>
   <!--  <input type="submit" value="Submit"> -->
    <!-- <p><a href="UserController?action=insert">Add User</a></p> -->
</body>
</html>