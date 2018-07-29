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
<form action="Searchbyname">
<h1>Details of employee</h1>
<br/><br/>
<table border="1">
<tr>
<th>Emp ID</th><th>Emp Name</th><th>Email address</th><th>Phone number</th><th>Role</th>
</tr>
<c:set var="res" value="${requestScope.emp}"/>
<tr>
<td>${res.employeeid }</td>
<td>${res.empname}</td>
<td>${res.emailaddress}</td>
<td>${res.phonenum}</td>
<td>${res.role}</td>
</tr>
</table>
</form>
</body>
</html>