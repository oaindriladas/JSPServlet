<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="NewUser" method="get">
<h1>Add new records</h1>
<br/><br/><table>
<tr>
<td>Enter id :</td>
<td><input type="text" name="empid"  placeholder="1" /></td></tr>
<tr><td>Enter name :</td>
<td><input type="text" name="name"  placeholder="abc" /></td></tr>
<tr>  
<td>Enter email id :</td>
<td><input type="text" name="emailaddress"  placeholder="abc@example.com" /></td></tr>
<tr><td>Enter password :</td>
<td><input type="password" name="passwd"  placeholder="password" /></td></tr>
<tr><td>Enter phone number: </td>
<td><input type="text" name="phone"  placeholder="123456" /></td></tr>
<tr><td>Enter role : </td>
<td><input type="radio" name="role" value="manager" />Manager
<input type="radio" name="role" value="employee" />Employee</td></tr>
 <tr>           
<td colspan="2"><input type="submit" value="register" /></td></tr>
</table>
</form>
</body>
</html>