<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to SkillSet</title>
</head>
<body>
<form action="Admin">  
<h1>Welcome to Skillset </h1>
<br/>
<br/>
<br/>
<table>
<tr><td><input type="text" name="emailaddress"  placeholder="abc@example.com" /></td></tr>
<tr><td><input type="password" name="passwd"  placeholder="password"/></td></tr>
<tr><td rowspan="3"><input type="radio" name="role" value="admin" CHECKED>Admin
<input type="radio" name="role" value="manager">Manager
<input type="radio" name="role" value="employee">Employee</td></tr>
<tr><td><input type="submit" value="Submit" /></td></tr>
</table>

<a href="insert.jsp">New User? Register here!</a>
</form>
</body>
</html>