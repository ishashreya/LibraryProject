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
  <li><a href="userlogin" name="hh">Home</a></li>
  <li><a href="listadminbook" name="lb">List Of Books</a></li>
  
  <li><a href="adminlogin" name="aal">Log Out</a></li>
  
</ul>
<p style="font-size:30px;">Hi Admin, You can see the list of Requests</p>

<center>

<p style="font-size:20px;">Request For Issue</p>
</center>
</head>
<body>
<form action="IssuedSuccessfully" method="GET" >
    <center>
    <table border=1>
        <thead>
            <tr>
                
                <th>Book ID</th>
                <th>UserName</th>
                <th>Book Name</th>
                <th>startDate</th>
                <th>endDate</th>
                
                
                <th colspan=2>Approve</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${issuelist}" var="issue">
                <tr>
                    <td><c:out value="${issue.bookId}" /></td>
                    <td><c:out value="${issue.userName}" /></td>
                    <td><c:out value="${issue.bookName}" /></td>
                     <td><c:out value="${issue.startDate}" /></td>
                      <td><c:out value="${issue.endDate}" /></td>
                       
                     <td><input type="checkbox" name="selected" value="${issue.issueId}"/>
                     
                     <%--  <c:out value="${issue.approved}" /> --%>
              			  <!--  <td><a href="issue">Request for Issue</a></td> -->
                
              <%--   <td><a href="<c:out value="remove/${libs.id}"/>">Delete</a></td> --%>
                    <%-- <td><a href="<spring:url value="delete/${libs.id}"/>">">Delete</a></td> --%>
                   <%--  <td><a href="/?action=edit&id=<c:out value="${libs.id}"/>">Update</a></td> --%>
                    <%-- <td><a href="delete?action=delete&id=<c:out value="${libs.id}"/>"></a></td> --%>
                </tr>
            </c:forEach>
        </tbody>
    </table>
     <input type="submit" value="Submit" name="submit"> 
    </form>
    </center>
    
    <!-- <p><a href="UserController?action=insert">Add User</a></p> -->
</body>
</html>