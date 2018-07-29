<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="HRcontroller">
Welcome HR!
<br/>
<br/>
<br/>
<h1>LIST OF EMPLOYEES WAITING FOR APPROVAL!</h1>
<br/>
<table border="1">
<tr>
<th>Emp ID</th><th>Emp Name</th><th>Email address</th><th>Phone number</th><th>Role</th><th>Approve</th><th>Delete</th>
</tr>
<c:forEach items="${ requestScope.lemp}" var="res">
<tr>
<td>${res.employeeid}</td>
<td>${res.empname}</td>
<td>${res.emailaddress}</td>
<td>${res.phonenum}</td>
<td>${res.role}</td>
<td><a href="approved?empid=${res.employeeid}">Approve</a></td>
<td><a href="delete?empid=${res.employeeid}">Delete</a></td>
</tr>
</c:forEach>
</table>
<br/><br/><br/>
<h1>LIST OF APPROVED EMPLOYEES!</h1>
<table  border="1">
<tr><th>Emp ID</th><th>Emp Name</th><th>Email address</th><th>Phone number</th><th>Role</th></tr>
<c:forEach var="r" items="${ requestScope.uemp }">
<tr>
<td>${r.employeeid }</td>
<td>${r.empname}</td>
<td>${r.emailaddress}</td>
<td>${r.phonenum}</td>
<td>${r.role}</td>
</tr>
</c:forEach>
</table>
</form>
</body>
</html>