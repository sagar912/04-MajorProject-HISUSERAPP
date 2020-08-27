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
  <script>

  $( function() {
    $( "#planStartDate" ).datepicker();
    $( "#planEndDate" ).datepicker();
    
  } );
  </script>
  
</head>
<body>
	<h1>HIS Registration Form</h1>
	  <h2><font color='green'>${SaveMsg}</font></h2>
	  <h2><font color='red'>${ErrorMsg}</font></h2>
	  
	
		<form:form action="registerPlan"  modelAttribute="plan" method="post">
		<table>
		<%-- 	<tr>
			    <c:if test="${planId == 0}">
                   <form:hidden path="planId"/>
              
             </c:if>
                <c:if test="${planId !=0}">
                    <td>Plan Id:</td>
			        <td><form:input path="planId" /></td>                
             </c:if>
          
             </tr> --%>
             <tr>
				<td>Plan Name:</td>
				<td><form:input path="planName" /></td>
			</tr>
			<tr>
				<td>Plan Description:</td>
				<td><form:input path="planDescription" /></td>
			</tr>
			<tr>
				<td>Plan Start Date:</td>
				<td><form:input path="planStartDate" /></td>
			</tr><br>
			<tr>
				<td>Plan End Date:</td>
				<td><form:input path="planEndDate" /></td>
			</tr><br>
			
			 
			<tr>
				<td><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				
				<input type="submit" value="Add Plans" /></td>
			</tr>
		</table>
	</form:form>
	<br>&nbsp;&nbsp;&nbsp;
	  <a href="viewAllplans">View All Plans</a>
</body>
</html>