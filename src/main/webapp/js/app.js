//============================================== Email Validation ============================================//


$(document).ready(function() {
		$("#ssn").blur(function() {
			var element = $("#ssn").val();

			$.ajax({
				type : "GET",
				url : "getStateBySSN/"+element,
				success : function(result) {
					if(result == "New Jersy"){
						
						$("#emailMsg").html("The Citizen Belongs to New jersy State.");
						$("#submit").prop('disabled', false);

						
					}
					else if (result != "New Jersy"){
						$("#emailMsg").html("The Citizen Doesn't Belong to New jersy State.");
						$("#submit").prop('disabled', true);


					}
				},
				error : function() {
					alert("error occured");
				}
			
			});
		});		
		
});

