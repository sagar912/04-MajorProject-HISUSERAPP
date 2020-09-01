<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


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
<script src="./js/jquery-3.5.1.js"></script>
<script src="./js/app.js"></script>
<script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>

<!-- link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script> -->
<script type="text/javascript">
<%----------------------------------Start Function For  Getting Sequence of Number--------------------------------------%>



function DeleteConfirm(){
	var txt;
	var r = confirm("Are you sure you want to delete?");
	if (r == true) {
	    txt = "You pressed OK!";
	} else {
	    txt = "You pressed Cancel!";
	    event.preventDefault();
	}
}


function ActiveConfirm(){
	var txt;
	var r = confirm("Are you sure you want to Activate User?");
	if (r == true) {
	    txt = "You pressed OK!";
	} else {
	    txt = "You pressed Cancel!";
	    event.preventDefault();
	}
}
$( document ).ready(function() {

	/*  $("#adminrole").change(function(){
	        var selectedCountry = $("#adminrole").val();
	        alert(selectedCountry);
	 	       // this.form.submit(selectedCountry);
	        
	    });
 */
//	 $("#userEmail").blur(function() {
			//var element = $("#userEmail").val();
	    
	/*  $("#adminId").on('change',function(){
		 var selectedCountry = $(this).adminId("option:selected").val();
       this.form.submit();

		}); */
	
});

</script>
</head>

<body>	
	<h1>His User App</h1>

<br>
                <!-- <form action="viewUsersA">
					  <select class="adminRoleId" name ="role" id="adminRoleId">
					  <option value="Select">-Select-</option>
					  <option value="Admin">Admin</option>
					  <option value="CaseWorker">Case_Worker</option>
					  </select>
			  </form> -->
				<form:form action="viewUsersA" modelAttribute="hIS_USERS"  method="post">
			  
			  <form:select  path="viewUsersA">
						<form:option value="">-Select-</form:option>
						<form:options items="${adminrole}" />
					    </form:select>
					    
				</form:form>
			
<input type ="hidden" id="yes"></input>
	<br>
	<br>
	<table border="1" id="example" class="table">
		<thead>
         <tr>
<!--           <th></th>
 -->         <th> Name</th>
          <th>Email</th>
          <th>Action(s)</th>
         </tr>
         </thead>
         <tbody>
         <c:forEach items="${allHisUsersList}" var="accnt">
         <tr>
      <td> ${accnt.firstName} ${accnt.lastName}</td>
         <td> ${accnt.email}</td> 
         <td>
            
            <a href="updateHisUser?his_id=${accnt.his_usersId}">Edit /</a> 
        
         <c:if test="${accnt.isDeleted  eq 'NO'}">
         
              <a href="deleteHisUser?his_id=${accnt.his_usersId}" onclick="DeleteConfirm();">Delete</a>
             
             
             </c:if>
             
         <c:if test="${accnt.isDeleted  eq 'YES'}">
             
             <a href="activateHisUser?his_id=${accnt.his_usersId}"  onclick="ActiveConfirm()">Activate</a>
           </c:if>
		</td>
         </tr>
         </c:forEach>
          </tbody>
  	</table>
  	<a href="index">Home Page</a>
</body>

</html>
