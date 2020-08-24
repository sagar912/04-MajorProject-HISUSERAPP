//================================================== Loading States Based on Countries ==============================================================//

$(document).ready(function() {
		$("#adminRoles").change(function() {
			

			$.ajax({
				type : "GET",
				url :"getHisUsers?adminRoles="+$("#adminRoles").val(),
				success : function(response) {
				
					response=allHisUsersList;
				},
				error : function() {
					alert("error occured");
				}
			
			});
		});		
		
});

//================================================== Loading Cities Based on States ==============================================================//

$(document).ready(function() {
	$("#stateId").change(function() {
			
		$("#cityId").find('option').remove();
		$('<option>').val('').text('-Select-').appendTo("#cityId");

		$.ajax({
			type : "GET",
			url :"getCities?stateid="+$("#stateId").val(),
			success : function(response) {
					$.each(response,function(cityId,cityName){
					$('<option>').val(cityId).text(cityName).appendTo("#cityId");
				});
			},
			error : function() {
				alert("error occured");
			}
		
		});
	});		
	
});

//============================================== Email Validation ============================================//


$(document).ready(function() {
		$("#userEmail").blur(function() {
			var element = $("#userEmail").val();

			$.ajax({
				type : "GET",
				url : "validateEmail?checkemail="+ element,
				success : function(result) {
					if(result == "Duplicate"){
						$("#emailMsg").html("Email Already Exists.");
						$("#userEmail").focus();
					}
					else if (result == "false"){
						$("#emailMsg").html("");
					}else{
						$("#emailMsg").html("");

					}
				},
				error : function() {
					alert("error occured");
				}
			
			});
		});		
		
});
