<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="./js/jquery-3.5.1.js"></script>
<script src="./js/app.js"></script>
 	<form:form action="validateUser" method="post" modelAttribute="hIS_USERS">
 	
		<table>
		<thead>
		<br>		
		<b>Login</b>
		</thead>
			<tr></tr>
			
			<tr>
				<th>User ID:</th>
				<td><form:input type="text" path="email" /></td>
			
			</tr>
			<tr>
				<th>Password:</th>
				<td><form:input type="password" path="pwd" /></td>
			
			</tr>
			<tr>
				<td><input type="submit" value="Reset">&nbsp;<input
					type="submit" value="Login"></td>
			</tr>
				
		</table>
	</form:form>
	<br>
	<span id="emailMsg" style="color: red" >${ErrorMsg}</span>
	<span id="lockedMsg" style="color: red">${LockedMsg}</span>
	<br>
	<br>
	<a href="index">HIS User</a>&nbsp;
	<a href="loadPlan">HIS Plans</a>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

</body>
</html>
