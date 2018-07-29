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
<form action="/managercontroller">
<h1>Welcome Manager!</h1>
<br/>
<br/>
<table border="1">
<tr>
<th>Emp ID</th><th>Emp Name</th><th>Email address</th><th>Phone number</th><th>Role</th>
</tr>
<c:forEach items="${requestScope.lemp}" var="res">
<tr>
<td>${res.employeeid }</td>
<td>${res.empname}</td>
<td>${res.emailaddress}</td>
<td>${res.phonenum}</td>
<td>${res.role}</td>
</tr>
</c:forEach>
</table>
</form>
<br/>
<br/>
<form action="searchbyid">
Search employee by id :<input type="text" name="empid"><br/>
<input type="submit" value="Search">
</form>
 <br/><br/>
<form action="Searchbyname">
Search employee by name :<input type="text" name="empname"><br/>
<input type="submit" value="Search">
</form>

</body>
</html>