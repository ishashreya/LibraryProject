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
  <li><a href="userlogin" name="hm">Home</a></li>
  
  <li><a href="listuser?user=${user}" name="uu">View Previous Logs</a></li>
  <!-- <li><a href="listBook">List Of Books</a> -->
  
  <li><a href="userlogin" name="ul">Log Out</a></li>
  
</ul>
<p style="font-size:15px;">Welcome ${user.username}</p>

<center>
<p style="font-size:30px;">Search Book</p>
</head>
<body>
<form action="listbook" method="GET" >
    <table border=1>
        <thead>
            <tr>
                
                <th>Book ID</th>
                <th>Book Name</th>
                <th>Book Author</th>
                <th>Price</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listbooks}" var="books">
                <tr>
                    <td><c:out value="${books.bookId}" /></td>
                    <td><c:out value="${books.bookname}" /></td>
                     <td><c:out value="${books.bookAuthor}" /></td>
                      <td><c:out value="${books.price}" /></td>
                    <%--   <td><a href="${deleteUrl}">Issue</a></td> --%>
     <td><a href="issue?bid=<c:out value="${books.bookId}"/>&bookname=<c:out value="${book.bookname }"/>&username=<c:out value="${user.username }"/>">Request for Issue</a></td>
                  <!-- <td><a href="UpdateBook">Update</a></td> -->
              <%--   <td><a href="<c:out value="remove/${libs.id}"/>">Delete</a></td> --%>
                    <%-- <td><a href="<spring:url value="delete/${libs.id}"/>">">Delete</a></td> --%>
                   <%--  <td><a href="/?action=edit&id=<c:out value="${libs.id}"/>">Update</a></td> --%>
                    <%-- <td><a href="delete?action=delete&id=<c:out value="${libs.id}"/>"></a></td> --%>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </form>
    </body>
    </center>
    <!-- <input type="submit" value="Submit"> -->
    <!-- <p><a href="UserController?action=insert">Add User</a></p> -->
</body>
</html>
