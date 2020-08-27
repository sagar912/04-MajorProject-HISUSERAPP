<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<head>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>

<!-- link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script> -->
<script type="text/javascript">

$(document).ready(function() {
    $('#example').DataTable( {
        "pagingType": "full_numbers"
    } );


    
} );

<%----------------------------------Start Function For  Getting Sequence of Number--------------------------------------%>



function DeleteConfirm(){
	var txt;
	var r = confirm("Are you sure you want to Plan?");
	if (r == true) {
	    txt = "You pressed OK!";
	} else {
	    txt = "You pressed Cancel!";
	    event.preventDefault();
	}
}


function ActiveConfirm(){
	var txt;
	var r = confirm("Are you sure you want to Activate Plan?");
	if (r == true) {
	    txt = "You pressed OK!";
	} else {
	    txt = "You pressed Cancel!";
	    event.preventDefault();
	}
}
</script>
</head>

<body>	

<!-- <label for="cars">Choose a car:</label>

<select name="roles" id="adminRoles">
  <option value="">-Select-</option>
  <option value=1>Admin</option>
  <option value=2>Case_Worker</option>
  
</select> -->
	<h1>Plans Available</h1>
	
	<table border="1" id="example" class="table">
		<thead>
         <tr>
          <th> Name</th>
          <th>Email</th>
           <th>Plan Start Date</th>
          <th>Plan Start Date</th>
          <th>Action(s)</th>
         </tr>
         </thead>
         <tbody>
         <c:forEach items="${allPlansList}" var="accnt">
         <tr>
        <td> ${accnt.planName}</td>
         <td> ${accnt.planDescription}</td>
         <td> ${accnt.planStartDate}</td>
         <td> ${accnt.planEndDate}</td>
         <td>
            
            <a href="updatePlans?planId=${accnt.planId}">Edit /</a> 
        
         <c:if test="${accnt.isPlanDeleted  eq 'NO'}">
         
              <a href="deleteplans?planId=${accnt.planId}" onclick="DeleteConfirm();">Delete</a>
             
             
             </c:if>
             
         <c:if test="${accnt.isPlanDeleted  eq 'YES'}">
             
             <a href="activateplan?planId=${accnt.planId}"  onclick="ActiveConfirm()">Activate</a>
           </c:if>
		</td>
         </tr>
         </c:forEach>
         </tbody>
  	</table>
  	<a href="index">Home Page</a>
</body>

</html>
