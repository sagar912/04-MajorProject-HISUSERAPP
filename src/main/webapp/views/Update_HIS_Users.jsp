<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${Msg}</h1>
	<h2>
<font color='green'>${list}</font>
 	</h2>
	<form:form action="registerContact"  modelAttribute="book"  method="POST">
		<table>
     <c:forEach items="${list}" var="b">
		
		     <tr>
				<td>Book Id:</td>
				<td>${b.bookid}</td>
			</tr>
			<tr>
				<td>Book Name:</td>
				<td>${b.bookname}</td>
			</tr>
			<tr>
				<td>Author Name:</td>
				<td>${b.bookauther}</td>
			</tr>
			<tr>
				<td>Book Price:</td>
				<td>${b.bookprice}</td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset" /></td>
				<td><input type="submit" value="Register" /></td>
			</tr>
			         </c:forEach>
			
		</table>
	</form:form>
	<a href="registerContact">Home</a>
	</body>
