<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
<!-- <link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.0/css/jquery.dataTables_themeroller.css">
 --> <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="./js/jquery-3.5.1.js"></script>
<script src="./js/app.js"></script>


  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Datepicker - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
	<h1>HIS Registration Form</h1>
	  <h2><font color='green'>${SaveMsg}</font></h2>
	
		<form:form action="register"  modelAttribute="hIS_USERS" method="post">
		<table>
			<tr>
                <form:hidden path="his_usersId"/>
                 <form:hidden path="pwd"/>
                  <form:hidden path="isDeleted"/>
                  <form:hidden path="isActive"/>
                 
                
				<td>First Name:</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" /></td>
			</tr><br>
			<tr>
				<th>Gender:</th>
				<td>Male:<form:radiobutton   path="gender"  value="M" id="gender" /> &nbsp;Female:<form:radiobutton path="gender" value="F" id="gender" />
				</td><br>
			</tr>
			 <tr>
				<th>Role:</th>
				<td>
				
				
				<form:select path="adminRoleId">
						<form:option value="">-Select-</form:option>
						<form:options items="${adminrole}" />
					    </form:select></td>
			</tr> 
			<tr>
				<td><input type="reset" value="Reset" /></td>
				<td><input type="submit" value="Register" /></td>
			</tr>
		</table>
	</form:form>
	
	  <a href="viewUsers">View All Pages</a>
</body>
</html>